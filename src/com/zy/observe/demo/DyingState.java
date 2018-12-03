package com.zy.observe.demo;

public class DyingState extends SaiyaState {

	public DyingState(Saiya saiya) {
		super(saiya);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void hit() {
		// TODO Auto-generated method stub
		saiya.setState(saiya.CODDESS);
	}



}
