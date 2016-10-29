package com.newsat.platform.factory;

import java.io.IOException;

public class ManFactory extends HumanFactory{
	public Human createHuman()  throws IOException{
		return new Man();
	}
}
