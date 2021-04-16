package goosegame;

import org.junit.*;
import static org.junit.Assert.*;

public class StartCellTest {

	@Test
	public void testStartCellCreation() {
		StartCell c=new StartCell(2);
		assertNotNull(c);
	}

	@Test
	public void testsetplayer(){
		StartCell c=new StartCell(2);
		Player p=new Player("jean",c);
		c.setplayer(p);
		assertEquals(p,c.getPlayer());
	}
 
	@Test
	public void testgetplayer(){
		StartCell c=new StartCell(2);
		Player p=new Player("jean",c);
		c.setplayer(p);
		assertEquals(p,c.getPlayer());
	}

	@Test
	public void testisBusy(){
		StartCell c=new StartCell(2);
		assertFalse(c.isBusy());
		Player p=new Player("jean",c);
		c.setplayer(p);
		assertTrue(c.isBusy());
	}

	@Test
	public void testgetIndex(){
		StartCell c=new StartCell(2);
		assertEquals(2,c.getIndex());
	}

	@Test
	public void testeffect(){
		StartCell c=new StartCell(2);
		assertEquals(2,c.Effect(3));
	}

	@Test
	public void testremove(){
		StartCell c=new StartCell(2);
		Player p=new Player("jean",c);
		c.setplayer(p);
		assertTrue(c.isBusy());
		c.remove(p);
		assertFalse(c.isBusy());
	}

	@Test
	public void testcanPlay(){
		StartCell c=new StartCell(2);
		assertTrue(c.canPlay());
	}

	public static junit.framework.Test suite() {
		return new junit.framework.JUnit4TestAdapter(StartCellTest.class);
    }
}
