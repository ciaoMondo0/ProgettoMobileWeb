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
            {isLoggedIn ? <MapScreen /> : <LoginScreen onLogin={handleLogin} />}
        </View>
    );
};

export default App;