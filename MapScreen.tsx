import React, { useEffect, useState } from 'react';
import { View, StyleSheet, Button, TextInput } from 'react-native';
import { WebView } from 'react-native-webview';
import AsyncStorage from '@react-native-async-storage/async-storage';

const MapScreen = () => {
    const [markers, setMarkers] = useState<{ latitude: number; longitude: number; }[]>([]);


    const [latitude, setLatitude] = useState('');
    const [longitude, setLongitude] = useState('');

    useEffect(() => {
        const getMarkers = async () => {
            try {
                const savedMarkers = await AsyncStorage.getItem('markers');
                if (savedMarkers !== null) {
                    setMarkers(JSON.parse(savedMarkers));
                }
            } catch (error) {
                console.error(error);
            }
        };

        getMarkers();
    }, []);

    const addMarker = async () => {
        try {
            const newMarker = {
                latitude: parseFloat(latitude),
                longitude: parseFloat(longitude)
            };
            const newMarkers = [...markers, newMarker];
            await AsyncStorage.setItem('markers', JSON.stringify(newMarkers));
            setMarkers(newMarkers);
        } catch (error) {
            console.error(error);
        }
    };

    const uri = `https://www.openstreetmap.org/export/embed.html?bbox=${markers.map(marker => `${marker.longitude},${marker.latitude}`).join(';')}&layer=mapnik&marker=${markers.map(marker => `${marker.latitude},${marker.longitude}`).join(';')}`;

    return (
        <View style={styles.container}>
            <WebView
                source={{ uri }}
                style={styles.map}
            />
            <TextInput
                style={styles.input}
                onChangeText={setLatitude}
                value={latitude}
                placeholder="Inserisci la latitudine"
                keyboardType="numeric"
            />
            <TextInput
                style={styles.input}
                onChangeText={setLongitude}
                value={longitude}
                placeholder="Inserisci la longitudine"
                keyboardType="numeric"
            />
            <Button title="Aggiungi Marker" onPress={addMarker} />
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
    input: {
        height: 40,
        borderColor: 'gray',
        borderWidth: 1,
    },
});

export default MapScreen;