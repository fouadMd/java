package battleship.util;

import battleship.util.*;

/** The sea in the battleship game = the game board
 *
 */
public class Sea {

	// the cells of the game board
	private Cell[][] theCells;
	// to handle the end of the game
	private int totalShipsLifePoints;

	private int nbC;
	private int nbR;



	/** creates a sea with given rows and columns numbers
	 * @param numberOfRows the number of rows
	 * @param numberOfColumns the number of columns
	 */
	public Sea(int numberOfRows, int numberOfColumns) {
		this.theCells = new Cell[numberOfRows][numberOfColumns];
		for (int i = 0; i < this.theCells.length; i++)
			for (int j = 0; j < this.theCells[0].length; j++) {
				this.theCells[i][j] = new Cell();
			}
		this.totalShipsLifePoints = 0;
		this.nbC=numberOfColumns;
		this.nbR=numberOfRows;
	}



	/** Return the cell in the wanted Position
	 * @param p the Position of the cell
	 * @return the cell corresponding to the position p
	 */
	public Cell getCell(Position p){
		return this.theCells[p.getX()][p.getY()];
	}


	/** Return the total lifePoints of the Sea
	 * @return the integer of the total lifepoints of the sea
	 */
	public int getSeaLifePoints(){
  	return this.totalShipsLifePoints;

	}


	/** the given position is shot (aimed) by the player, the result is returned
	 * @param p the aimed position
	 * @return the result of the shoot, depending on whether there is a ship or not in the cell corresponding to aimed position
	 * @throws ArrayIndexOutOfBoundsException index out of bounds
	 */
	public Answer shoot(Position p) throws ArrayIndexOutOfBoundsException {
		Cell c = this.theCells[p.getX()][p.getY()];
	if (p.getX()<0 || p.getX()>this.nbR){
		throw new ArrayIndexOutOfBoundsException("false position");
	}
	else if (p.getY()<0 || p.getY()>this.nbC){
		throw new ArrayIndexOutOfBoundsException("false position");
	}
	else{
		if (c.hasBeenShot()){
			throw new ArrayIndexOutOfBoundsException("the cell already been attacked");
		}
		else{
			Answer a = this.getCell(p).shoot();
			if (a==Answer.MISSED){
				return a;
			}
			this.totalShipsLifePoints--;
			return a;
			}
		}
		}


	/** displays the board line by line and cell by cell,
	 *     the display changes for the defender or the opponent, defined
	 *     by the <code>defender</code> argument
	 * @param defender <code>true</code> if display is for defender,
	 *    <code>false</code> if for opponent
	 */
	public void display(boolean defender){
		for( int i = 0; i < this.nbR ; i++){
			for( int j = 0; j < this.nbC ; j++){
				System.out.print(this.theCells[i][j].getcharacter(defender));
				}
		System.out.println("");
			}
	}



  /** add the ship b vertically down from position p. The number of
	 *    cells is determined by the ship length
	 * @param shipToPlace the ship to add
	 * @param p the position of the first (top) cell occupied by the ship
	 * @throws IllegalStateException if the ship b can not be placed on the sea
	 *   (outside of the board or some cell is not empty)
	 */
	public void addShipVerticaly( Ship shipToPlace, Position p) throws IllegalStateException{
		if (p.getX()<0 || p.getY()<0){
			throw new IllegalStateException("Position is false");
			}
		else if (p.getX()+shipToPlace.getLifePoints()-1>this.nbR || p.getX() >= this.nbR){
			throw new IllegalStateException("position is false");
			}
		else{
			int Lf = shipToPlace.getLifePoints();
			this.getCell(p).setShip(shipToPlace);
			for (int i=1 ; i<Lf ; i++){
				if (this.getCell(new Position(p.getX()+i,p.getY())).isOccuped()){
					throw new IllegalStateException("the cell is occuped");
					}
			this.getCell(new Position(p.getX()+i,p.getY())).setShip(shipToPlace);
				}
			}
		int t = this.totalShipsLifePoints;
		this.totalShipsLifePoints= t + shipToPlace.getLifePoints();
	}





	/** add the ship b Horizontally right from position p. The number of
	 *    cells is determined by the ship length
	 * @param shipToPlace the ship to add
	 * @param p the position of the first (left) cell occupied by the ship
	 * @throws IllegalStateException if the ship b can not be placed on the sea
	 *   (outside of the board or some cell is not empty)
	 */
	public void addShipHorizontaly( Ship shipToPlace, Position p) throws IllegalStateException{
		if (p.getX()<0 || p.getY()<0){
			throw new IllegalStateException("Position is false");
			}
		else if (p.getY()+shipToPlace.getLifePoints()-1>this.nbC || p.getY() >= this.nbC){
			throw new IllegalStateException("position is false");
			}
		else{
			int Lf = shipToPlace.getLifePoints();
			this.getCell(p).setShip(shipToPlace);
			for (int i=1 ; i<Lf ; i++){
				if (this.getCell(new Position(p.getX(),p.getY()+i)).isOccuped()){
					throw new IllegalStateException("the cell is occuped");
					}
			this.getCell(new Position(p.getX(),p.getY()+i)).setShip(shipToPlace);
				}
			}
		int t = this.totalShipsLifePoints;
		this.totalShipsLifePoints= t + shipToPlace.getLifePoints();
	}


}
