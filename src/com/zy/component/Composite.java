package com.zy.component;

import java.io.Console;
import java.util.ArrayList;
import java.util.List;

public class Composite extends Component{

	public Composite(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}


	List<Component> componets = new ArrayList<>();

	@Override
	public void add(Component c) {
		componets.add(c);
		
	}

	@Override
	public void remove(Component c) {
		// TODO Auto-generated method stub
		componets.remove(c);
	}

	@Override
	public void disPlay(int depth) {
		// TODO Auto-generated method stub
		String s ="";
		for(int i=0;i<depth;i++) {
			s+="- ";
		}
		System.out.println(s+name);
		for(Component component:componets) {
			component.disPlay(depth+2);
		}
		
		
		
	}
	
	
}
