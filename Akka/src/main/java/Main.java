import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

import com.typesafe.config.ConfigFactory;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import tp3.acteur.Mapper;
import tp3.acteur.Reducer;

public class Main {
   
	public static void main (String[] args){
		
		com.typesafe.config.Config config1 = ConfigFactory.parseString((" akka {\n"
							+ "     actor {\n"
							+ "      provider = \"akka.remote.RemoteActorRefProvider\"\n"
							+ "    }\n"
							+ "     remote {\n"
							+ "       enabled-transports = [\"akka.remote.netty.tcp\"]\n"
							+ "       netty.tcp {\n"
							+ "         port = 2554\n"
							+ "       }\n"
							+ "     }\n"
						    + "  }"));
		
		com.typesafe.config.Config config2 = ConfigFactory.parseString((" akka {\n"
							+ "     actor {\n"
							+ "      provider = \"akka.remote.RemoteActorRefProvider\"\n"
							+ "    }\n"
							+ "     remote {\n"
							+ "       enabled-transports = [\"akka.remote.netty.tcp\"]\n"
							+ "       netty.tcp {\n"
							+ "         port = 8081\n"
							+ "       }\n"
							+ "     }\n"
							+ "  }"));
		
		
		ActorSystem system1 = ActorSystem.create("System1", config1);
		
		ActorSystem system2 = ActorSystem.create("System2", config2);
		
		ArrayList<ActorRef> mappers,reducers;
		
		
		mappers = new ArrayList<ActorRef>();
	    for (int i = 0; i < 3; i++) {
	    	if (i < 2)
	    		mappers.add(system1.actorOf(Props.create(Mapper.class), "mapper" + i));
	    	if (i >= 2)
	    		mappers.add(system2.actorOf(Props.create(Mapper.class), "mapper" + i));
	        }
	    reducers = new ArrayList<ActorRef>();
	    for (int i = 0; i < 2; i++) {
	    	if (i < 1)
	    		reducers.add(system1.actorOf(Props.create(Reducer.class), "reducer" + i));
	    	if (i >= 1)
	    		reducers.add(system2.actorOf(Props.create(Reducer.class), "reducer" + i));
	        }
		
		
		for (ActorRef mapper : mappers) {
        	mapper.tell(reducers, ActorRef.noSender());
        }
		
		try {
			BufferedReader br = new BufferedReader(new FileReader("src/main/resources/file.txt"));
			
			String ligne;
			String texte = "";
			
			while ((ligne = br.readLine()) != null) {
			    
				texte += ligne + "\n";
			
			}
		br.close();
		String lignes[] = ((String) texte).split("\n");
		
		int map = 0;
		for (int s = 0 ; s < lignes.length ; s++) {
			if (map >= 3) 
				map = 0;;
				mappers.get(map).tell(lignes[s], ActorRef.noSender());
			map++;
		}
		
		
		} catch (Exception e) {
			e.printStackTrace();
		}
   }
}


