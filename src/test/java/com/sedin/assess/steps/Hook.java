package com.sedin.assess.steps;

import com.sedin.assess.sauce.services.ProjectSpecificService;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hook extends ProjectSpecificService {
	
	@Before
	public void beforeHook() {
		launchBrowser();
	}
	
	@After(order = 1)
	public void snap(Scenario scenario) {
		if(scenario.isFailed()) {			
			scenario.attach(takeSnap(), "image/png", "Attached Screenshot for failure reason");
		}
	}
	
	@After(order = 0)
	public void afterHook() {
		quitBrowser();
	}

}