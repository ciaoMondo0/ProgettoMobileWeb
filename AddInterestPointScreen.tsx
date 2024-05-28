import React, { useState } from 'react';
import { View, TextInput, Button, StyleSheet, Alert } from 'react-native';
import axios from 'axios';
import { useNavigation } from '@react-navigation/native';
import { useAuth } from './App';

const AddInterestPointScreen: React.FC = () => {
    const { user } = useAuth();
    const navigation = useNavigation();
    const [poiType, setPoiType] = useState('');
    const [poiName, setPoiName] = useState('');
    const [latitude, setLatitude] = useState('');
    const [longitude, setLongitude] = useState('');

    const handleAddInterestPoint = async () => {
        const lat = parseFloat(latitude);
        const lon = parseFloat(longitude);

        if (!poiType || !poiName || isNaN(lat) || isNaN(lon)) {
            Alert.alert('Errore', 'Inserire il tipo, il nome e le coordinate valide del punto di interesse.');
            return;
        }

        const payload = {
            nome: poiName,
            descrizione: "",
            categorie: poiType,
            comuneId: 1,
            coordinate: { latitudine: lat, longitudine: lon },
        };

        try {
            await axios.post('http://192.168.1.173:8080/puntodiinteresse/add', payload);
            Alert.alert('Successo', 'Punto di interesse aggiunto con successo.');
            navigation.goBack();
        } catch (error) {
            console.error("Errore durante l'aggiunta del punto di interesse:", error);
            Alert.alert('Errore', 'Aggiunta del punto di interesse fallita.');
        }
    };

    return (
        <View style={styles.container}>
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
    );
};

const styles = StyleSheet.create({
    container: {
        flex: 1,
        justifyContent: 'center',
        padding: 16,
    },
    input: {
        height: 40,
        borderColor: 'gray',
        borderWidth: 1,
        marginBottom: 12,
        padding: 8,
    },
});

export default AddInterestPointScreen;
