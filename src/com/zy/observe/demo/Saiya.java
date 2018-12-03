package com.zy.observe.demo;

import java.util.Observable;

public class Saiya extends Observable{

	public final SaiyaState NOMAL = new NomalState(this);
	public final SaiyaState DYING = new DyingState(this);
	public final SaiyaState CODDESS = new GoddessState(this);
	public final SaiyaState UNIVERSE = new UniverseState(this);
	
	private SaiyaState state = NOMAL;
	private SaiyaState laststate=null;
	
	public void hit() {
		state.hit();
	}
	public String status() {
		return state.status();
	}
	public void setState(SaiyaState state) {
		laststate = this.state;
		this.state = state;
		setChanged();
		notifyObservers("状态变化");
	}
	public String getlastStatus() {
		return laststate.status();
	}
}
