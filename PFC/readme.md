------------------------------------------------------------------------
                                TP6
------------------------------------------------------------------------
## PROJECT TITLE:
  PFC
## PURPOSE OF PROJECT:
  Le TP a pour objectifs de crée le jeu du pierre feuille ciseaux
## VERSION or DATE:
  11/03/2019
## HOW TO START THIS PROJECT:
  Compiler les sources et executer la classe main ou executer directement l'archive.
## AUTHORS:
  MEDJAHED Fouad , AINOUCH Tarik
## USER INSTRUCTIONS:

Executez la commande git pull afin de récuperer toutes les sources.

## PFC:

## Generate documentation :
(dossier src)
* `>>>javadoc -d ../docs -subpackages  PFC`
* `>>>javadoc -d ../docs -subpackages  util`

## Consult documentation :

Ouvrir le fichier index.html puis pacourir tous les fichiers.

## Compile the object Class :
(dossier src)
* `>>>javac PFC/Game.java -d ../classes`
* `>>>javac PFC/Move.java -d ../classes`
* `>>>javac PFC/Player.java -d ../classes`
* `>>>javac PFC/strat/Strategy.java -d ../classes`
* `>>>javac PFC/strat/Strategy0.java -d ../classes`
* `>>>javac PFC/strat/Strategy1.java -d ../classes`
* `>>>javac PFC/strat/Strategy2.java -d ../classes`
* `>>>javac PFC/strat/Strategy3.java -d ../classes`
* `>>>javac PFC/strat/StrategyUser.java -d ../classes`
* `>>>javac util/Input.java -d ../classes`
* `>>>javac util/InputMain.java -d ../classes`
* `>>>javac util/pfcInput.java -d ../classes`


## Compile and Execute the Test :
(dossier tp6)
* `>>>javac -classpath .:test-1.7.jar test/PlayerTest.java`

* `>>>java -jar test-1.7.jar PlayerTest`

* `>>>javac -classpath .:test-1.7.jar test/MoveTest.java`

* `>>>java -jar test-1.7.jar MoveTest`

* `>>>javac -classpath .:test-1.7.jar test/GameTest.java`

* `>>>java -jar test-1.7.jar GameTest`

## Compile and Execute the Main Class :

* `>>>javac PFC/Main.java -d ../classes`


(classes folder)
* `>>>java PFC/Main`

## Create an archive :

Pour créer le jar executable, mettez-vous dans le dossier classes utilisez la commande:

* `jar cvfm ../rps.jar ../lib/manifest ../docs ../test util PFC`

Pour executer l'executable qui vient d'etre créée allez dans le dossier tp6:

* `java -jar rps.jar n`

où n est un numéro de stratégie jouée par l'ordinateur.
Liste des stratégie disponibles et les numéro affectées:


0 la stratégie aléatoire

1 la stratégie "toujours papier"
2 la stratégie "toujours pierre"
3 la stratégie alterne pierre et ciseaux
Si n est inferieur à 0 ou supérieur a 3 le jeu se lance avec la stratégie aléatoire
