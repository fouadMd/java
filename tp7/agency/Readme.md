TP7 de POO - Réalisé par Medjahed Fouad et Ainouch Tarik
=======================================================
 
Présentation du TP et de ses objectifs.
----------------------------------------
Ce TP portait sur l'implémentation des agences de location, vues en TD. Une agence peut contenir plusieurs véhicules que des clients peuvent louer, chaque client ne peut louer qu'un véhicule à la fois, et un véhicule ne peut être loué que par une seule personne.

Le TP était dans un premier temps l'occasion d'utiliser l'annotation @Before dans les classes de tests, permettant de ne pas avoir à copier/coller l'initialisation de véhicules, d'une nouvelle agence... à chaque test.
Dans un deuxième temps ce TP nous permettait de commencer à utiliser l'héritage, notamment en nous faisant créer une classe Car et Motorbike, héritant de Vehicle, et de nous faire expérimenter dessus.

Ce qui a été fait.
-------------------

Ce qui a été demandé à été fait, ce dossier agency contient :

* `Un dossier src` qui contient dans un paquetage rental les sources fournies (la classe Vehicle, VehicleFilter, MaxPriceFilter, BrandFilter...), les classes qu'on a complétées et créées (RentalAgency, AndFilter, Car, MotorBike, SuspiciousRentalAgency, UnknownVehicleException) et deux classes RentalAgencyMain et HeritageAgencyMain, qui définissent les deux main du TP (plus de détails ci-dessous).
* `Un dossier test` qui contient évidemment toutes les classes de test (également dans un paquetage rental).
* `Le fichier test-1.7.jar` nécessaire pour la compilation et execution des tests.
* `Le Makefile`
* `Le fichier Readme.md`
* `Les fichiers manifest-agency et manifest-heritage` pour permettre la création des deux fichiers jar correspondant aux deux main. Le fichier manifest-agency définit la classe RentalAgencyMain comme principale alors que manifest-heritage definit HeritageAgencyMain comme principale.

**La différence entre les deux main ?** La classe RentalAgencyMain définit le main défini à la question 2 du TP. Ce main crée une agence de location y place 6 véhicules et fait beaucoup de manipulations à partir de ça. 3 filtres sont testés, trois clients louent et rendent des véhicules alors que la classe HeritageAgencyMain définit le main demandé aux question 6 et 8 du TP.     
On place alors dans l'agence des objets Motorbike et Car en plus des Vehicle et on crée plus loin un objet SuspiciousRentalAgency. Il n'y a ici qu'un filtre testé sur chaque échange et deux clients (un ayant moins de 25 ans et l'autre non).      
Ces deux main remplissent deux fonctions différentes, le premier sert plus à montrer les fonctions de RentalAgency en action alors que le deuxième sert plus à utiliser l'héritage, c'est pourquoi nous avons préféré les séparer plutôt que d'avoir un main dans lequel l'ensemble aurait été plus "fouilli". Pour l'éxecution de ces main avec make, on utilisera les target "jar1" et "jar2" (ou "run1" et "run2", voir le paragraphe **Usage du Makefile**).

Dans le paragraphe **Réponses aux questions** se trouvent les réponses aux questions 3 et 7 du TP.

Le paragraphe **Usage du Makefile** présent ci-dessous explique comment faire fonctionner le Makefile et le paragraphe **"A la main"** explique quelles commandes rentrer pour compiler,executer ou encore générer la doc "à la main" (autrement dit, refaire le travail du Makefile commande par commande)

Réponses aux questions
------------------------

#### Question 3
On pourrait s'attendre à ce que le code passe le test en trouvant client2 dans la table de hachage qui gère les véhicules loués, puisqu'il est créé de la même façon que client1. **Ce n'est pas le cas !**

En effet, même si ces deux objets ont été créés de la même façon, ils n'ont pas nécessairement le même hashCode. Pour pallier à ce problème, il faut créer une méthode hashCode() dans la classe Client, puisqu'il est précisé dans l'énoncé qu'il n'y a pas d'homonyme dans les noms des clients, cette méthode renvoie juste le hashCode du nom du client.

Ce n'est pas fini ! Même si il y a collision, il faut que les deux objets soient égaux pour qu'ils soient considérés comme deux clés identiques, il faut donc aussi définir une méthode equals() dans Client.

Avec l'implémentation de ces deux méthodes, le code passe le test puisque client1 et client2 ont le même hashCode et sont égaux.

#### Question 7

Ce surcout ne demande pas la modification de beaucoup de méthodes, à vrai dire ce surcout s'applique uniquement lorsqu'un client de moins de 25 ans loue un véhicule, donc il ne faudrait changer que la méthode rentVehicle. Il faut donc que la classe SuspiciousRentalAgency hérite de RentalAgency. Cette classe surchargera la méthode rentVehicle() en vérifiant l'âge du client, puis en utilisant super pour executer la méthode normalement, en multipliant juste le résultat obtenu si besoin est.


