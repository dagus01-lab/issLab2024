package main.actorswithobserver;

import main.naiveactors24.ActorContext24;
import unibo.basicomm23.utils.CommUtils;


/*
 * ===========================================================================
 * Crea due Producer come Actors24
 * Crea il Consumer come Actors24
 * I componenti-attori sono attivati quando creati
 * ===========================================================================
 */
public class MainOneNodeWithActorsAndObserver {

	public static final int port = 8223;
	public static final String entry = ""+port;
	
	public void configureTheSystem()  {
         
        CommUtils.outblue("MainOneNodeWithActors24 CREA I CONTESTI ");
        ActorContext24 ctx1 = new ActorContext24("ctxprodcons", "localhost", port);
        
        CommUtils.outblue("MainOneNodeWithActors24 CREA GLI ATTORI ");

        ObservableActor prod1 = new ProducerAsObservableActor("prod1", ctx1 );
        //new ProducerAsActors24("prod2", ctx1 );
        ObservableActor consumer = new ConsumerAsObservableActor("consumer", ctx1 );
        ObsLogger obsLogger = new ObsLogger("observer1", ctx1, "obsloggerLog.txt");
        prod1.registerObserver(obsLogger);
        consumer.registerObserver(obsLogger);
        
        
        
        //Utility per visualizzare i nomi degli attori locali al Contesto
        ctx1.showActorNames();  
        
        CommUtils.delay(1000);
        
	}
	

	/*
	 * main
	 */
	public static void main(String[] args)  {
		 new MainOneNodeWithActorsAndObserver().configureTheSystem();
	}

}
