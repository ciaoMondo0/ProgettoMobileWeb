interface Content {
    id: string | number;
    nome: string;
    testo: string;
    filepath?: string;
}
export interface Marker {
    lat: number;
    lon: number;
    type: string;
    name: string;
    content: string;
}

import React, { useEffect, useState } from 'react';
import { View, Text, FlatList, Image, StyleSheet } from 'react-native';

const ViewContentsScreen: React.FC = () => {
    const [contents, setContents] = useState<Content[]>([]);

    useEffect(() => {
        const loadContents = async () => {
            try {
                const response = await fetch('http://10.0.2.2:8080/contenuti/');
                const contentsData: Content[] = await response.json();
                setContents(contentsData);
            } catch (error) {
                console.error("Errore durante il caricamento dei contenuti:", error);
            }
        };

        loadContents();
    }, []);

    const renderItem = ({ item }: { item: Content }) => (
        <View style={styles.contentItem}>
            <Text style={styles.title}>{item.nome}</Text>
            <Text>{item.testo}</Text>
            {}
            {item.filepath && (
                <Image
                    source={{ uri: item.filepath }}
                    style={styles.image}
                />
            )}
        </View>
    );

    return (
        <View style={styles.container}>
            <FlatList
                data={contents}
                keyExtractor={(item) => item.id.toString()}
                renderItem={renderItem}
            />
        </View>
    );
};

const styles = StyleSheet.create({
    container: {
        flex: 1,
        padding: 16,
    },
    contentItem: {
        backgroundColor: '#f9c2ff',
        borderRadius: 10,
        padding: 20,
        marginVertical: 8,
    },
    title: {
        fontSize: 18,
        fontWeight: 'bold',
    },
    image: {
        width: 100,
        height: 100,
        marginTop: 10,
    },
});

export default ViewContentsScreen;