package goosegame;

import java.util.*;

/**
 * The representation of Game
 *
 * @author Medjahed Ainouch
 * @version 1.0
*/

public class Game{
	/*the players*/
	protected List<Player> thePlayers;
	/*the board*/
	protected Board board ;

	/**
	*build a Game
	*@param board the board of the game
	*/
	public Game (Board board){
		this.thePlayers=new ArrayList<Player>();
		this.board=board;
	}

	/** add a new Player
    * @param p is the Player who you want add
    */
    public void addPlayer(Player p) {
		this.thePlayers.add(p);
    }

	/**
	*return true if the game is finished else false
	*@return true if the game is finished else false
	*/
	private boolean isFinish(){
		int nbcell=this.board.nbOfCells()-1;
		for (Player p : this.thePlayers){
			if (nbcell==p.getCell().getIndex()){
				return true;
			}
        }
		return false;
	}

	/**
	*return the index of the cell
	*@param resultdice is the result of the methode twoDiceThrows
	*@return the index where the player go
	*/
	private int index(int resultdice,Player p){
		int i=resultdice+p.getCell().getIndex();
		int nbcell= this.board.nbOfCells()-1;
		if(i>nbcell){
			i=nbcell-(i-nbcell);
		}
		Cell cell = this.board.getCell(i);
		i=this.board.getCell(i).Effect(resultdice);
		if(i>nbcell){
			i=nbcell-(i-nbcell);
		}
		return i;
	}

	/**
	*print a round of the game
	*@param p player who plays the round
	*@param resultdice is the result of the methode twoDiceThrows
	*@param index is index of the cell after the effect of the cell
	*@param busy True if cell of index is busy else false
	*@param move True if the player can move else false
	*/
	private void affiche(Player p,int resultdice,int index, boolean busy,boolean move){
		String name1=p.toString();
		int ncell=p.getCell().getIndex();
		if(move){
			if(busy){
				String name2=this.board.getCell(index).getPlayer().toString();
				if(ncell+resultdice<64 && ncell+resultdice!=index){
					System.out.println(name1+" is in cell "+ncell+", "+name1+" throws "+resultdice+" and reaches cell "+(ncell+resultdice)+" "+this.board.getCell(ncell+resultdice).StringEffect()+" and jumps to cell "+index+" is busy, "+name2+" is sent to cell "+ncell);
				}
				else{
					System.out.println(name1+" is in cell "+ncell+", "+name1+" throws "+resultdice+" and reaches cell "+index+" "+this.board.getCell(index).StringEffect()+" is busy, "+name2+" is sent to cell "+ncell);
				}

			}
			else{
				if(ncell+resultdice<64 && ncell+resultdice!=index){
					System.out.println(name1+" is in cell "+ncell+", "+name1+" throws "+resultdice+" and reaches cell "+(ncell+resultdice)+" "+this.board.getCell(ncell+resultdice).StringEffect()+" and jumps to cell "+index);
				}
				else{
					System.out.println(name1+" is in cell "+ncell+", "+name1+" throws "+resultdice+" and reaches cell "+index+" "+this.board.getCell(index).StringEffect());
				}
			}
		}
		else{
			System.out.println(name1+" is in cell "+ncell+", "+name1+" cannot play");
		}
	}

	/**
	* Play the game
	*/
	public void play(){
		for(Player p : this.thePlayers){
			p.setCell(this.board.getCell(0));
			this.board.getCell(0).setplayer(p);
		}
		while(!this.isFinish()){
			for(Player p : this.thePlayers){
				if(p.getCell().canPlay()){
					int resultdice=p.twoDiceThrow();
					int index=this.index(resultdice,p);
					Cell cell = this.board.getCell(index);
					if(cell.isBusy()){
						affiche(p,resultdice,index,true,true);
						Player p2 =cell.getPlayer();
						Cell cellp1=p.getCell();
						p.setCell(cell);
						p2.setCell(cellp1);
						cellp1.remove(p);
						cellp1.setplayer(p2);
						cell.remove(p2);
						cell.setplayer(p);
					}
					else{
						affiche(p,resultdice,index,false,true);
						Cell cellp1=p.getCell();
						cellp1.remove(p);
						p.setCell(cell);
						cell.setplayer(p);
					}
					if(this.board.nbOfCells()-1==index){
						System.out.println(p.toString()+" has won");
						break;
					}
				}
				else{
					affiche(p,0,0,false,false);
				}
			}
		}
	}
}
