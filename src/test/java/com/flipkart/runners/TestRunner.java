package com.flipkart.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features = "src/test/resources/features/Flipkart.feature", // Where is the cucumber file? (gherkin)
		glue = "com.flipkart.steps", // Where is the Java code?
		plugin = {"pretty", 
				"html:target/cucumber-reports.html"},
	    monochrome = true
		)

public class TestRunner extends AbstractTestNGCucumberTests {

}
