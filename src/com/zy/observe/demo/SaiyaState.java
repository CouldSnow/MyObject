package com.zy.observe.demo;

public abstract class SaiyaState {
	
	protected Saiya saiya;
	public SaiyaState(Saiya saiya) {
		this.saiya = saiya;
	}
	
	public  abstract void hit();
	
	public   String status() {
		return this.getClass().getName();
	};
} 
