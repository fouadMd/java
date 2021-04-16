package goosegame;

import org.junit.*;
import static org.junit.Assert.*;

public class ClassicBoardTest {

	@Test
	public void testBoardCreation() {
		ClassicBoard b=new ClassicBoard();
		assertNotNull(b);
	}

	@Test
	public void testnbOfCells(){
		ClassicBoard b=new ClassicBoard();
		assertEquals(64,b.nbOfCells());
	}

	public static junit.framework.Test suite() {
		return new junit.framework.JUnit4TestAdapter(ClassicBoardTest.class);
    }
}
 
