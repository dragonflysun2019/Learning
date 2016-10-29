package com.newsat.platform.factory;

import java.io.IOException;

public class Goddess {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		HumanFactory hf = new ManFactory();
		Human h = hf.createHuman();
		h.Eat();
		h.Sleep();
		h.Beat();
		
		HumanFactory hf2 = new FemaleFactory();
		Human h2 = hf2.createHuman();
		h2.Eat();
		h2.Sleep();
		h2.Beat();
	}

}
