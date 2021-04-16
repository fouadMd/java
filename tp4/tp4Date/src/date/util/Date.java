package date.util;

/**
 *Date of a day with month and year
 *@author Medjahed Fouad Ainouch Tarik
 */

public class Date {

    private int day;
    private Month month;
    private int year;

    /**
    *build a date
    *@param day the integer of the day
    *@param month an enum type
    *@param year an integer of the year
    */
    public Date(int day, Month month, int year){
	  this.day = day;
	  this.month = month;
	  this.year = year;
    }
    /**
     *return the Day of Date
     *@return int who corresponds at the day
     */
    public int getDay(){
	    return this.day;
    }


    /**
     *return the month of Date
     *
     *@return Month who corresponds at the day
     */
    public Month getMonth(){
	    return this.month;
    }

    /**
     *return the year of Date
     *@return int who corresponds at the date.
     */
    public int getYear(){
	    return this.year;
    }


    /**
	* returns <code>true</code> if <code>o</code> is equals to this word object, ie if
	* <code>o</code> is a Word and its value is the same as this word's value
	*
	* @param o the object to be compared with this Date
	* @return <code>true</code> iff <code>o</code> is a Date with the same value as this Date.
	*/
    public boolean equals(Object o){
	  if(o instanceof Date){
	    Date other = (Date)o;
	    return other.getDay() == this.day && other.getMonth() == this.month && other.getYear() == this.year;
	   }
	  else{
	    return false;
	   }
    }

    /**
     *return representation of Date
     *@return string is representation of date
     */

    public String toString(){

	     return this.day+"/"+this.month+"/"+this.year;
    }


    /**
     *return 0 if both dates are the same,-1 if the first date is lower than the second else 1

     *@param d is Date
     *@return int is 0 if both dates are the same,-1 if the first date is lower than the second else 1
     */
     public int compareTo2(Date d){

 	  if(this.getYear() < d.getYear()){
        return -1;
    }
    else if((this.getMonth().ordinal() < d.getMonth().ordinal()) && (this.getYear() == d.getYear())){

        return -1;
    }
    else if((this.getDay() < d.getDay()) && ((this.getMonth().ordinal() == d.getMonth().ordinal())&& (this.getYear() == d.getYear()))){
        return -1;
    }
    else if(this.equals(d)){
        return 0;
   }
    else{
   	    return 1;
   	}
   }
   public int compareTo(Date d){
     return differenceInDays(d);
   }

    /**
     *return Date of tomorrow
     *@return Date is the date of tomorrow
     */
    public Date tomorrow(){
    	if((this.month==Month.december) && (this.getDay() == this.month.getNbDays(this.year)) ){
		      return new Date (1, Month.january, this.year+1);
    	}
		    else if((this.getDay())==(this.month.getNbDays(this.year)))  {

		      return new Date (1, this.month.next(), this.year);
      }




	    else{
		      return new Date(this.day+1, this.month, this.year);
		    }
    }

    /**
     *return the gap between 2 Dates
     *@param d is a Date
     *@return int is the number of gap between two days
     */
     public int differenceInDays(Date d){
     Date res = this;
	   int n = 0;
     if(this.compareTo2(d) == -1){
	       while (!res.equals(d)){
		        n+=1;
		        res = res.tomorrow();
	    }
    	}
	else{
	    Date res2 = d;
	    while(!res2.equals(res)){
		      n-=1;
		      res2=res2.tomorrow();
	    }
	}
	return n;
    }

    /**
     *return Date in n days
     *@param n is the number of days after date of start
     *@return Date the date in n days
     */
    public Date DateinNDays(int n){
	     if(n>=0){

	    Date date = this;

	    for(int i = 0; i < n; i++) {
		      date = date.tomorrow();
	    }
	    return date;
	}
	 else{
	    throw new IllegalArgumentException("n must be a postive number");
	}
    }

    /**
     *return true if the year is Leap else false
     *@param y is the year which we want test
     *@return boolean true if the year is Leap else false
     */
    public static boolean isLeap(int y){

       if(((y%100 != 0) && (y%4 == 0)) || (y%400 == 0) ){
	       return true;
	      }
	      else{
	         return false;
	     }
  }



}
