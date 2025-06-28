# Book Explorer Project

Matricola Epicode: S00003324
Anno accademico: 2024/2025

# Descrizione

Book Explorer è un'applicazione Java SE progettata per gestire una libreria di libri suddivisi per categorie e garantire una struttura sicura, manutenibile e modulare.

# Architettura e Pattern Utilizzati

L'applicazione adotta una struttura a componenti secondo i seguenti pattern:

Factory			Crea oggetti Book in modo centralizzato (BookFactory)
Composite		Consente di trattare singolarmente o in gruppo BookLeaf e Category
Iterator		Permette di scorrere le categorie e i libri
Strategy		Per cambiare dinamicamente il metodo di stampa dei libri
Observer		Notifica gli osservatori su eventi del sistema (NotificationCenter)
Exception Shielding	Gestione sicura degli errori, evitando crash e stack trace per l'utente

# Struttura del Progetto:

EXAM/
├── src/
│   ├── Book.java
│   ├── BookLeaf.java
│   ├── Category.java
│   ├── CategoryComponent.java
│   ├── BookFactory.java
│   ├── FileManager.java
│   ├── LoggerSingleton.java
│   ├── PrintStrategy.java
│   ├── NotificationCenter.java
│   ├── Observer.java
│   ├── Subject.java
│   ├── TestFileManager.java
│   └── books.dat (runtime-generated)

# Esecuzione del Progetto

- Posizionarsi nella cartella src sul proprio percorso: cd C:/Users/.../Desktop/JAVA/EXAM/src

- Compilare tutti i file: javac *.java

- Eseguire il test: java TestFileManager

# Tecnologie Utilizzate

- Java 17
- Java Collections & Generics
- Serializzazione tramite ObjectOutputStream
- Logging (Logger)
- Pattern OOP: Factory, Composite, Observer, Strategy
- JUnit 5 (solo nei test, opzionale)

UML – Diagramma delle Classi
+---------------------+        +------------------------+
|    BookFactory      |        |    LoggerSingleton     |
+---------------------+        +------------------------+
| +createBook(...)    |        | +getLogger()           |
+---------------------+        +------------------------+
         |                              |
         | creates                      | provides logger to
         v                              v
+---------------------+        +------------------------+
|        Book          |        |      FileManager       |
+---------------------+        +------------------------+
| - title             |        | +saveBooks(List<>)     |
| - author            |        | +loadBooks(String)     |
| - publisher         |        +------------------------+
| - year              |
| - language          |
+---------------------+

        ^ (composition)
        |
+------------------------+     implements     +------------------------+
|       BookLeaf         | <----------------- |   CategoryComponent    |
+------------------------+                    +------------------------+
| - book : Book          |                    | +add(CategoryComponent)|
| +print()               |                    | +remove(...)           |
+------------------------+                    | +print()               |
                                              +------------------------+
                                                      ^
                                                      |
                                      implements Iterable<CategoryComponent>
                                                      |
                                                      v
                                            +------------------------+
                                            |      Category          |
                                            +------------------------+
                                            | - name : String        |
                                            | - components : List<>  |
                                            | +add(), remove(), ...  |
                                            +------------------------+

+--------------------------+     implements     +------------------------+
|        Subject           | <----------------- |  NotificationCenter    |
+--------------------------+                    +------------------------+
| +registerObserver(...)   |                    | - observers : List<>   |
| +removeObserver(...)     |                    | +notifyObservers()     |
+--------------------------+                    +------------------------+
                                                      ^
                                                      |
                                                notifies Observers
                                                      |
                                                      v
                                       +---------------------------+
                                       |         Observer          |
                                       +---------------------------+
                                       | +update(String msg)       |
                                       +---------------------------+
                                                      ^
                                                      |
                                       +---------------------------+
                                       | lambda: msg -> log.info() |
                                       +---------------------------+

+-----------------------------+
|      PrintStrategy          |
+-----------------------------+
| +print(CategoryComponent)   |
+-----------------------------+
         ^                 ^
         |                 |
+------------------+   +--------------------------+
| SimplePrint      |   | UpperCasePrint           |
+------------------+   +--------------------------+
| +print(...)      |   | +print(...)              |
+------------------+   +--------------------------+


# Limitazioni

- L'applicazione è basata su console, senza interfaccia grafica.
- I dati sono salvati in un file binario `.dat` e non in formato leggibile (es. JSON).
- I test unitari sono presenti ma non eseguiti senza configurazione JUnit.

# Possibili Miglioramenti Futuri

- Aggiunta di una GUI (Swing o JavaFX)
- Esportazione/importazione in JSON o CSV
- Test automatizzati completi con JUnit
- Separazione tra livello logico e presentazione
