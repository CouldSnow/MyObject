package com.zy.observe.demo;

public class GoddessState extends SaiyaState {

	public GoddessState(Saiya saiya) {
		super(saiya);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void hit() {
		// TODO Auto-generated method stub
		saiya.setState(saiya.UNIVERSE);
	}



}