Usage du Makefile
------------------

Le Makefile se trouvant dans le répertoire agency, il faut y accéder par la commande **cd agency** après avoir récupéré le depot distant grâce à **git pull**, toutes les commandes du Makefile se font dans ce répertoire

### Compilation des sources du projet

Pour compiler les sources du projet, il suffit de rentrer :
```
.../agency$ make
```
Un dossier classes est alors créé dans le répertoire agency, contenant toutes les classes de notre projet, bien évidemment dans leurs paquetages respectifs.

### Génération de la doc

Pour générer la javaodc, il faut rentrer:
```
.../agency$ make doc
```
Un dossier docs est alors créé dans agency, dans ce fichier se trouvent plusieurs fichiers en .html, ouvrir le fichier index.html vous permet de consulter la doc de toutes les classes.

### Compilation et execution des tests

La commande suivante permet de compiler et d'executer les tests du projet:
```
.../agency$ make test
```
Une fenêtre s'ouvre alors avec les résultats des tests de rental.SuspiciousRentalAgencyTest, pour les résultats des tests des autres classes, il faut ouvrir le menu déroulant "Test class name", choisir la classe voulue et appuyer sur le bouton Run à côté, ou écrire le nom de la classe de test dans le champ de texte "Test class name:" puis appuyer sur Run.
**Attention !** La compilation des tests exige normalement que les fichiers sources soient d'abord compilés, cependant le Makefile a été conçu pour faire cette compilation si elle n'a pas été faite, autrement dit, il est tout à fait possible de faire **make test** sans avoir **make** avant.

### Execution des programmes avec les .jar executables
La commande suivante permet de créer le fichier appli.jar executable et de l'executer (le fichier est créé dans le répertoire agency), pour executer RentalAgencyMain, il faut rentrer:
```
.../agency$ make jar1
```
Alors que pour exécuter HeritageAgencyMain, il faut rentrer :
```
.../agency$ make jar2
```

**Attention !** Comme précedemment la création du fichier en .jar demande à ce que les fichiers sources soient compilés, comme pour les tests, le Makefile s'en occupe si ce n'est pas fait, il est donc aussi tout à fait possible de faire **make jar1** avant **make**.

### Execution du programme sans le .jar executable
La commande suit la même structure que juste au-dessus, ici la target du Makefile n'est pas jar mais run, pour la classe RentalAgencyMain :
```
.../agency$ make run1
```
Et pour HeritageAgencyMain :
```
.../agency$ make run2
```
Ici aussi, le Makefile compile les fichiers sources si cela n'a pas été fait.

### Nettoyage de agency
La commande suivante supprime le dossier classes, le dossier docs, le fichier .jar et les fichiers .class, ces fichiers pouvant tous être recréés avec les commandes ci-dessus :
```
.../agency$ make clean
```
A la main
---------------
Ce paragraphe montre les commandes à utiliser si l'utilisateur désire faire le travail du Makefile par lui-même (ce paragraphe a peu d'interet, nous avons tout de même jugé qu'il était préférable d'en faire trop que pas assez, c'est pourquoi nous l'avons laissé, mais il n'est pas du tout nécessaire au bon fonctionnement du TP, le paragraphe d'avant étant bien plus pratique).

Il est supposé ici que l'on est dans le répertoire agency (**cd agency**) après avoir importé le dépot distant (**git pull**)

### Compilation des sources du projet (**à faire en premier**)
```
.../agency$ mkdir classes
.../agency$ cd src
.../agency/src$ javac rental/*.java -d ../classes

```

### Génération de la doc
```
.../agency$ cd src
.../agency/src$ javadoc -d ../docs -subpackages rental
```
### Compilation et execution des tests (de RentalAgencyTest par exemple)
```
.../agency$ javac -classpath test-1.7.jar test/rental/RentalAgencyTest.java
.../agency$ java -jar test-1.7.jar rental.RentalAgencyTest
```
### Execution du programme avec le .jar executable
Pour RentalAgencyMain :
```
.../agency$ cd classes
.../agency/classes$ jar cvfm ../appli.jar ../manifest-agency rental
.../agency/classes$ cd ..
.../agency$ java -jar appli.jar
```
Pour HeritageAgencyMain :
```
.../agency$ cd classes
.../agency/classes$ jar cvfm ../appli.jar ../manifest-heritage rental
.../agency/classes$ cd ..
.../agency$ java -jar appli.jar
```
### Execution du programme sans le .jar executable
Pour RentalAgencyMain :
```
.../agency$ java -classpath classes rental.RentalAgencyMain
```
Pour HeritageAgencyMain :
```
.../agency$ java -classpath classes rental.HeritageAgencyMain
```
### Nettoyage de agency
```
.../agency$ rm -f test/*.class appli.jar -r classes docs
```
