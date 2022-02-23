Per calcolare l'indirizzo dell'host si utilizza la classe `InetAddress` con i seguenti metodi:

1. `InetAddress.getByName(hostName)`: da nome simbolico a indirizzo numerico

2. `InetAddress.getAllByName(hostName)`: tutti gli indirizzi associati a quel nome simbolico

3. `InetAddress.getLocalHost()`: recupera indirizzo locale

Per gestire la struttura:

1. `byte[] InetAddress.getAddress`estrae indirizzo IP dalla struttura (devo convertire)

2. `String InetAddress.getHostAddress`: estrae Indirizzo IP decimale puntato

3. `String InetAddress.getHostName`: estrae nome simbolico host

Struttura a partire da indirizzo numerico:

1. `InetAddress InetAddress.getByAddress(addr)`

### Socket

È necessario creare una socket (il serve deve includere la porta well known mentre in client include la porta scelta). Per il client si utilizza la classe `Socket` mentre per il server si utilizza la classe `ServerSocket`. **Le fasi per una connessione sono**:

1. creazione socket

2. binding (cioè gestione indirizzi host + #porta (client + server))

3. connessione client-server

4. scambio dati

5. chiusura connessione

![](C:\Users\Marco\AppData\Roaming\marktext\images\2022-02-21-14-32-52-image.png)

class InetSocketAddress con costruttori: 

- `InetSocketAddress(InetAddress addr, int port) `

- `InetSocketAddress(String hostname, int port) `

- `InetSocketAddress(int port)`

Metodi utili:

- `InetAddress InetSocketAddress.getAddress()`

- `String InetSocketAddress.getHostName()`

- `int InetSocketAddress.getPort()`

**Creazione socket lato server:**

- `ServerSocket(int port)`, #port può essere 0

- `ServerSocket()` crea socket non connessa, serve quindi una bind successiva

**Connessione**:

- `Socket ServerSocket.accept()`

### Metodi utili per la conversione dei dati

- `String.trim()`: toglie spazi iniziali e finali in una stringa

- `String.split(String regex, int limit)`: Splitta la stringa a secondo della regex

- `StringTokenizer.nextToken()`Permette di ottenere la successiva sottostringa delimitata dal separatore indicato
