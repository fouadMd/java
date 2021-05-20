package tp3.acteur;

import java.util.HashMap;

import akka.actor.UntypedActor;

public class Reducer extends UntypedActor{
	
	private HashMap<String,Integer> compteur;

	@Override
	public void onReceive(Object mot) throws Exception {
		if ((mot instanceof String) && !mot.equals(" ") && !mot.equals("") ) {
			if (compteur.containsKey(mot)) {
				compteur.put((String) mot, compteur.get(mot)+1);
			}
			else {
				compteur.put((String) mot, 1);
			}
			System.out.println(" "+ (String) mot  + " :  "+ compteur.get(mot));
		}
	}
	
	@Override
    public void preStart() {
        compteur = new  HashMap<String,Integer>();
    }
}
