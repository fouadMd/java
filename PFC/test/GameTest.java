import org.junit.*;
import static org.junit.Assert.*;
import PFC.*;
import PFC.strat.*;

public class GameTest { 

	@Test
	public void GameCreation() {
		Strategy0 strat1=new Strategy0();
		Player p1= new Player("p1",strat1);
		Strategy0 strat2=new Strategy0();
		Player p2= new Player("p2",strat2);
		Game game=new Game(4,p1,p2);
		assertNotNull(game);
	}

	@Test
	public void playTest() {
		Strategy1 strat1=new Strategy1();
		Player p1= new Player("p1",strat1);
		Strategy2 strat2=new Strategy2();
		Player p2= new Player("p2",strat2);
		Game game=new Game(4,p1,p2);
		game.play();
		assertEquals(4,p1.getScore());
	}


	public static junit.framework.Test suite() {
        return new junit.framework.JUnit4TestAdapter(GameTest.class);
    }
}
