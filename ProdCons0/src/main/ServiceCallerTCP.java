package main;
import unibo.basicomm23.interfaces.IApplMessage;
import unibo.basicomm23.interfaces.Interaction;
import unibo.basicomm23.mqtt.MqttConnection;
import unibo.basicomm23.msg.ProtocolType;
import unibo.basicomm23.utils.BasicMsgUtil;
import unibo.basicomm23.utils.CommUtils;
import unibo.basicomm23.utils.ConnectionFactory;

public class ServiceCallerTCP {
 	private Interaction conn ;
 	private String  nfibo = "4";
 	private String payload="dofibo(N)".replace("N", nfibo);
 	private IApplMessage req = BasicMsgUtil.buildRequest("clientJava", "dofibo", payload, "servicemath");
 	private String mqttAnswerTopic = "answ_dofibo_clientJava";
	
	public void doJob() {
	 try {
		 String hostAddr = "130.136.113.239";
		 String entry = "8011";
		 ProtocolType protocol = ProtocolType.tcp;
		 conn = ConnectionFactory.createClientSupport(protocol, hostAddr, entry);
		 sendRequestSynch( req, conn, protocol );
		 sendRequestAsynch( req, conn, protocol );
		 conn.close();
		 Thread.sleep(5000);
		 System.exit(0);
	 }catch(Exception e){
	    CommUtils.outred("ERROR " + e.getMessage() );
	 }      
   }
  	
	protected  void sendRequestSynch( IApplMessage m, Interaction conn, ProtocolType protocol  ) throws Exception {
		String answer = "todo";
		answer = conn.request(req.toString()); 
		CommUtils.outmagenta( protocol + " | sendRequestSynch answer=" + answer );   	
    }  

    protected  void sendRequestAsynch( IApplMessage m, Interaction conn, ProtocolType protocol  ) throws Exception {
    	conn.forward(req.toString()); 
    	CommUtils.outgreen("I'm waiting for the response, but meanwhile I can do everything I want!");
		String answer = conn.receiveMsg();
		CommUtils.outmagenta( protocol + " | sendRequestAsynch answer=" + answer  );   	
    }  
    
    public static void main( String[] args) {
    	new ServiceCallerTCP().doJob();
    }

}

