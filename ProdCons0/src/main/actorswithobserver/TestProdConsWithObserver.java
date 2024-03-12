package main.actorswithobserver;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import org.junit.After;
import org.junit.BeforeClass;
import org.junit.Test;

import main.naiveactors24.ActorContext24;
import main.naiveactors24.ActorNaiveCaller;
import unibo.basicomm23.interfaces.IApplMessage;
import unibo.basicomm23.interfaces.Interaction;
import unibo.basicomm23.msg.ApplMessage;
import unibo.basicomm23.msg.ProtocolType;
import unibo.basicomm23.utils.CommUtils;
import unibo.basicomm23.utils.ConnectionFactory;

public class TestProdConsWithObserver {
private static Interaction connSupport;

	/*@BeforeClass
	public static void activateConsumer() {
		CommUtils.outmagenta("activateConsumer");
		new MainAsActorsConsumerOnly().configureTheSystem();
		connSupport = ConnectionFactory.createClientSupport(
				          ProtocolType.tcp, "localhost", "8223");
	}*/
	private static ObservableActor consumer, prod;
	private static ObsLogger obsLogger;
	private static ActorContext24 ctx1;
	@BeforeClass
	public static void activateConsumerProducerObserver() {
		CommUtils.outmagenta("MainOneNodeWithActors24 CREA I CONTESTI ");
        ctx1 = new ActorContext24("ctxprodcons", "localhost", 8223);
        
        CommUtils.outblue("MainOneNodeWithActors24 CREA GLI ATTORI ");

        prod = new ProducerAsObservableActor("prod1", ctx1);
        //new ProducerAsActors24("prod2", ctx1 );
        consumer = new ConsumerAsObservableActor("consumer", ctx1 );
        obsLogger = new ObsLogger("observer1", ctx1, "obsloggerLog.txt");
        prod.registerObserver(obsLogger);
        consumer.registerObserver(obsLogger);
	}
	@After
	public void down() {
		CommUtils.outmagenta("end of  a test "); 
	}

	@Test
	public void testDispatchToConsumer() {
		 CommUtils.outmagenta("testDispatchToConsumer ======================================= ");
		//Funge da Producer come ProducerUsingConnection
		IApplMessage msg  = CommUtils.buildDispatch( "prod1", "distance", "distance(20)", "consumer");
		IApplMessage msg1 = CommUtils.buildDispatch( "prod1", "distance", "distance(30)", "consumer");
		try {
			prod.sendMsg(msg, ctx1);
			prod.sendMsg(msg1, ctx1);
			CommUtils.delay(500);
 			readLogFile();
		} catch (Exception e) {
			fail("testRequest " + e.getMessage());
 		}
	}
	@Test
	public void testDispatchToProducer() {
		 CommUtils.outmagenta("testDispatchToConsumer ======================================= ");
		//Funge da Producer come ProducerUsingConnection
		IApplMessage msg  = CommUtils.buildDispatch( "consumer", "update", "ok1", "prod1");
		IApplMessage msg1 = CommUtils.buildDispatch( "consumer", "update", "ok2", "prod1");
		try {
			prod.sendMsg(msg, ctx1);
			prod.sendMsg(msg1, ctx1);
			CommUtils.delay(500);
			readLogFile();
		} catch (Exception e) {
			fail("testRequest " + e.getMessage());
		}
	}

	protected void readLogFile() throws IOException {	
		String line;
		IApplMessage m;
	      File myObj = new File("obsloggerLog.txt");
	      Scanner myReader = new Scanner(myObj);
	      line = myReader.nextLine();
	      m = new ApplMessage(line);
	      CommUtils.outblue( ""+m  );
	      assertEquals(m.msgContent(), "distance(20)");
	      line = myReader.nextLine();
	      m = new ApplMessage(line);
	      CommUtils.outblue( ""+m  );
	      assertEquals(m.msgContent(), "distance(30)");	      

	      myReader.close();


	
	
	}
}
