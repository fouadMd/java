package date.util;


/**
 *@author Medjahed Fouad Ainouch Tarik
 *@version 1.0
 */

/**
 *create all months
 *
 */
public enum Month {
    january(31), february(28), march(31), april(30), may(31), june(30), july(31), august(31), september(30), october(31), november(30), december(31);

    private final int nbDays;

    private Month (int nbDays){

       this.nbDays = nbDays;
    }

    /**
     *return the number of Days of month
     *@param year is the year of our date
     *@return int is year of month which we want test
     */
    public int getNbDays(int year){
    Date date = new Date(1, this, year);
	  if(date.isLeap(year) && this == Month.february){
	    return this.nbDays+1;
	  }
   	else{
	     return this.nbDays;
	  }

     }

    /**
     *return the next month
     *@return Month the next month
     */

    public Month next(){
	      return Month.values()[(this.ordinal()+1)%Month.values().length];
    }
}
