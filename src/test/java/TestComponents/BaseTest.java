package TestComponents;

import PageObject.LandingPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class BaseTest  {
  WebDriver driver;
  public LandingPage landingPage;
    public WebDriver IntiliazeDriver() throws IOException {
        Properties prop = new Properties();
        FileInputStream fs = new FileInputStream(System.getProperty("user.dir")
                + "src\\main\\java\\JavaResources\\GlobalData.properties");
        prop.load(fs);
        String browserName = prop.getProperty("browser");

        if (browserName.equalsIgnoreCase("chrome")) {
            //System.setProperty("", "");

            ChromeOptions options=new ChromeOptions();
            WebDriverManager.chromedriver().setup();
            options.addArguments("headless");
            driver = new ChromeDriver(options);
        } else if (browserName.equalsIgnoreCase("firefox")) {
            //System.setProperty("", "");
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        } else if (browserName.equalsIgnoreCase("edge")) {
           // System.setProperty("", "");
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));
        driver.manage().window().maximize();
        return driver;
    }
        @BeforeTest
        public void launchApplication() throws IOException {
            driver = IntiliazeDriver();
            landingPage = new LandingPage(driver);
            landingPage.goTo();
        }
    public  String getScreenshot(String testCaseName) throws IOException {
        {
            TakesScreenshot screenshotObj = (TakesScreenshot) driver;
            File source = screenshotObj.getScreenshotAs(OutputType.FILE);
            File target = new File(new File("user.dir") + "//reports" + testCaseName + ".png");
            FileUtils.copyFile(source, target);
            return System.getProperty("user.dir") + "reports" + testCaseName + ".png";
        }

    }
        @AfterTest
        public void tearDown(){
        driver.close();
        }
    }




