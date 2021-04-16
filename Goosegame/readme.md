------------------------------------------------------------------------
                                TP8
------------------------------------------------------------------------
## TITRE DU PROJET:
  Jeu de l'oie

## OJECTIFS DU PROJET
  Le TP a pour objectifs de crée le jeu du pierre feuille ciseaux

## VERSION ou DATE:
  06/05/2019

## COMMENT DEBUTER LE PROJET:
  Compiler les sources et executer la classe main ou executer directement l'archive.

## AUTEURS:
  MEDJAHED Fouad , AINOUCH Tarik

## INSTRUCTIONS:
  Executez la commande git pull afin de récuperer toutes les sources.

## JEU DE L'OIE

## CREER LA DOCUMENTATION
dossier src

* `>>>javadoc -d ../docs -subpackages goosegame`

## COMPILER LES sources
(dossier src)

* `>>>javac goosegame/Main.java -d ../classes`

## COMPILER ET EXECUTER LES TESTS :
(dossier tp8)

* `>>>javac -classpath test-1.7.jar test/goosegame/BasicCellTest.java -d classes`
* `>>>javac -classpath test-1.7.jar test/goosegame/ClassicBoardTest.java -d classes`
* `>>>javac -classpath test-1.7.jar test/goosegame/GameTest.java -d classes`
* `>>>javac -classpath test-1.7.jar test/goosegame/GooseCellTest.java -d classes`
* `>>>javac -classpath test-1.7.jar test/goosegame/JumpCellTest.java -d classes`
* `>>>javac -classpath test-1.7.jar test/goosegame/PlayerTest.java -d classes`
* `>>>javac -classpath test-1.7.jar test/goosegame/StartCellTest.java -d classes`
* `>>>javac -classpath test-1.7.jar test/goosegame/TrapCellTest.java -d classes`
* `>>>javac -classpath test-1.7.jar test/goosegame/WaitCellTest.java -d classes`


* `>>>java -jar test-1.7.jar goosegame.BasicCellTest`
* `>>>java -jar test-1.7.jar goosegame.ClassicBoardTest`
* `>>>java -jar test-1.7.jar goosegame.GameTest`
* `>>>java -jar test-1.7.jar goosegame.GooseCellTest`
* `>>>java -jar test-1.7.jar goosegame.JumpCellTest`
* `>>>java -jar test-1.7.jar goosegame.PlayerTest`
* `>>>java -jar test-1.7.jar goosegame.StartCellTest`
* `>>>java -jar test-1.7.jar goosegame.TrapCellTest`
* `>>>java -jar test-1.7.jar goosegame.WaitCellTest`

## EXECUTER LE FICHIER MAIN

* `>>>java goosegame/Main name1 name2`

name est le nom d'un joueur il est possible d'en mettre une infinité

## CREER ET EXECUTER UNE ARCHIVE :

(dossier classes)
* `>>>jar cvfm ../Goosegame.jar ../lib/manifest ../docs ../test goosegame`

(dossier tp8)
* `>>>java -jar Goosegame.jar name1 name2...`
