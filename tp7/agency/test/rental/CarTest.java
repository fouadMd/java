package rental;
import org.junit.*;
import static org.junit.Assert.*;

public class CarTest{
 
  private Car car1;
  private Car car2;

  @Before
  public void before(){
    this.car1 = new Car("Brand 1", "Model 1", 2010, 150, 4);
    this.car2 = new Car("Brand 2", "Model 2", 2012, 200, 5);
  }

  @Test
  public void testGetPassengers(){
    assertEquals(4,this.car1.getPassengers());
    assertEquals(5,this.car2.getPassengers());
  }

  @Test
  public void testToString(){
    assertEquals("2010 Brand 1 150.0 4",this.car1.toString());
    assertEquals("2012 Brand 2 200.0 5",this.car2.toString());
  }

  public static junit.framework.Test suite() {
    return new junit.framework.JUnit4TestAdapter(rental.CarTest.class);
  }
}
