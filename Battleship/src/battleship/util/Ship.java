package battleship.util;


public class Ship{


  private int length;


  private int lifePoints;


  /** Create a ship by his length
   *   (lifepoints=length)
   * @param len the length of the ship
   */
  public Ship(int len){
    this.length = len;
    this.lifePoints = len;
  }




  public int getLifePoints(){
    return this.lifePoints;
  }




  public int getLength(){
    return this.length;
  }




  public boolean hasBeenSunk(){
    if (this.getLifePoints() == 0 ){
      return true;
    }
    else{
      return false;
    }
  }




  public void hit(){
    if (!this.hasBeenSunk()){
      this.lifePoints=this.lifePoints-1;
      }
  }
}
