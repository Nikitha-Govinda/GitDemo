package RahulShettyStepDefinition;

import PageObject.LandingPage;
import TestComponents.BaseTest;
import io.cucumber.java.en.Given;

import java.io.IOException;

public class StepDefinition extends BaseTest {
    public LandingPage landingPage;
    @Given("I have landed into ecommerce page")
    public  void I_landed_into_on_ecommerce_page() throws IOException {
        launchApplication();

    }
    @Given("^Logged in with username(.+) and password(.+)$")
    public void logged_in_username_and_password(String username,String password){

    }

}
