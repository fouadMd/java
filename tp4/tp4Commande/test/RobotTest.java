import org.junit.*;
import static org.junit.Assert.*;
import example.util.*;
import example.Robot;



public class RobotTest {
   @Test
   public void testTake() {
     Box box=new Box(10);
     Box box2=new Box(10);
     Robot r=new Robot();
     r.take(box);
     Robot t=new Robot();
     assertEquals(r.getCarriedBox(),box);
     assertEquals(t.getCarriedBox(),null);
     t.take(box);
     t.take(box2);
     assertEquals(t.getCarriedBox(),box);
   }

   @Test
   public void testCarryBox(){
      Robot r = new Robot();
      Robot t = new Robot();
      Box box = new Box(20);
      r.take(box);
      assertTrue(r.carryBox());
      assertFalse(t.carryBox());
    }

    @Test
    public void testPutOn(){
    Box b = new Box(12);
    ConveyerBelt c = new ConveyerBelt(24);
    Robot r = new Robot();
    r.take(b);
    assertFalse(c.isFull());
    r.putOn(c);
    assertFalse(r.carryBox());
    ConveyerBelt c2 = new ConveyerBelt(9);
    Box b2 = new Box(1);
    r.take(b2);
    r.putOn(c);
    Box b3 = new Box(150);
    r.take(b3);
    assertFalse(c2.accept(b3));
    assertTrue(r.carryBox());
    }

    public static junit.framework.Test suite() {
        return new junit.framework.JUnit4TestAdapter(RobotTest.class);
    }

}

