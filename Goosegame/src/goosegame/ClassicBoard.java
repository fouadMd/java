package goosegame;

/**
 * The representation of ClassicBoard
 *
 * @author Medjahed Ainouch
 * @version 1.0
*/

public class ClassicBoard extends Board{

	/*the board*/
	public final static ClassicBoard THE_BOARD = new ClassicBoard();

	/**
	*build a classic board
	*
	*/
	public ClassicBoard (){
		super(64);
	}

	/**
	*initialise the board
	*/
	protected void initBoard(){
		for (int i=1;i<super.nbOfCells();i++){
			this.theCells[i]=new BasicCell(i);
		}
		this.theCells[9]=new GooseCell(9);
		this.theCells[18]=new GooseCell(18);
		this.theCells[27]=new GooseCell(27);
		this.theCells[36]=new GooseCell(36);
		this.theCells[45]=new GooseCell(45);
		this.theCells[54]=new GooseCell(54);
		this.theCells[31]=new TrapCell(31);
		this.theCells[52]=new TrapCell(52);
		this.theCells[19]=new WaitCell(19,2);
		this.theCells[6]=new JumpCell(6,12);
		this.theCells[42]=new JumpCell(42,30);
		this.theCells[58]=new JumpCell(58,1);
	}
}
