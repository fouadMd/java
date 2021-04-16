package rental;
import org.junit.*;
import static org.junit.Assert.*;

public class MotorbikeTest{

  private Motorbike m_bike1;
  private Motorbike m_bike2;
 
  @Before
  public void before(){
    this.m_bike1 = new Motorbike("Brand 1", "Model 1", 2014, 85, 750);
    this.m_bike2 = new Motorbike("Brand 2", "Model 2", 2015, 100, 1000);
  }

  @Test
  public void testGetCapacity(){
    assertEquals(750,this.m_bike1.getCapacity());
    assertEquals(1000,this.m_bike2.getCapacity());
  }

  @Test
  public void testToString(){
    assertEquals("2014 Brand 1 85.0 750",this.m_bike1.toString());
    assertEquals("2015 Brand 2 100.0 1000",this.m_bike2.toString());
  }

  public static junit.framework.Test suite() {
    return new junit.framework.JUnit4TestAdapter(rental.MotorbikeTest.class);
  }
}
