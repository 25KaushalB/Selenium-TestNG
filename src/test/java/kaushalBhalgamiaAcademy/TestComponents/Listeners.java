package kaushalBhalgamiaAcademy.TestComponents;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import kaushalBhalgamiaAcademy.resources.ExtentReportsNG;

public class Listeners extends BaseTest implements ITestListener {
	ExtentTest test;
	ExtentReports extent = ExtentReportsNG.getReportObject();
	ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>(); // Thread Safe.
	@Override
	public void onTestStart(ITestResult result) {
		// TO DO Auto-generated method stub
		test = extent.createTest(result.getMethod().getMethodName());
		extentTest.set(test); // This will Assign Unique Thread It to Each Test While Executing.
		
	}
 
	@Override
	public void onTestSuccess(ITestResult result) {
		// TO DO Auto-generated method stub

		extentTest.get().log(Status.PASS, "Test Passed");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TO DO Auto-generated method stub

		extentTest.get().fail(result.getThrowable());
		try {
			driver = (WebDriver) result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		// get Screenshot. and Attachit to Report.
		String FilePath = null;
		try {
			FilePath = getScreenshot(result.getMethod().getMethodName(), driver);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		extentTest.get().addScreenCaptureFromPath(FilePath, result.getMethod().getMethodName());
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TO DO Auto-generated method stub
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TO DO Auto-generated method stub
	}

	@Override
	public void onStart(ITestContext result) {
		// TO DO Auto-generated method stub
	}

	@Override
	public void onFinish(ITestContext result) {
		// TO DO Auto-generated method stub
		extent.flush();
	}
	

}
