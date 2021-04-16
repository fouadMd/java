package goosegame;

import org.junit.*;
import static org.junit.Assert.*;

public class JumpCellTest {

	@Test
	public void testJumpCellCreation() {
		JumpCell c=new JumpCell(2,7);
		assertNotNull(c);
	}
 
	@Test
	public void testsetplayer(){
		JumpCell c=new JumpCell(2,7);
		Player p=new Player("jean",c);
		c.setplayer(p);
		assertEquals(p,c.getPlayer());
	}

	@Test
	public void testgetplayer(){
		JumpCell c=new JumpCell(2,7);
		Player p=new Player("jean",c);
		c.setplayer(p);
		assertEquals(p,c.getPlayer());
	}

	@Test
	public void testisBusy(){
		JumpCell c=new JumpCell(2,7);
		assertFalse(c.isBusy());
		Player p=new Player("jean",c);
		c.setplayer(p);
		assertTrue(c.isBusy());
	}

	@Test
	public void testgetIndex(){
		JumpCell c=new JumpCell(2,7);
		assertEquals(2,c.getIndex());
	}

	@Test
	public void testeffect(){
		JumpCell c=new JumpCell(2,7);
		assertEquals(7,c.Effect(3));
	}

	@Test
	public void testremove(){
		JumpCell c=new JumpCell(2,7);
		Player p=new Player("jean",c);
		c.setplayer(p);
		assertTrue(c.isBusy());
		c.remove(p);
		assertFalse(c.isBusy());
	}

	@Test
	public void testcanPlay(){
		JumpCell c=new JumpCell(2,7);
		assertTrue(c.canPlay());
	}

	public static junit.framework.Test suite() {
		return new junit.framework.JUnit4TestAdapter(JumpCellTest.class);
    }
}
