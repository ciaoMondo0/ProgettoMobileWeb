import React, { createContext, useState, useContext, ReactNode } from 'react';
import { NavigationContainer } from '@react-navigation/native';
import { createStackNavigator } from '@react-navigation/stack';
import HomeScreen from './Views/HomeScreen';
import LoginScreen from './Views/LoginScreen';
import AddInterestPointScreen from './Views/AddInterestPointScreen';
import AddContentScreen from './Views/AddContentScreen';
import ViewContentsScreen, { Marker } from './Views/ViewContentsScreen';
import { Alert } from "react-native";
import axios from 'axios';

interface User {
    id: number;
    nome: string;
    email: string;
    ruolo: string;
    autorizzatoCreazioneContenuto: boolean;
}

interface AuthContextProps {
    user: User | null;
    login: (email: string, password: string) => Promise<void>;
    logout: () => void;
}

const AuthContext = createContext<AuthContextProps | undefined>(undefined);

export const useAuth = () => {
    const context = useContext(AuthContext);
    if (!context) {
        throw new Error('useAuth deve essere usato in un AuthProvider');
    }
    return context;
};

interface AuthProviderProps {
    children: ReactNode;
}

const AuthProvider: React.FC<AuthProviderProps> = ({ children }) => {
    const [user, setUser] = useState<User | null>(null);

    const login = async (email: string, password: string) => {
        try {
            const response = await axios.post<User>('http://10.0.2.2:8080/utenti/login', { email, password });
            setUser(response.data);
        } catch (error) {
            Alert.alert('Errore', 'Login fallito');
        }
    };

    const logout = () => {
        setUser(null);
    };

    return (
        <AuthContext.Provider value={{ user, login, logout }}>
            {children}
        </AuthContext.Provider>
    );
};

export type RootStackParamList = {
    Home: { user: User } | undefined;
    Login: undefined;
    AddInterestPoint: { user: User };
    AddContent: { user: User };
    ViewContents: { markers: Marker[] };
};

const Stack = createStackNavigator<RootStackParamList>();

const App = () => {
    return (
        <AuthProvider>
            <NavigationContainer>
                <Stack.Navigator initialRouteName="Home">
                    <Stack.Screen name="Home" component={HomeScreen} />
                    <Stack.Screen name="Login" component={LoginScreen} />
                    <Stack.Screen name="AddInterestPoint" component={AddInterestPointScreen} />
                    <Stack.Screen name="AddContent" component={AddContentScreen} />
                    <Stack.Screen name="ViewContents" component={ViewContentsScreen} />
                </Stack.Navigator>
            </NavigationContainer>
        </AuthProvider>
    );
};

export default App;
