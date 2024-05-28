import axios from 'axios';

const BASE_URL = 'http://localhost:8080';

export const getComuni = async () => {
    try {
        const response = await axios.get(`${BASE_URL}/comuni`);
        return response.data;
    } catch (error) {
        console.error('Errore durante il recupero dei comuni:', error);
        throw error;
    }
};

export const addComune = async (nome, descrizione, coordinate) => {
    try {
        const response = await axios.post(`${BASE_URL}/comuni/add/comune`, null, {
            params: {
                nome,
                descrizione,
                coordinate: JSON.stringify(coordinate),
            },
        });
        return response.data;
    } catch (error) {
        console.error('Errore durante l\'aggiunta di un comune:', error);
        throw error;
    }
};

export const addPuntoDiInteresse = async (nome, descrizione, categorie, comuneId) => {
    try {
        const response = await axios.post(`${BASE_URL}/puntodiinteresse/add`, null, {
            params: {
                nome,
                descrizione,
                categorie,
                comuneId,
            },
        });
        return response.data;
    } catch (error) {
        console.error('Errore durante l\'aggiunta di un punto di interesse:', error);
        throw error;
    }
};

export const getPuntiDiInteresse = async () => {
    try {
        const response = await axios.get(`${BASE_URL}/puntodiinteresse/puntodiinteresse`);
        return response.data;
    } catch (error) {
        console.error('Errore durante  dei punti di interesse:', error);
        throw error;
    }
};