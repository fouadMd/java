import battleship.util.*;
import battleship.io.*;




public class SeaDisplayMain{

  public static void main(String[] args){
    Sea s1 = new Sea(10,10);
    Ship ship1 = new Ship(3);
    Ship ship2 = new Ship(4);
    Ship ship3 = new Ship(2);
    s1.addShipVerticaly(ship1,new Position(3,0));
    s1.addShipHorizontaly(ship2,new Position(0,1));
    s1.addShipVerticaly(ship3,new Position(3,5));
    System.out.println("board for a defender");
    s1.display(true);
    System.out.println("");
    System.out.println("board for an attacker");
    s1.display(false);
    System.out.println("");
    s1.shoot(new Position(4,0));
    s1.shoot(new Position(4,5));
    s1.shoot(new Position(8,8));
    System.out.println("board for a defender");
    s1.display(true);
    System.out.println("");
    System.out.println("board for an attacker");
    s1.display(false);
    }
  }
