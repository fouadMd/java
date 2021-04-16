
/**
 * LightString
 *
 * @author Medjahed Ainouch
 * @version 01/02/2019
 */
public class LightString{
    // instance variables - replace the example below with your own
    private Lightbulb[] tLight;
    private int number;
    private String state;
  

    /**
     * Constructor for objects of class LightString
     */
    public LightString(int n){
        this.state="off";
        this.number=n;
        this.tLight=new Lightbulb[n];
        for(int i=0;i<n;i++){
            tLight[i]=new Lightbulb(1,"white");
        }
    }
    /**
     * return the number of Lightbulbs in the LightString
     * @return an integer number of Lightbulbs
     */
    public int getNumber(){
        return this.number;
    }
    /**
     * return the state of the LightString
     * @return "on" or "off"
     */
    public String getState(){
        return this.state;
    }
    /**
     * return an array of lightbulbs in LightString
     * @return an array of Lightbulbs
     */
    public Lightbulb[] getTable(){
        return this.tLight;
    }
    /**
     * return the i-th lightbulb of the LightString
     * @param i the index of the Lightbulb (first has number 1)
     * @return a Lightbulb
     */
    public Lightbulb getLightbulb(int i){
        if (i>=this.number || i<0){
            return null;
        }
        else{
        return this.tLight[i-1];
        }
    }
    /**
     * Change the state of the LightString from on to off or from off to on
     */
    public void ChangeState(){
        if (this.state=="off"){
            for(int i=0;i<this.number;i++){
                tLight[i].switchOn();
            }
            this.state="on";
        }
        else if(this.state=="on"){
            for(int i=0;i<this.number;i++){
                tLight[i].switchOff();
            }
            this.state="off";
        }
    }
    /**
     * replace the n-th lightbulb of the light string by the given lightbulb.
     * Nothing happens if i is not a valid index.
     * @param i the number of the lightbulb to be changed (first has number 1)
     * @param theBulb the new lightbulb
     */
    public void changeLightbulb(int i,Lightbulb theBulb){
        if(i>0 || i<=this.number){
            this.tLight[i-1]=theBulb;
        }
    }
    /**
     * return the consumed power when the LightString is on
     * @return a double : the consumed power
     */
    public double getConsumedPower(){
        if (this.state=="off"){
            return 0;
        }
        else{
            double res=0;
            for(int i=1;i<=this.number;i++){
                res+=this.getLightbulb(i).getPower();
            }
        return res;
    }
    }
}