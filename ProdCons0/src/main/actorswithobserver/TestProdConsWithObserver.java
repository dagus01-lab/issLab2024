package main.actorswithobserver;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import org.junit.After;
import org.junit.AfterClass;
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
	private static File myObj ;
    private static Scanner myReader;
    @BeforeClass
    public static void setUpEnv() throws IOException{
    	myObj = new File("obsloggerLog.txt");
    	myReader = new Scanner(myObj);
    }
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
	@AfterClass
	public static void down() {
		CommUtils.outmagenta("end of  a test "); 
		myReader.close();
	}

	@Test
	public void testUpdateConsumer() {
		 CommUtils.outmagenta("testUpdateConsumer ======================================= ");
		try {
			prod.updateResource("res1");
			//prod.sendMsg(msg1, ctx1);
			CommUtils.delay(500);
 			testLogFile("res1");
		} catch (Exception e) {
			fail("testRequest " + e.getMessage());
 		}
	}
	@Test
	public void testUpdateProducer() {
		 CommUtils.outmagenta("testUpdateProducer ======================================= ");
		try {
			prod.updateResource("res2");
			//prod.sendMsg(msg1, ctx1);
			CommUtils.delay(500);
			testLogFile("res2");
		} catch (Exception e) {
			fail("testRequest " + e.getMessage());
		}
	}

	protected void testLogFile(String expected) throws IOException {	
		
	      String line = myReader.nextLine();
	      ApplMessage m = new ApplMessage(line);
	      CommUtils.outblue( ""+m  );
	      assertEquals(m.msgContent(), expected);	
	}
}
