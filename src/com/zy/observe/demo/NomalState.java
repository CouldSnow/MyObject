package com.zy.observe.demo;

public class NomalState extends SaiyaState {

	public NomalState(Saiya saiya) {
		super(saiya);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void hit() {
		saiya.setState(saiya.DYING);
		
	}



}
