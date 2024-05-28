import React, { useState, useEffect } from 'react';
import { View, Button, StyleSheet, Alert } from 'react-native';
import { WebView, WebViewMessageEvent } from 'react-native-webview';
import { useNavigation, NavigationProp } from '@react-navigation/native';
import axios from 'axios';
import { useAuth } from '../App.tsx';
import { RootStackParamList } from '../App.tsx';

interface Marker {
    lat: number;
    lon: number;
    type: string;
    name: string;
    content: string;
}

interface Coordinate {
    longitudine: number;
    latitudine: number;
}

interface PointOfInterest {
    id: number;
    nome: string;
    descrizione: string;
    categorie: string;
    coordinate: Coordinate;
}

const BASE_URL = 'http://192.168.1.173:8080/puntodiinteresse/';

const HomeScreen: React.FC = () => {
    const { user, logout } = useAuth();
    const navigation = useNavigation<NavigationProp<RootStackParamList>>();
    const [markers, setMarkers] = useState<Marker[]>([]);


    useEffect(() => {
        const fetchMarkers = async () => {
            try {
                const response = await axios.get<PointOfInterest[]>(BASE_URL);

                const extractedData = response.data.map((punto: PointOfInterest) => ({
                    lat: punto.coordinate.latitudine,
                    lon: punto.coordinate.longitudine,
                    type: punto.categorie,
                    name: punto.nome,
                    content: punto.descrizione,
                }));
                setMarkers(extractedData);
            } catch (error) {
                console.error('Errore durante il recupero dei punti di interesse:', error);
            }
        };
        fetchMarkers();
    }, []);

    const generateMarkersJS = () => {
        return markers.map((marker) => `
      var icon = L.icon({
        iconUrl: '${getIconUrl(marker.type)}',
        iconSize: [32, 32],
        iconAnchor: [16, 32],
        popupAnchor: [0, -32],
      });
      L.marker([${marker.lat}, ${marker.lon}], { icon }).addTo(map).bindPopup('${marker.name}<br>${marker.content}');
    `).join('');
    };

    const getIconUrl = (type: string) => {
        switch (type) {
            case 'cinema':
                return 'https://cdnjs.cloudflare.com/ajax/libs/leaflet/1.7.1/images/marker-icon.png';
            case 'restaurant':
                return 'https://cdnjs.cloudflare.com/ajax/libs/leaflet/1.7.1/images/marker-icon.png';
            default:
                return 'https://cdnjs.cloudflare.com/ajax/libs/leaflet/1.7.1/images/marker-icon.png';
        }
    };

    const htmlContent = `
    <!DOCTYPE html>
    <html>
      <head>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <script src="https://cdnjs.cloudflare.com/ajax/libs/leaflet/1.7.1/leaflet.js"></script>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/leaflet/1.7.1/leaflet.css" />
        <style>
          #map { height: 100vh; }
        </style>
      </head>
      <body>
        <div id="map"></div>
        <script>
          var map = L.map('map').setView([43.3004, 13.4537], 13);
          L.tileLayer('https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png').addTo(map);
          ${generateMarkersJS()}
        </script>
      </body>
    </html>
  `;

    const handleMessage = (event: WebViewMessageEvent) => {
        const data = JSON.parse(event.nativeEvent.data);
        console.log('Message received from WebView:', data);
    };

    return (
        <View style={styles.container}>
            <WebView source={{ html: htmlContent }} onMessage={handleMessage} />
            {user ? (
                <>
                    <Button title="Logout" onPress={logout} />
                    <Button title="Aggiungi Punto di Interesse" onPress={() => navigation.navigate('AddInterestPoint')} />
                    <Button title="Aggiungi Contenuto" onPress={() => navigation.navigate('AddContent')} />
                    <Button title="Visualizza Contenuti" onPress={() => navigation.navigate('ViewContents', { markers })} />
                </>
            ) : (
                <Button title="Login" onPress={() => navigation.navigate('Login')} />
            )}
        </View>
    );
};

const styles = StyleSheet.create({
    container: {
        flex: 1,
    },
});

export default HomeScreen;
