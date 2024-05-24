import React from 'react';
import { StyleSheet } from 'react-native';
import { LeafletView, Marker } from 'react-native-leaflet-view';

const MapScreen: React.FC = () => {
    // Array di coordinate dei marker
    const markers: LatLng[] = [
        { latitude: 43.2827, longitude: 13.4515 }, // Esempio di coordinata
        // Aggiungi altre coordinate qui se necessario
    ];

    return (
        <LeafletView
            style={styles.map}
            initialRegion={{ latitude: 43.2827, longitude: 13.4515, latitudeDelta: 0.0922, longitudeDelta: 0.0421 }}
            zoom={13}
        >
            {markers.map((coordinate, index) => (
                <Marker key={index} position={coordinate} />
            ))}
        </LeafletView>
    );
};

const styles = StyleSheet.create({
    map: {
        flex: 1,
    },
});

export default MapScreen;