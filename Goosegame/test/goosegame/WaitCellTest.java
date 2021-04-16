package goosegame;

import org.junit.*;
import static org.junit.Assert.*;

public class WaitCellTest {

	@Test
	public void testWaitCellCreation() {
		WaitCell c=new WaitCell(2,1);
		assertNotNull(c);
	}

	@Test
	public void testsetplayer(){
		WaitCell c=new WaitCell(2,1);
		Player p=new Player("jean",c);
		c.setplayer(p);
		assertEquals(p,c.getPlayer());
	} 

	@Test
	public void testgetplayer(){
		WaitCell c=new WaitCell(2,1);
		Player p=new Player("jean",c);
		c.setplayer(p);
		assertEquals(p,c.getPlayer());
	}

	@Test
	public void testisBusy(){
		WaitCell c=new WaitCell(2,1);
		assertFalse(c.isBusy());
		Player p=new Player("jean",c);
		c.setplayer(p);
		assertTrue(c.isBusy());
	}

	@Test
	public void testgetIndex(){
		WaitCell c=new WaitCell(2,1);
		assertEquals(2,c.getIndex());
	}

	@Test
	public void testeffect(){
		WaitCell c=new WaitCell(2,1);
		assertEquals(2,c.Effect(3));
	}

	@Test
	public void testremove(){
		WaitCell c=new WaitCell(2,1);
		Player p=new Player("jean",c);
		c.setplayer(p);
		assertTrue(c.isBusy());
		c.remove(p);
		assertFalse(c.isBusy());
	}

	@Test
	public void testcanPlay(){
		WaitCell c=new WaitCell(2,1);
		assertFalse(c.canPlay());
		assertTrue(c.canPlay());
	}

	public static junit.framework.Test suite() {
		return new junit.framework.JUnit4TestAdapter(WaitCellTest.class);
    }
}
