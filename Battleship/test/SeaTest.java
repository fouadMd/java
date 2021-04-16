import static org.junit.Assert.* ;

import org.junit.Test;

import battleship.util.*;

public class SeaTest{


  @Test
  public void AddShipTest(){
    Ship s = new Ship(3);
    Sea sea1 = new Sea(5,5);
    assertEquals(sea1.getSeaLifePoints(),0);
    sea1.addShipVerticaly(s,new Position(0,0));
    assertEquals(sea1.getSeaLifePoints(),3);
    assertTrue(sea1.getCell(new Position(0,0)).isOccuped());
    assertTrue(sea1.getCell(new Position(1,0)).isOccuped());
    assertTrue(sea1.getCell(new Position(2,0)).isOccuped());
    assertEquals(sea1.getSeaLifePoints(),3);
    sea1.addShipHorizontaly(s,new Position(4,0));
    assertTrue(sea1.getCell(new Position(4,0)).isOccuped());
    assertTrue(sea1.getCell(new Position(4,1)).isOccuped());
    assertTrue(sea1.getCell(new Position(4,2)).isOccuped());
    assertEquals(sea1.getSeaLifePoints(),6);


  }




  public static junit.framework.Test suite(){
    return new junit.framework.JUnit4TestAdapter(CellTest.class);
  }
}
