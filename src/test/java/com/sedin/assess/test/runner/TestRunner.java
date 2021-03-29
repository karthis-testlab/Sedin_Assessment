package com.sedin.assess.test.runner;

import org.testng.annotations.Test;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		         features = "src/test/java/com/sedin/assess/features/SauceDemo.feature",
		         glue = "com.sedin.assess.steps",
		         monochrome = true,		        
		         plugin = {
		        		   "pretty",
		        		   "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
		        		   "rerun:src/test/resources/retry.txt"
		        		 }
		        )


public class TestRunner extends AbstractTestNGCucumberTests {
	
	@Test
	public void testRun() {
		
	}

}