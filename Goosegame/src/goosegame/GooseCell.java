package goosegame;

/**
 * The representation of BasicCell
 *
 * @author Medjahed Ainouch
 * @version 1.0
*/

public class GooseCell extends BasicCell {

	/**
	*build a goose cell
	*@param index is the index of the cell
	*/
	public GooseCell (int index){
		super(index);
	}

	/**
	*apply effect to cell
	*@param resultdice is the result of the methode twoDiceThrows
	*@return the index of the cell after the effect of the cell
	*/
	public int Effect(int resultdice){
		return this.getIndex()+resultdice;
	}

	/**
	*return string object which contain effect of the cell
	*@return string object which contain effect of the cell
	*/
	public String StringEffect(){
		return "(goose)";
	}
}
