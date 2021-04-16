import battleship.util.*;
import battleship.io.*;
import java.io.IOException;


public class GameMain{

  public static void main(String[] args){
    Sea s1 = new Sea(10,10);
    Ship sh = new Ship(3);
    Ship shi = new Ship(4);
    Ship ship = new Ship(2);
    s1.addShipVerticaly(ship,new Position(3,0));
    s1.addShipHorizontaly(shi,new Position(0,1));
    s1.addShipVerticaly(sh,new Position(3,5));
    Game g=new Game(s1);
    g.playGame();
    }
  }
