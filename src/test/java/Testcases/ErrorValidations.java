package Testcases;

import PageObject.LandingPage;
import TestComponents.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class ErrorValidations extends BaseTest {
    ;
    WebDriver driver;
//we are verifiying incorrect login and password using this method..error validation
    @Test
    public  void submitOrder(){
        String productName="ZARA COAT 3";
        LandingPage landingPage=new LandingPage(driver);

    }
}
