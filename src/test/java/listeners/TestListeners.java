package listeners;

import base.BaseClass;
import base.PlaywrightFactory;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import reports.ExtentManager;
import utilities.ScreenShotUtil;

public class TestListeners implements ITestListener {

    ExtentReports reports = ExtentManager.getInstance();
    ExtentTest extentTest;

    @Override
    public void onTestStart(ITestResult result) {
        extentTest = reports.createTest(result.getMethod().getMethodName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
      extentTest.pass("Passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {
      //  PlaywrightFactory baseClass = (PlaywrightFactory) result.getInstance();
        String screenShot = ScreenShotUtil.capture(PlaywrightFactory.getPage(),result.getName());
        extentTest.fail(result.getThrowable());
        extentTest.addScreenCaptureFromPath(screenShot);

    }

    @Override
    public void onTestSkipped(ITestResult result) {
        String screenShot = ScreenShotUtil.capture(PlaywrightFactory.getPage(),result.getName());
        extentTest.skip(result.getThrowable());
        extentTest.addScreenCaptureFromPath(screenShot);
    }

    @Override
    public void onFinish(ITestContext context) {
        reports.flush();
    }
}
