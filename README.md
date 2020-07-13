# Java 

In dieser Übung geht es darum, das Arbeiten mit [Streams](https://docs.oracle.com/javase/8/docs/api/java/util/stream/Stream.html) zu üben.
Mit Java Streams kann man Daten ganz ähnlich zu SQL verarbeiten - man kann einen Stream von Elementen filtern, Attribute durch mapping extrahieren und ganz einfach Maxima, Minima oder Durchschnitte berechnen. 

## Streams - Personalmanagement 

Gegeben sind eine Liste von Employees. Ein Employee hat einen Namen, ein Geschlecht, ein Gehalt und ist einem Department zugehörig. 
Löse folgende Aufgabenstellungen mit Hilfe von Streams: 

* Gib alle Daten zu unserem CEO `Max Mustermann` aus.
* Gib für jeden Angestellten seinen vollen Namen und das Brutto sowie netto gehalt aus: 
`Sarah Huber         €1250,00 (€1750,00)`
* Gib die selbe Liste sortiert nach absteigendem Bruttogehalt aus.
* Gib alle Departments ohne Duplikate aus
* Gibt es in unserer Firma einen Gender Pay Gap? Gib dazu das durchschnittliche Gehalt (netto und brutto) pro Geschlecht aus! 
* Wie ist die Geschlechter-Verteilung in unseren Departments? Gib für jedes Department aus wieviele Personen welchen Geschlechts in dem Department arbeiten. 
* In welchem Bereich bewegen sich die Gehälter unserer Angestellten und in welchem Bereich bewegen sich die Gehälter unserer Teamleads? Gib jeweils das Minimum und Maximum Gehalt über alle Angestellte und das Minimum und Maximum Gehalt über alle Teamleads aus.
