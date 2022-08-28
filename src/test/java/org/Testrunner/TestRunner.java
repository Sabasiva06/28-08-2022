package org.Testrunner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src\\test\\resources\\Features", glue = "org.stepdef", monochrome = true, dryRun = false

)
public class TestRunner {

	public void report() {
		System.out.println("Generate Report by JSON");

	}

	public void json() {
		System.out.println("Generate report by converting Json into html");
	}

}
