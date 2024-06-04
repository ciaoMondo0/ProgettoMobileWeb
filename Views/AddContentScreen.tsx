import React, { useState } from 'react';
import { View, TextInput, Button, StyleSheet, Alert } from 'react-native';
import axios from 'axios';
import { useNavigation } from '@react-navigation/native';

const AddContentScreen: React.FC = () => {
    const navigation = useNavigation();
    const [poiName, setPoiName] = useState('');
   // const [poiContent, setPoiContent] = useState('');
    const [contentName, setContentName] = useState('');
    const [contentType, setContentType] = useState('');
    const [contentText, setContentText] = useState('');
    const [contentFile, setContentFile] = useState('');

    const handleAddContent = async () => {
        const payload = {
            nomeContenuto: contentName,
            nomePOI: poiName,
            tipo: contentType,
            testo: contentText,
            utenteId: 1,
            file: contentFile,
        };

        console.log("Payload inviato al server:", payload);

        try {
            await axios.post('http://10.0.2.2:8080/contenuti/add', payload);
            Alert.alert('Successo', 'Contenuto aggiunto con successo.');
            navigation.goBack();
        } catch (error) {
            console.error("Errore durante l'aggiunta del contenuto:", error);
            Alert.alert('Errore', 'Aggiunta del contenuto fallita.');
        }
    };


    return (
        <View style={styles.container}>
            <TextInput
                style={styles.input}
                placeholder="Nome del punto di interesse"
                value={poiName}
                onChangeText={setPoiName}
            />
            <TextInput
                style={styles.input}
                placeholder="Nome del contenuto"
                value={contentName}
                onChangeText={setContentName}
            />
            <TextInput
                style={styles.input}
                placeholder="Tipo del contenuto"
                value={contentType}
                onChangeText={setContentType}
            />
            <TextInput
                style={styles.input}
                placeholder="Testo del contenuto"
                value={contentText}
                onChangeText={setContentText}
            />
            <TextInput
                style={styles.input}
                placeholder="URL del file multimediale"
                value={contentFile}
                onChangeText={setContentFile}
            />
            <Button title="Aggiungi Contenuto" onPress={handleAddContent} />
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

export default AddContentScreen;