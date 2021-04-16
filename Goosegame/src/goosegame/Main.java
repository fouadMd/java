package goosegame;

import java.util.*;

public class Main {

    public static void main(String[] args) {
	ClassicBoard b=new ClassicBoard();
	Game g=new Game(b);
	for (String name : args){
		Player p=new Player(name);
		g.addPlayer(p);
	}
	g.play();
    }
}
 
