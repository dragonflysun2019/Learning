package com.newsat.platform.observer;

public class VideoFans implements Observer{
	private String name;
	public VideoFans(String name){
		this.name = name;
	}
	
	public void update(Subject s){
		System.out.println(this.name + ", new videos are available! ");
		System.out.println(s);
	}
}
