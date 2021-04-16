package goosegame;

import org.junit.*;
import static org.junit.Assert.*;

public class BasicCellTest {

	@Test
	public void testBasicCellCreation() {
		BasicCell c=new BasicCell(2);
		assertNotNull(c);
	} 

	@Test
	public void testsetplayer(){
		BasicCell c=new BasicCell(2);
		Player p=new Player("jean",c);
		c.setplayer(p);
		assertEquals(p,c.getPlayer());
	}

	@Test
	public void testgetplayer(){
		BasicCell c=new BasicCell(2);
		Player p=new Player("jean",c);
		c.setplayer(p);
		assertEquals(p,c.getPlayer());
	}

	@Test
	public void testisBusy(){
		BasicCell c=new BasicCell(2);
		assertFalse(c.isBusy());
		Player p=new Player("jean",c);
		c.setplayer(p);
		assertTrue(c.isBusy());
	}

	@Test
	public void testgetIndex(){
		BasicCell c=new BasicCell(2);
		assertEquals(2,c.getIndex());
	}

	@Test
	public void testeffect(){
		BasicCell c=new BasicCell(2);
		assertEquals(2,c.Effect(3));
	}

	@Test
	public void testremove(){
		BasicCell c=new BasicCell(2);
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
		return new junit.framework.JUnit4TestAdapter(BasicCellTest.class);
    }
}
