package org.Testrunner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src\\test\\resources\\Features", glue = "org.stepdef", monochrome = true, dryRun = false

)
public class TestRunner {

	public void findigELement() {
		System.out.println("Find Element by using Locator");

	}

	public void xpath() {
		System.out.println("Syntax of xpath is : //tagname[@attributename='attribbutevalue']");

	}
}
