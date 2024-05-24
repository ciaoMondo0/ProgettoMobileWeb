import React, { useState } from 'react';
import { View } from 'react-native';
import LoginScreen from './LoginScreen';
import MapScreen from './MapScreen';

const App: React.FC = () => {
    const [isLoggedIn, setIsLoggedIn] = useState<boolean>(false);

    const handleLogin = () => {
        setIsLoggedIn(true);
    };



    return (
        <View style={{ flex: 1 }}>
            {isLoggedIn ? <MapScreen initialRegion={{ latitude: 43.2827, longitude: 13.4515, latitudeDelta: 0.0922, longitudeDelta: 0.0421 }} /> : <LoginScreen onLogin={handleLogin} />}
        </View>
    );
};

export default App;