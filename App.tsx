import React from 'react';
import { View, StyleSheet, Platform } from 'react-native';
import { WebView } from 'react-native-webview';

const MapScreen = () => {
    const osmUrl = Platform.select({
        ios: 'https://www.openstreetmap.org',
        android: 'https://www.openstreetmap.org',
        default: 'https://www.openstreetmap.org',
    });

    return (
        <View style={styles.container}>
            <WebView source={{ uri: osmUrl }} style={styles.map} />
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