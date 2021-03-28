package com.sedin.assess.sauce.services;

import java.util.LinkedHashMap;
import java.util.Map;

import com.sedin.assess.selenium.api.base.SeleniumBase;
import com.sedin.assess.utils.ReadProperties;

public class ProjectSpecificService extends SeleniumBase {
	
	protected static String productName;
	protected static String price;	
	protected final static String aut = ReadProperties.readConfig("sedin.assessment.aut.url");
	protected static Map<String, String> map = new LinkedHashMap<String, String>();

}