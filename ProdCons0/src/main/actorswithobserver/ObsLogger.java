package main.actorswithobserver;

import java.io.FileWriter;
import java.io.IOException;

import main.naiveactors24.ActorBasic24;
import main.naiveactors24.ActorContext24;
import unibo.basicomm23.interfaces.IApplMessage;

public class ObsLogger extends ActorBasic24 {

	private FileWriter myWriter;
	public ObsLogger(String name, ActorContext24 ctx, String logFileName) {
		super(name, ctx);
		//Writer del log file per il testing 
		try {
			myWriter = new FileWriter(logFileName);
		} catch (IOException e) {
 			e.printStackTrace();
		}
		activateAndStart();
	}
	
	@Override
	protected void elabMsg(IApplMessage msg) throws Exception {
		try {
			 myWriter.append(msg+"\n");
			 myWriter.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
