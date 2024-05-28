import React, { createContext, useState, useContext, ReactNode } from 'react';
import { NavigationContainer } from '@react-navigation/native';
import { createStackNavigator } from '@react-navigation/stack';
import axios from 'axios';
import HomeScreen from './Views/HomeScreen.tsx';
import LoginScreen from './Views/LoginScreen.tsx';
import AddInterestPointScreen from './Views/AddInterestPointScreen.tsx';
import AddContentScreen from './Views/AddContentScreen.tsx';
import ViewContentsScreen, { Marker } from './Views/ViewContentsScreen.tsx';
import {Alert} from "react-native";


interface User {
    username: string;
    role: string;
}

interface AuthContextProps {
    user: User | null;
    login: (username: string, password: string) => Promise<void>;
    logout: () => void;
}

const AuthContext = createContext<AuthContextProps | undefined>(undefined);

export const useAuth = () => {
    const context = useContext(AuthContext);
    if (!context) {
        throw new Error('');
    }
    return context;
};

interface AuthProviderProps {
    children: ReactNode;
}

const AuthProvider: React.FC<AuthProviderProps> = ({ children }) => {
    const [user, setUser] = useState<User | null>(null);

    const login = async (username: string, password: string) => {
        try {
            const response = {
                username: "MarioRossi",
                role: "admin"
            };
            setUser(response);
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
    Home: undefined;
    Login: undefined;
    AddInterestPoint: undefined;
    AddContent: undefined;
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


