import static org.junit.Assert.* ;

import org.junit.Test;

import battleship.util.*;

public class CellTest{

  @Test
  public void testSetShip(){
    Ship s = new Ship(3);
    Cell c = new Cell();
    assertFalse(c.isOccuped());
    c.setShip(s);
    c.shoot();
    assertTrue(c.hasBeenShot());
    assertEquals(s,c.getShip());
  }

  @Test
  public void testGetCharacter(){
    Ship s = new Ship(3);
    Cell c = new Cell();
    assertEquals(c.getcharacter(true),"~");
    assertEquals(c.getcharacter(false),".");
    c.setShip(s);
    assertEquals(c.getcharacter(true),"B");
    assertEquals(c.getcharacter(false),".");
    c.shoot();
    assertEquals(c.getcharacter(true),"*");
    assertEquals(c.getcharacter(false),"*");
    Cell l = new Cell();
    l.shoot();
    assertEquals(l.getcharacter(true),"~");

  }




  public static junit.framework.Test suite(){
    return new junit.framework.JUnit4TestAdapter(CellTest.class);
  }
}
