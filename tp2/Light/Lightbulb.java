
/**
 * A Lightbulb defined by its power and color.
 *
 * @author Medjahed Ainouch
 * @version 29/01//2019
 */
public class Lightbulb {
    // instance variables - replace the example below with your own
    private String color;
    private double power;
    private String state;

    /**
     * Constructor for objects of class Lightbulb
     */
    public Lightbulb(int p,String c){
        this.state="off";
        this.power=p;
        this.color=c;
        }

    /**
     * Switch on the lightbulb
     */
    public void switchOn(){
        if (this.state=="off"){
            this.state="on";
    }
    }
    /**
     * Switch off the lightbulb
     */
    public void switchOff(){
        if (this.state=="on"){
            this.state="off";
    }
    }
    /**
     * return the power of the Lightbulb
     * @return a double which represent the Power of the Lightbulb
     */
    public double getPower(){
        return this.power;
    }
    /**
     * return the color of the Lightbulb
     * @return a String which represents the Lightbulb color
     */
    public String getColor(){
        return this.color;
    }
    /**
     * describe the Lightbulb state
     * @return "off" or "on"
     */
    public String getState(){
        return this.state;
    }
    /**
     * return a description of the Light
     */
    public String ToString(){
        return "The "+this.color+" Light of "+this.power+" Watt is actually "+this.state+".";
    }
}
