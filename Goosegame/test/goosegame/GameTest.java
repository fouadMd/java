package goosegame;

import org.junit.*;
import static org.junit.Assert.*;

public class GameTest {

	@Test
	public void testGameCreation() {
		ClassicBoard b=new ClassicBoard();
		Game g=new Game(b);
		assertNotNull(g);
	}

	public static junit.framework.Test suite() {
		return new junit.framework.JUnit4TestAdapter(GameTest.class);
    }
}
 
