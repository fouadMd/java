package PFC;
/**
 * The list of move
 *
 * @author Medjahed Fouad Aiouch Tarik
 * @version 26/03/2019
 */

public enum Move{
  ROCK,PAPER,SCISSORS;
  /**
  *this function compare the first move with the second and says if you win, lose or draw
  *@param move is ROCK or PAPER or SCISSORS
  *@return 1 if your move win, -1 if you lose and 0 if draw
  */
  public int compare(Move move){
    if(this.ordinal()==move.ordinal()){
      return 0;
    }
	if(this.ordinal()==2 && move.ordinal()==0){
      return -1;
    }
    if(this.ordinal()==0 && move.ordinal()==2){
      return 1;
    }
    if(this.ordinal()>move.ordinal()){
      return 1;
    }
    else{
      return -1;
    }
  }
}
