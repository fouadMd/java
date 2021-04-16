package goosegame;

import org.junit.*;
import static org.junit.Assert.*;

public class GooseCellTest {

	@Test
	public void testGooseCellCreation() {
		GooseCell c=new GooseCell(2);
		assertNotNull(c);
	}

	@Test
	public void testsetplayer(){
		GooseCell c=new GooseCell(2);
		Player p=new Player("jean",c);
		c.setplayer(p);
		assertEquals(p,c.getPlayer());
	}  

	@Test
	public void testgetplayer(){
		GooseCell c=new GooseCell(2);
		Player p=new Player("jean",c);
		c.setplayer(p);
		assertEquals(p,c.getPlayer());
	}

	@Test
	public void testisBusy(){
		GooseCell c=new GooseCell(2);
		assertFalse(c.isBusy());
		Player p=new Player("jean",c);
		c.setplayer(p);
		assertTrue(c.isBusy());
	}

	@Test
	public void testgetIndex(){
		GooseCell c=new GooseCell(2);
		assertEquals(2,c.getIndex());
	}

	@Test
	public void testeffect(){
		GooseCell c=new GooseCell(2);
		assertEquals(5,c.Effect(3));
	}

	@Test
	public void testremove(){
		GooseCell c=new GooseCell(2);
		Player p=new Player("jean",c);
		c.setplayer(p);
		assertTrue(c.isBusy());
		c.remove(p);
		assertFalse(c.isBusy());
	}

	@Test
	public void testcanPlay(){
		BasicCell c=new BasicCell(2);
		assertTrue(c.canPlay());
	}

	public static junit.framework.Test suite() {
		return new junit.framework.JUnit4TestAdapter(GooseCellTest.class);
    }
}
