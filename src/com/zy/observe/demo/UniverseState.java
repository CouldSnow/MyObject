package com.zy.observe.demo;

public class UniverseState extends SaiyaState {

	public UniverseState(Saiya saiya) {
		super(saiya);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void hit() {
		// TODO Auto-generated method stub
		saiya.setState(saiya.NOMAL);
	}



}
