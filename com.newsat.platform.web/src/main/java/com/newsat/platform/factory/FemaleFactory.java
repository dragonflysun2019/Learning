package com.newsat.platform.factory;

import java.io.IOException;

public class FemaleFactory extends HumanFactory {
	public Human createHuman() throws IOException {
		return new Female();
	} 
}
