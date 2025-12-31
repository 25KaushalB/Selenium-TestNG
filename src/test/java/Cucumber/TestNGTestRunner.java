package Cucumber;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/java/Cucumber", 
glue = "kaushalBhalgamiaAcademy.stepDefinitions", 
monochrome = true,
//tags="@ErrorValidation", //This Line will make only Execute Test with as @Error Validation Tags . Acts like Groups in TestNG
plugin = {"pretty","html:target/cucumber.html" })
public class TestNGTestRunner extends AbstractTestNGCucumberTests{

}
