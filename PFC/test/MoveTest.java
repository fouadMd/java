import org.junit.*;
import static org.junit.Assert.*;
import PFC.*;
import PFC.strat.*;

public class MoveTest {
 
	@Test
	public void CompareTest(){
		assertEquals(0,Move.PAPER.compare(Move.PAPER));
		assertEquals(1,Move.PAPER.compare(Move.ROCK));
		assertEquals(-1,Move.ROCK.compare(Move.PAPER));
		assertEquals(1,Move.SCISSORS.compare(Move.PAPER));
	}

	public static junit.framework.Test suite() {
        return new junit.framework.JUnit4TestAdapter(MoveTest.class);
    }
}
