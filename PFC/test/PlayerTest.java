import org.junit.*;
import static org.junit.Assert.*;
import PFC.*;
import PFC.strat.*;

public class PlayerTest {

	@Test
	public void PlayerCreation() {
		Strategy0 strat=new Strategy0();
		Player p1= new Player("name",strat);
		assertNotNull(p1);
	} 

	@Test
	public void playTest() {
		Strategy1 strat=new Strategy1();
		Player p1= new Player("name",strat);
		assertEquals(Move.PAPER,p1.play());
	}

	@Test
	public void getScoreTest() {
		Strategy0 strat=new Strategy0();
		Player p1= new Player("name",strat);
		assertEquals(0,p1.getScore());
		p1.addScore(3);
		assertEquals(3,p1.getScore());
	}

	@Test
	public void getNameTest() {
		Strategy0 strat=new Strategy0();
		Player p1= new Player("name",strat);
		assertEquals("name",p1.getName());
		Player p2= new Player("timoleon",strat);
		assertEquals("timoleon",p2.getName());
	}

	@Test
	public void addScoreTest() {
		Strategy0 strat=new Strategy0();
		Player p1= new Player("name",strat);
		p1.addScore(3);
		assertEquals(3,p1.getScore());
		p1.addScore(2);
		assertEquals(5,p1.getScore());
	}

	public static junit.framework.Test suite() {
        return new junit.framework.JUnit4TestAdapter(PlayerTest.class);
    }
}
