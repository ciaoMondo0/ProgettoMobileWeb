Il progetto sulla valorizzazione di un territorio è stato sviluppato attraverso Java e SpringBoot ed è testabile con Swagger accedendo a questo link 
http://localhost:8080/swagger-ui/index.html.

La parte frontend è stata sviluppata utilizzando il framework React Native e consente la visualizzazione e l'aggiunta di contenuti testuali o multimediali e l'aggiunta di punti di interesse sulla mappa
Il progetto riprende da questa traccia:

Il progetto prevede lo sviluppo di una piattaforma di valorizzazione e digitalizzazione di un territorio
 comunale attraverso il caricamento di informazioni culturali, turistiche, sportive e di qualsiasi altra
 natura che possano essere di interesse per chi vive e frequenta un territorio. Il caricamento sulla
 piattaforma di qualsiasi contenuto è da riferirsi a un punto geolocalizzato presente sul comune e i
 contenuti si riferiranno dunque all’emergenza presente in quel dato punto.
 Allo stesso tempo si potrebbero aggiungere contenuti di natura più generale che si riferiscano ad
 esempio all’intero comune. In tal caso tali contenuti saranno associati al punto che identifica il
 comune stesso. Si possono dunque immaginare almeno due tipologie di punti: il primo di natura
 fisica che corrisponde ad un concetto fisico spaziale, e dunque alle emergenze che fisicamente si
 trovano su quel punto. Il secondo si riferisce ad un concetto di natura più logica (concetto
 politico/geografico/amministrativo).
 Ogni singolo comune potrà gestire i punti che ricadono sotto il proprio territorio e non sarà
 possibile aggiungere informazioni su altri comuni.
 L’obiettivo del progetto è dunque quello di creare una piattaforma che permetta di gestire contenuti
 di qualsiasi natura in relazione ad un dato territorio.
 Si immagina una piattaforma collaborativa in cui la cittadinanza stessa possa contribuire ad
 arricchire la piattaforma con contenuti testuali e/o multimediali. In tal caso chiaramente i contenuti
 saranno pubblicati sulla piattaforma soltanto dopo la verifica di conformità del contenuto in
 relazione ai fini del progetto.
 E’ possibile creare itinerari o esperienze che rappresentano insiemi ordinati, o non, di punti di
 interesse. Tali itinerari saranno definiti secondo le stesse strategie dei punti di interesse, ovvero
 caricati da responsabili o in maniera collaborativa e successivamente confermati.
 Si immaginano almeno i seguenti attori:
Contributors: hanno la possibilità di definire punti di rilievo, ed itinerari, e di associare a tali
 punti contenuti descrittivi o multimediali. I contenuti caricati sono posti in stato “pending”
 finché il curatore della piattaforma non li accetti.--------
Contributors autorizzati: sono speciali contributori la cui affidabilità è stata verificata e per
 cui i contenuti caricati non sono sottoposti a validazione da parte del curatore.
 Animatore: può proporre tematiche per possibili “contest di contribuzione” di contenuti. Si
 occuperà di definire obiettivo e poi di validare i contenuti proposti. Il contest potrebbe anche
 essere su invito e non aperto a tutti
 Curatore: può sia contribuire caricando contenuti, ma allo stesso tempo è colui il quale
 verifica la conformità dei contenuti caricati dai contributori
 Sistemi Social destinatari di contenuti: il curatore può a sua discrezione decidere di postare
 sui canali social del territorio riferimenti ai contenuti presenti sulla piattaforma.
 Gestore della piattaforma: gestisce tutti gli aspetti della piattaforma non ultima
 l’accettazione delle autorizzazioni e gli accreditamenti sulla piattaforma stessa
 Turista: può interrogare la base di conoscenza al fine di recuperare informazioni sul
 territorio. Qualora ritenga che un contenuto non sia consono può anche segnalare il
 contenuto al curatore
 Sistema OSM che fornisce informazioni sulle mappe del territorio
 Turista autenticato: ha la possibilità di salvare informazioni per future visite, caricare foto sui
 percorsi (da porre per approvazione)
