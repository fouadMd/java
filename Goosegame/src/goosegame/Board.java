package goosegame;

/**
 * The representation of Board
 *
 * @author Medjahed Ainouch
 * @version 1.0
*/
public abstract class Board{

	/*the number of cells in the board*/
	protected final int NB_OF_CELLS ;
	/*the cells in the board*/
	protected Cell [] theCells;

	/**
	*build a board
	*@param nbofcells is the number of cells
	*/
	public Board (int nbofcells){
		this.NB_OF_CELLS= nbofcells;
		this.theCells= new Cell[nbofcells];
		this.theCells[0]=new StartCell(0);
		this.initBoard();
	}

	/**
	*get cell which the index is n
	*@param n is the number of cell
	*@return nth Cell
	*/
	public Cell getCell(int n){
		return this.theCells[n];
	}

	/**
	*initialise the board
	*/
	protected abstract void initBoard();

	/**
	*Return the number of cells in the board
	*@return the number of cells in the board
	*/
	public int nbOfCells(){
		return this.NB_OF_CELLS;
	}
}
