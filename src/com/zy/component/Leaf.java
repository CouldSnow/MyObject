package com.zy.component;

public class Leaf extends Component{

	public Leaf(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void add(Component c) {
		throw  new MyException("出异常了");
	}

	@Override
	public void remove(Component c) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void disPlay(int depth) {
		String s ="";
		for(int i=0;i<depth;i++) {
			s+="- ";
		}
		System.out.println(s+name);
		
	}

	
}
