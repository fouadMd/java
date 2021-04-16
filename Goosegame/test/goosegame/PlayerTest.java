package goosegame;

import org.junit.*;
import static org.junit.Assert.*;

public class PlayerTest {

	@Test
	public void testPlayerCreation() {
		GooseCell c=new GooseCell(2);
		Player p=new Player("jean",c);
		assertNotNull(p);
	}

	@Test 
	public void testPlayerCreation2() {
		Player p=new Player("jean");
		assertNotNull(p);
	}

	@Test
	public void testgetCell(){
		Player p=new Player("jean");
		GooseCell c=new GooseCell(2);
		p.setCell(c);
		assertEquals(c,p.getCell());
	}

	@Test
	public void testsetCell(){
		Player p=new Player("jean");
		GooseCell c=new GooseCell(2);
		p.setCell(c);
		assertEquals(c,p.getCell());
	}

	@Test
	public void testtwoDiceThrow() {
		Player p=new Player("jean");
		int n=p.twoDiceThrow();
		assertTrue(2<=n && n<=12);
	}

	public static junit.framework.Test suite() {
		return new junit.framework.JUnit4TestAdapter(PlayerTest.class);
    }
}
