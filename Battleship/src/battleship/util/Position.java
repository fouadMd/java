package battleship.util;

public class Position{

  //line
  private int x;


  //row
  private int y;



  /** Create a position by a line and a row which
   *    will be used to point a cell of the game board
   * @param x a line
   * @param y a row
   */
  public Position(int x, int y){
    this.x=x;
    this.y=y;
  }




  /**return the attribute y of the Position
   * @return the attribute X
   */
  public int getX(){
    return this.x;
  }



  /**return the attribute y of the Position
   * @return the attribute Y
   */
  public int getY(){
    return this.y;
  }



  /** method equals
   * @return <code>true</code> if the two elements are equals
   *    <code>false</code> in otherwise
   */
  public boolean equals(Object o){
    if (o!=null && this.getClass()==o.getClass()){
      Position Other = (Position) o;
      return (this.getX()==Other.getX() && this.getY()==Other.getY());
    }else{
      return false;
    }
  }



  /** method toString
   *  @return a String description of the Position
   */
  public String toString(){
    return "The xCoordonnate is "+ this.getX()+" and the yCoodonnate is "+this.getY();
  }


}
