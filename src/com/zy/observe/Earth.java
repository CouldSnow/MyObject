package com.zy.observe;

import java.util.Observable;
import java.util.Observer;

public class Earth  extends Observable{

	private String weather="sonny";
	private int index=0;
	
	public String getWeather() {
		return weather;
	}

	public void setWeather(String weather) {
		this.index++;
		/*if(this.index==10) {
			this.index=0;
		}*/
		this.weather = weather;
		if(this.index<10) {
			setChanged();
			notifyObservers(weather); //唤醒观察者 Observable里面肯定有一个list 或者map记录被添加的观察者
		}
	}


}
