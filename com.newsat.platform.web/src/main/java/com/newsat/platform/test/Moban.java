package com.newsat.platform.test;

class Moban <T>{
	private T ob;
	
	public Moban(T ob){
		this.ob = ob;
	}
	
	public T getOb(){
		return ob;
	}
	
	public void setOb(T ob){
		this.ob = ob;
	}
	
	public void showType(){
		System.out.println("T的实际类型是：" + ob.getClass().getName());
	}
}
