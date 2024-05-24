import React from 'react';
import { View, StyleSheet } from 'react-native';
import { WebView } from 'react-native-webview';

const MapScreen: React.FC = () => {
    return (
        <View style={styles.container}>
            <WebView
                source={{ uri: 'https://www.openstreetmap.org' }}
                style={styles.map}
            />
        </View>
    );
};

const styles = StyleSheet.create({
    container: {
        flex: 1,
    },
    map: {
        flex: 1,
    },
});

export default MapScreen;