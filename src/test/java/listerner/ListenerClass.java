package listerner;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

import Adactin_main.Base_class;
import extentReport.ExtentManager;

public class ListenerClass extends ExtentManager implements ITestListener {

	public void onTestStart(ITestResult result) {
		test = extent.createTest(result.getName());

	}

	public void onTestSuccess(ITestResult result) {
		if (result.getStatus() == ITestResult.SUCCESS) {
			test.log(Status.PASS, "Pass Test case is: " + result.getName());

			String pathString = Base_class.screenShot(Base_class.driver, result.getName());

			try {
				test.addScreenCaptureFromPath(pathString);
			} catch (IOException e) {

				e.printStackTrace();
			}
		}
	}

	public void onTestFailure(ITestResult result) {
		if (result.getStatus() == ITestResult.FAILURE) {

			test.log(Status.FAIL, "Fail Test case is :" + result.getName());
			String pathString = Base_class.screenShot(Base_class.driver, result.getName());
			try {
				test.addScreenCaptureFromPath(pathString);
			} catch (IOException e) {

				e.printStackTrace();
			}
		}
	}

	public void onTestSkipped(ITestResult result) {
		if (result.getStatus() == ITestResult.SKIP) {
			test.log(Status.SKIP, "Skipped Test case is: " + result.getName());

		}

	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub

	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub

	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
	}
}