package TestComponents;

import JavaResources.ExtentReporterNG;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import jdk.internal.org.jline.utils.Status;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.IOException;
import java.util.Arrays;

public class Listener extends BaseTest implements ITestListener
{
    ExtentTest test;
    String filePath;
    @Override
    public void onTestStart(ITestResult result) {
        ITestListener.super.onTestStart(result);
        ExtentReports report =ExtentReporterNG.sparkReport();
         test=report.createTest(result.getMethod().getMethodName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        ITestListener.super.onTestFailure(result);
        test.fail(result.getThrowable());
        //attachscreenshot method to this listener with testcasename
        try {
            filePath=getScreenshot(result.getMethod().getMethodName());
        } catch (IOException e) {
            e.printStackTrace();
        }
        test.addScreenCaptureFromPath(filePath,result.getMethod().getMethodName());

    }
}

