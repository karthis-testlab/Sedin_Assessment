package com.sedin.assess.test.assertion;

import org.testng.Assert;

import com.sedin.assess.utils.Logs;

public class TestAssertions {
	
	public static void verifyTheExactText(String eValue, String aValue) {
		if(eValue.equals(aValue)) {			
			Logs.consoleLog("PASS", "Expeted value <"+eValue+"> matches with the actual one <"+aValue+">");
		} else {
			Logs.consoleLog("FAIL", "Expeted value <"+eValue+"> not matched with the actual one <"+aValue+">");
		}
	}
	
	public static void assertTheExactText(String eValue, String aValue) {
		try {
			Assert.assertEquals(eValue, aValue);
			Logs.consoleLog("PASS", "Expeted value <"+eValue+"> matches with the actual one <"+aValue+">");
		} catch (AssertionError e) {
			Logs.consoleLog("FATAL", "Expeted value <"+eValue+"> not matched with the actual one <"+aValue+"> "+e.toString());
		}
	}
	
	public static void verifyTheContainsText(String eValue, String aValue) {		
		if(eValue.contains(aValue)) {			
			Logs.consoleLog("PASS", "Expeted value <"+eValue+"> matches with the actual one <"+aValue+">");
		} else {
			Logs.consoleLog("FAIL", "Expeted value <"+eValue+"> not matched with the actual one <"+aValue+">");
		}
	}
	
	public static void assertTheContainsText(String eValue, String aValue) {
		boolean isContains = (eValue.contains(aValue)) ? true : false;
		try {
			Assert.assertEquals(true, isContains);
			Logs.consoleLog("PASS", "Expeted value <"+eValue+"> matches with the actual one <"+aValue+">");
		} catch (AssertionError e) {
			Logs.consoleLog("FATAL", "Expeted value <"+eValue+"> not matched with the actual one <"+aValue+"> "+e.toString());
		}
	}
	
	public static void assertBoolean(boolean aValue) {		
		try {
			Assert.assertEquals(true, aValue);
			Logs.consoleLog("PASS", "Expeted value <"+true+"> matches with the actual one <"+aValue+">");
		} catch (AssertionError e) {
			Logs.consoleLog("FATAL", "Expeted value <"+true+"> not matched with the actual one <"+aValue+"> "+e.toString());
		}
	}

}