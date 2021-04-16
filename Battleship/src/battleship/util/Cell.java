package battleship.util;
import battleship.util.*;


/** A Cell is used to create a see
 *
 */
public class Cell{



  // if the cell has been shot
  private boolean hasBeenShot;



  //the ship which occupe the cell
  private Ship ship;


  //if the cell is occupied
  private boolean occuped;



  /** Create a free cell
   *
   */
  public Cell(){
    this.ship = null;
    this.hasBeenShot = false;
  }



  public void setShip(Ship s){
    this.ship = s;
    this.occuped = true;
  }



  /** return if the cell is occupied
   * @return <code>true</code> if the cell is occupied,
   *   <code>false</code> in otherwise
   */
  public boolean isOccuped(){
    return this.occuped;
  }



  /** return the ship which occupes the cell
   * @return the ship in the cell
   */
  public Ship getShip(){
    return this.ship;
  }



  /** return if the cell has been shot
   * @return <code>true</code> if the cell has been shot,
   *   <code>false</code> in otherwise
   */
  public boolean hasBeenShot(){
    return this.hasBeenShot;
  }



  /** shoot one cell and change it attributs
   * @return <code>HIT</code> if a ship was touched,
   *    <code>SUNK</code> if a ship was sunked
   *   <code>MISSED</code> in otherwise
   */
  public Answer shoot(){
    if (this.isOccuped()){
      this.ship.hit();
      if (this.ship.hasBeenSunk()){
	this.hasBeenShot = true;
        return Answer.SUNK;
      }
      else{
	this.hasBeenShot = true;
        return Answer.HIT;
      }
    }
    else{
      this.hasBeenShot = true;
      return Answer.MISSED;
    }
  }



  /** displays the cell, the display changes for the defender or the opponent, defined
   *     by the <code>p</code> argument
   * @param p <code>true</code> if display is for defender,
   *    <code>false</code> if for opponent
   * @return the character representing the cell
   */
  public String getcharacter(boolean p){
    if (p==true){
      if (this.getShip()!=null){
        if (this.hasBeenShot()){
          return("*");
        }
        else{
          return("B");
        }
        }
        else{
          return("~");
        }
      }
    else{
      if (this.hasBeenShot()){
        if (this.getShip()!=null){
          return("*");
          }
        else{
          return("~");
        }
        }
      else{
        return(".");
      }
    }

 }




}
