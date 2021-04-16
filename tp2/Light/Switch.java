
/**
 *  class Switch
 *
 * @author Medjahed Ainouch
 * @version 29/01/2019
 */
public class Switch{
    // instance variables - replace the example below with your own
    private Lightbulb Lb;
    
    /**
     * Constructor for objects of class Switch
     * @param a Lightbulb to associate to the Switch 
     */
    public Switch(Lightbulb L)
    {
        this.Lb=L;
    }

    /**
     * Switch the state of the associated Lightbulb
     */
    public void ChangeState(){
        Lightbulb object = this.Lb;
        String s = object.getState();
        if (s=="off"){
            object.switchOn();
        }
        else {
            object.switchOff();
        }
    }
}
