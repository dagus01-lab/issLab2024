package main.interaction;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import org.apache.http.impl.ConnSupport;
import org.junit.After;
import org.junit.BeforeClass;
import org.junit.Test;

import unibo.basicomm23.interfaces.IApplMessage;
import unibo.basicomm23.interfaces.Interaction;
import unibo.basicomm23.msg.ApplMessage;
import unibo.basicomm23.msg.ProtocolType;
import unibo.basicomm23.utils.CommUtils;
import unibo.basicomm23.utils.ConnectionFactory;

/*
 * ===========================================================================
 * Test che 
 *    - attiva il consumatore (una volta sola)
 *    - esegue il test di invio di una richiesta bloccante e poi una non bloccante
 *     (testRequest) osservabilità data dalla risposta
 * ===========================================================================
 */

public class TestSyncAsync {
	private static Interaction connSupport;

	@BeforeClass
	public static void activateConsumer() {
		CommUtils.outmagenta("activateConsumer");
		new MainEmablersConsumerOnly().configureTheSystem();
		connSupport = ConnectionFactory.createClientSupport(
				          ProtocolType.tcp, "130.136.113.239", "8888");
	}
	@After
	public void down() {
		CommUtils.outmagenta("end of  a test "); 
	}
	
	/*@Test
	public void testSyncAsyncRequests() {
		 CommUtils.outmagenta("testRequest ======================================= ");
		//Funge da Producer come ProducerUsingConnection
		IApplMessage req  = CommUtils.buildRequest( "daga_gabriele", "distance", "distance(20)", "consumer");
		IApplMessage req1 = CommUtils.buildRequest( "daga_gabriele", "distance", "distance(30)", "consumer");
 		try {
 			connSupport.forward(req1);
 			
			IApplMessage reply = connSupport.request(req);
			CommUtils.outblue("reply="+reply);
			String answer = reply.msgContent();
			assertEquals(answer, "ack(distance(20))");	
			
			IApplMessage reply1 = connSupport.receive();
			CommUtils.outblue("reply1="+reply1);
			String answer1 = reply1.msgContent();
			assertEquals(answer1, "ack(distance(30))");
			 
		} catch (Exception e) {
			fail("testRequest " + e.getMessage());
 		}
	}*/
	
	@Test
	public void testAsyncAsyncRequests() {
		 CommUtils.outmagenta("testAsyncAsyncRequests ======================================= ");
		//Funge da Producer come ProducerUsingConnection
		IApplMessage req  = CommUtils.buildRequest( "daga_gabriele", "distance", "distance(20)", "consumer");
		IApplMessage req1 = CommUtils.buildRequest( "daga_gabriele", "distance", "distance(30)", "consumer");
 		try {
 			connSupport.forward(req);
 			connSupport.forward(req1);
 			
			IApplMessage reply = connSupport.receive();
			CommUtils.outblue("reply="+reply);
			String answer = reply.msgContent();
			assertEquals(answer, "ack(distance(20))");	
			
			IApplMessage reply1 = connSupport.receive();
			CommUtils.outblue("reply1="+reply1);
			String answer1 = reply1.msgContent();
			assertEquals(answer1, "ack(distance(30))");
			 
		} catch (Exception e) {
			fail("testRequest " + e.getMessage());
 		}
	}

	protected void readLogFile() throws IOException {	
		String line;
		IApplMessage m;
	      File myObj = new File("Testlog.txt");
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
