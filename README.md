# Dokumentation

Die nachfolgende Dokumentation umfasst die folgenden Punkte:

- Erläuterung der Wahl der Datenstruktur
- Erläuterung der Wahl des Algorithmus
- Analyse der Algorithmuskomplexität (Zeit- und Platzkomplexität)

# Datenstruktur

In der aktuellen Implementierung wird ausschließlich mit einem 2-dimensionalen Array `int[][]` sowie in der konkreten
Verarbeitung mit Integer-Arrays (`int[]`) gearbeitet.

Die Verwendung von Arrays ist hier generell sinnvoll, da wir mit primitiven Datentypen in den Arrays arbeiten. Die Werte
werden direkt im Arbeitsspeicher abgespeichert. Der Zugriff auf (im Falle des 2D-Arrays) bzw. das Einfügen von einzelnen
Werten (im Falle der 1D-Arrays) erfolgt dabei mit einer
Zeitkomplexität von `O(1)`. (Vgl. [Geeks for Geeks](https://www.geeksforgeeks.org/java/arrays-in-java/), abgerufen am
11.09.2026)

# Algorithmus Deep Dive

Nachfolgende Idee liegt dem hier verwendeten Algorithmus zu Grunde:

- Jedes "leere" (`0`) Feld wird mit allen möglichen Optionen (`1` - `9`) geprüft hinsichtlich:
    - Ist die aktuell gewählte Option (`1` - `9`) horizontal, vertikal sowie im aktuell vorhandenen Quadranten bereits
      vorhanden?
    - Jede mögliche Option wird in einem `int[]` gespeichert
- Es wird so lange über das aktuelle sowie jeden weiteren Sudoku-Board-Zustand iteriert, bis:
    - In der aktuellen Iteration ein leeres Feld (`0`) gefunden wurde, welches maximal eine mögliche Option in o.g.
      `int[]` hat. Dann wird diese Option eingetragen.
    - Sobald im `int[]` mehr als eine Option vorhanden ist, wird die aktuelle Iteration aus Performancegründen
      abgebrochen.
    - in der vergangenen Iteration sowie der aktuellen Iteration kein leeres Feld (`0`) gefüllt werden konnte. Hier wird
      mit dem Hinweis `No Solution is possible anymore...` abgebrochen.

Als Basis für die Entwicklung dieses Algorithmus diente eine Analyse:

- Wie würde ich als Mensch ein Sudoku lösen?
- Wie müssen hier End-Zustände aussehen, damit eine Zahl eingetragen werden kann?

Der aktuell implementierte Algorithmus hat dadurch nachfolgende Limitation:

- Sudokus mit mehreren möglichen Lösungswegen sind nicht lösbar

Idealerweise wäre ein Backtracking-Algorithmus verwendet worden - im Sinne der Übung war es mir jedoch wichtig, eine
eigenständige Lösung zu entwickeln, ohne bei dabei eine vorgefertigte Sudoku-spezifische Lösung zu übernehmen (über
welche man zwangsläufig stolpert, wenn man sich online über einen Backtracking-Algorithmus einlesen möchte).

# Analyse der Algorithmuskomplexität

## Zeitkomplexität

## Platzkomplexität