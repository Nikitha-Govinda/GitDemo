package JavaResources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporterNG {


    public static ExtentReports sparkReport(){
        String path= System.getProperty("user.dir")+"\\reports\\index.html";
        ExtentSparkReporter SparkObj= new ExtentSparkReporter(path);
        SparkObj.config().setDocumentTitle("This is my first report");
        SparkObj.config().setReportName("Test Rsults");
        //attached the spark report to the report
       ExtentReports extent =new ExtentReports();
        extent.attachReporter(SparkObj);
        ExtentTest test= extent.createTest(path);
        test.pass("this is pass test case");
        return extent;

    }

}
