package main.actorswithobserver;

import java.io.FileWriter;
import java.io.IOException;

import main.naiveactors24.ActorBasic24;
import main.naiveactors24.ActorContext24;
import unibo.basicomm23.interfaces.IApplMessage;
import unibo.basicomm23.utils.CommUtils;


/* 
 * ===========================================================================
 * Eredita da  ActorBasic24 la capacit� di elaborare in modo FIFO i messaggi 
 * posti sulla sua coda di input.
 * Si attiva invocando il metodo activateAndStart che pone sulla coda 
 *       msg(cmd,dispatch,consumer,consumer,start,1)
 * In quanto Consumer, tratta solo messaggi con msgId="distance"
 * Nel caso di request invia un ack come reply.
 * ===========================================================================
 */

public class ConsumerAsObservableActor extends ObservableActor{

	public ConsumerAsObservableActor(String name, ActorContext24 ctx) {
		super(name, ctx);
		activateAndStart();
	}

	@Override
	protected void elabMsg(IApplMessage msg) throws Exception {
		CommUtils.outyellow( name + " | elabMsg " + msg + " " + Thread.currentThread().getName() ) ; 
		if( msg.msgId().equals("distance")) handleMsg(msg);
		
	}

	public void handleMsg( IApplMessage msg ) {       
        CommUtils.outgreen(name + "  | consumes " + msg.msgContent() + " sent by " + msg.msgSender() + " " + Thread.currentThread().getName());		
        if( msg.isRequest() ) {
	        String outMsg = "ack("+msg.msgContent()+")";
	 		IApplMessage reply = CommUtils.buildReply( name, "ack", outMsg, msg.msgSender());
	        CommUtils.outgreen(name + "  | sends reply= " + reply );		
			reply(msg, reply);
        }
	}
 
}
