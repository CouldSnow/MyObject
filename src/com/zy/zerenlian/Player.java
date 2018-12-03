package com.zy.zerenlian;

public abstract class Player {

	private Player player;
   
	
	public void setPlayer(Player player) {
		this.player = player;
	}

	public void handle(Player player) {
		this.player = player;
	}
	
	public void excuse() {
		
	}
}
