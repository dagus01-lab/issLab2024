package main.actorswithobserver;

import java.util.ArrayList;
import java.util.List;

import main.naiveactors24.ActorBasic24;
import main.naiveactors24.ActorContext24;
import unibo.basicomm23.interfaces.IApplMessage;
import unibo.basicomm23.utils.CommUtils;

public abstract class ObservableActor extends ActorBasic24 {

	protected List<ActorBasic24> observers = new ArrayList<>();
	private int n = 0;
	public ObservableActor(String name, ActorContext24 ctx) {
		super(name, ctx);
		// TODO Auto-generated constructor stub
	}
	
	public boolean registerObserver(ActorBasic24 actor) {
		return observers.add(actor);
	}
	
	public boolean unRegisterObserver(ActorBasic24 actor) {
		return observers.remove(actor);
	}
	
	@Override
	protected void sendMsg( IApplMessage msg, ActorContext24 ctx  ) {
		super.sendMsg(msg, ctx);
		updateResource(msg.msgContent());
	}

	protected void updateResource(String s) {
		for(ActorBasic24 o: observers) {
			IApplMessage msg = CommUtils.buildDispatch(this.name, "hello"+n, s, o.getName());
			n++;
			sendMsg(msg, ctx);
		}
	}

}
