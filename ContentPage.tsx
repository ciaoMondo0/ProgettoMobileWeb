import React, { useState } from 'react';
import { View, Text, TextInput, Button, FlatList, StyleSheet } from 'react-native';
import { RouteProp, useRoute, useNavigation } from '@react-navigation/native';

interface Marker {
    lat: number;
    lon: number;
    type: string;
    name: string;
    content: string[];
}

type ContentPageRouteProp = RouteProp<{ params: { marker: Marker, index: number, markers: Marker[], setMarkers: React.Dispatch<React.SetStateAction<Marker[]>> } }, 'params'>;

const ContentPage: React.FC = () => {
    const route = useRoute<ContentPageRouteProp>();
    const { marker, index, markers, setMarkers } = route.params;
    const [newContent, setNewContent] = useState('');

    const handleAddContent = () => {
        if (newContent.trim() === '') return;

        const updatedMarkers = markers.map((m, i) => i === index ? { ...m, content: [...m.content, newContent] } : m);
        setMarkers(updatedMarkers);
        setNewContent('');
    };

    return (
        <View style={styles.container}>
            <Text style={styles.title}>{marker.name}</Text>
            <Text style={styles.subtitle}>Aggiungi contenuto:</Text>
            <TextInput
                style={styles.input}
                placeholder="Nuovo contenuto"
                value={newContent}
                onChangeText={setNewContent}
            />
            <Button title="Aggiungi" onPress={handleAddContent} />
            <FlatList
                data={marker.content}
                keyExtractor={(item, index) => index.toString()}
                renderItem={({ item }) => <Text style={styles.contentItem}>{item}</Text>}
            />
        </View>
    );
};

const styles = StyleSheet.create({
    container: {
        flex: 1,
        padding: 16,
    },
    title: {
        fontSize: 24,
        fontWeight: 'bold',
        marginBottom: 16,
    },
    subtitle: {
        fontSize: 18,
        marginBottom: 8,
    },
    input: {
        marginBottom: 8,
        padding: 8,
        borderWidth: 1,
        borderColor: '#ccc',
        borderRadius: 8,
    },
    contentItem: {
        padding: 8,
        borderBottomWidth: 1,
        borderBottomColor: '#ccc',
    },
});

export default ContentPage;