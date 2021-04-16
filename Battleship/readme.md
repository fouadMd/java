------------------------------------------------------------------------
                                TP5
------------------------------------------------------------------------
## PROJECT TITLE:
  BATTLESHIP
## PURPOSE OF PROJECT:
  Create a Battleship board and Make an attacker attack a Sea as long as he didn't make all the ships sunk
## VERSION or DATE:
  11/03/2019
## HOW TO START THIS PROJECT:
  compile the .java files and execute the mains class to test the utilities
## AUTHORS:
  MEDJAHED Fouad , AINOUCH Tarik
## USER INSTRUCTIONS:

type git pull to take the project TP5 and in the principal folder TP5 execute this commands.

## BATTLESHIP:

## Generate documentation :
(src folder)
* `>>>javadoc -d ../docs -subpackages  battleship`

## Consult documentation :

Open index.html and choose a package and the class you want to see

## Compile the object Class :
(src folder)
* `>>>javac battleship/util/Cell.java -d ../classes`
* `>>>javac battleship/util/Ship.java -d ../classes`
* `>>>javac battleship/util/Position.java -d ../classes`
* `>>>javac battleship/util/Answer.java -d ../classes`
* `>>>javac battleship/util/Sea.java -d ../classes`
* `>>>javac battleship/util/Game.java -d ../classes`
* `>>>javac battleship/io/Input.java -d ../classes`


## Compile and Execute the Test :
(tp5 folder)
* `>>>javac -classpath .:test-1.7.jar test/ShipTest.java`

* `>>>java -jar test-1.7.jar ShipTest`

* `>>>javac -classpath .:test-1.7.jar test/CellTest.java`

* `>>>java -jar test-1.7.jar CellTest`

* `>>>javac -classpath .:test-1.7.jar test/SeaTest.java`

* `>>>java -jar test-1.7.jar SeaTest`

## Compile and Execute the Main Class :
(to test the display of the board compile and execute SeaDisplayMain)
(src folder)
* `>>>javac battleship/SeaDisplayMain.java -d ../classes`

(src folder)
* `>>>javac battleship/GameMain.java -d ../classes`

(classes folder)
* `>>>java GameMain`

* `>>>java SeaDisplayMain`

## Create an archive :

Nous avons eu un problème avec l'archive, notre appli.jar ne retrouve pas de methode main meme lorsque nous la definissons dans le manifest-ex. Les methodes Main fonctionnent lorsque l'on execute directement les fichiers Main.class et tous les tests fonctionnent.
