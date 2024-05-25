import React, { useState } from 'react';
import { View, StyleSheet, TextInput, Button, Alert } from 'react-native';
import { WebView, WebViewMessageEvent } from 'react-native-webview';

interface Marker {
    lat: number;
    lon: number;
    type: string;
    name: string;
}

const AddInterestPointsMap: React.FC = () => {
    const [markers, setMarkers] = useState<Marker[]>([]);
    const [poiType, setPoiType] = useState('');
    const [poiName, setPoiName] = useState('');
    const [latitude, setLatitude] = useState('');
    const [longitude, setLongitude] = useState('');

    const generateMarkersJS = () => {
        return markers.map((marker) => `
      var icon = L.icon({
        iconUrl: '${getIconUrl(marker.type)}',
        iconSize: [32, 32],
        iconAnchor: [16, 32],
        popupAnchor: [0, -32],
      });
      L.marker([${marker.lat}, ${marker.lon}], { icon }).addTo(map).bindPopup('${marker.name}');
    `).join('');
    };

    const getIconUrl = (type: string) => {
        switch (type) {
            case 'cinema':
                return 'https://cdnjs.cloudflare.com/ajax/libs/leaflet/1.7.1/images/marker-icon.png'; // URL icona cinema
            case 'restaurant':
                return 'https://cdnjs.cloudflare.com/ajax/libs/leaflet/1.7.1/images/marker-icon.png'; // URL icona ristorante
            default:
                return 'https://cdnjs.cloudflare.com/ajax/libs/leaflet/1.7.1/images/marker-icon.png'; // Icona predefinita
        }
    };

    const handleAddInterestPoint = () => {
        const lat = parseFloat(latitude);
        const lon = parseFloat(longitude);

        if (!poiType || !poiName || isNaN(lat) || isNaN(lon)) {
            Alert.alert('Errore', 'Si prega di inserire il tipo, il nome e le coordinate valide del punto di interesse.');
            return;
        }

        // Aggiungi il punto di interesse alla lista dei marker
        setMarkers([...markers, { lat, lon, type: poiType, name: poiName }]);
        // Resetta i campi di input
        setPoiType('');
        setPoiName('');
        setLatitude('');
        setLongitude('');
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
            <WebView
                source={{ html: htmlContent }}
                onMessage={handleMessage}
            />
            <View style={styles.inputContainer}>
                <TextInput
                    style={styles.input}
                    placeholder="Tipo di punto di interesse"
                    value={poiType}
                    onChangeText={setPoiType}
                />
                <TextInput
                    style={styles.input}
                    placeholder="Nome del punto di interesse"
                    value={poiName}
                    onChangeText={setPoiName}
                />
                <TextInput
                    style={styles.input}
                    placeholder="Latitudine"
                    value={latitude}
                    onChangeText={setLatitude}
                    keyboardType="numeric"
                />
                <TextInput
                    style={styles.input}
                    placeholder="Longitudine"
                    value={longitude}
                    onChangeText={setLongitude}
                    keyboardType="numeric"
                />
                <Button title="Aggiungi Punto di Interesse" onPress={handleAddInterestPoint} />
            </View>
        </View>
    );
};

const styles = StyleSheet.create({
    container: {
        flex: 1,
    },
    inputContainer: {
        paddingHorizontal: 16,
        paddingBottom: 16,
    },
    input: {
        marginBottom: 8,
        padding: 8,
        borderWidth: 1,
        borderColor: '#ccc',
        borderRadius: 8,
    },
});

export default AddInterestPointsMap;