package goosegame;

import org.junit.*;
import static org.junit.Assert.*;

public class TrapCellTest {

	@Test
	public void testTrapCellCreation() {
		TrapCell c=new TrapCell(2);
		assertNotNull(c);
	}

	@Test
	public void testsetplayer(){
		TrapCell c=new TrapCell(2);
		Player p=new Player("jean",c);
		c.setplayer(p);
		assertEquals(p,c.getPlayer());
	}

	@Test 
	public void testgetplayer(){
		TrapCell c=new TrapCell(2);
		Player p=new Player("jean",c);
		c.setplayer(p);
		assertEquals(p,c.getPlayer());
	}

	@Test
	public void testisBusy(){
		TrapCell c=new TrapCell(2);
		assertFalse(c.isBusy());
		Player p=new Player("jean",c);
		c.setplayer(p);
		assertTrue(c.isBusy());
	}

	@Test
	public void testgetIndex(){
		TrapCell c=new TrapCell(2);
		assertEquals(2,c.getIndex());
	}

	@Test
	public void testeffect(){
		TrapCell c=new TrapCell(2);
		assertEquals(2,c.Effect(3));
	}

	@Test
	public void testremove(){
		TrapCell c=new TrapCell(2);
		Player p=new Player("jean",c);
		c.setplayer(p);
		assertTrue(c.isBusy());
		c.remove(p);
		assertFalse(c.isBusy());
	}

	@Test
	public void testcanPlay(){
		TrapCell c=new TrapCell(2);
		assertFalse(c.canPlay());
	}

	public static junit.framework.Test suite() {
		return new junit.framework.JUnit4TestAdapter(TrapCellTest.class);
    }
}
