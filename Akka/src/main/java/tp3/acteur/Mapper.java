package tp3.acteur;

import java.util.ArrayList;

import akka.actor.ActorRef;
import akka.actor.UntypedActor;

public class Mapper extends UntypedActor{
	
	
	private ArrayList<ActorRef> reducers;

	@SuppressWarnings("unchecked")
	@Override
	public void onReceive(Object ligne) throws Exception {
		if (ligne instanceof ArrayList<?>) {
			this.reducers = new ArrayList<ActorRef>(); 
			for (ActorRef ar : (ArrayList<ActorRef>) ligne) {
				this.reducers.add(ar);
			}
			
		}
		else if ((ligne instanceof String)) {
			String mots[] = ((String) ligne).trim().split("[\\s.';?(){}:!«»]");
			for (int k=0 ; k < mots.length ; k ++ ) {
				ActorRef ar = partition(mots[k],this.reducers);
				ar.tell(mots[k], self());
			}
		}
	}
	
	public ActorRef partition(String mot, ArrayList<ActorRef> ar) {
		int code = mot.hashCode();
		if (code < 0)
			code = -code;
	    code = code % ar.size();
		return ar.get(code);
		}
}
