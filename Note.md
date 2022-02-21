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

![](C:\Users\Marco\AppData\Roaming\marktext\images\2022-02-21-14-32-52-image.png)

class InetSocketAddress con costruttori: 

- `InetSocketAddress(InetAddress addr, int port) `

- `InetSocketAddress(String hostname, int port) `

- `InetSocketAddress(int port)`

Metodi utili:

- `InetAddress InetSocketAddress.getAddress()`

- `String InetSocketAddress.getHostName()`

- `int InetSocketAddress.getPort()`


