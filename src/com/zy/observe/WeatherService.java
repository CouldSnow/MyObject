package com.zy.observe;

public class WeatherService {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Earth earth = new Earth();
		Satellite satellite = new Satellite();
		earth.addObserver(satellite);
		earth.setWeather("running");
	}

}
