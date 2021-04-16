import static org.junit.Assert.* ;

import org.junit.Test;

import battleship.util.*;

public class ShipTest{

  @Test
  public void testLifePointsDecreaseWhenhitted(){
    Ship s = new Ship(3);
    assertEquals(3, s.getLifePoints());
    s.hit();
    assertEquals(2, s.getLifePoints());
    s.hit();
    assertEquals(1, s.getLifePoints());
  }

  @Test
  public void testHasBeenSunk(){
     Ship s = new Ship(3);
     s.hit();
     assertFalse(s.hasBeenSunk());
     s.hit();
     assertFalse(s.hasBeenSunk());
     s.hit();
     assertTrue(s.hasBeenSunk());

  }
   public static junit.framework.Test suite(){
    return new junit.framework.JUnit4TestAdapter(ShipTest.class);
  }
}
