package com.it.unicam.progetto_ids_2023.test;
import com.it.unicam.progetto_ids_2023.controller.ContenutoManager;
import com.it.unicam.progetto_ids_2023.controller.SegnalazioniManager;
import com.it.unicam.progetto_ids_2023.model.contenuto.Contenuto;
import com.it.unicam.progetto_ids_2023.model.contenuto.ContenutoMultimediale;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ContenutoTest {



        @Test
        public void testSegnalazioni() {


                // Crea un'istanza di ContenutoManager
                ContenutoManager contenutoManager = new ContenutoManager();

                // Crea un'istanza di SegnalazioniManager
            SegnalazioniManager segnalazioniManager = new SegnalazioniManager();


            // Crea un contenuto
                Contenuto contenuto = new ContenutoMultimediale("test.jpg", true);

                // Aggiungi il contenuto a ContenutoManager
                contenutoManager.addContenuto(contenuto);

                // Segnala il contenuto
                boolean segnalazioneRiuscita = contenutoManager.segnalaContenuto(segnalazioniManager, contenuto);

                // Verifica che la segnalazione sia riuscita
                assertTrue(segnalazioneRiuscita);
                assertTrue(contenuto.isPending());

                // Rifiuta il contenuto
                segnalazioniManager.rifiutaContenuto(contenuto);
                assertFalse(contenuto.isPending());

                // Verifica che il contenuto sia stato rimosso da ContenutoManager
                assertFalse(contenutoManager.getContenuti().contains(contenuto));
            }

        }


