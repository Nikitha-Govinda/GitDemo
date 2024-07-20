package PageObject;

import com.google.common.annotations.VisibleForTesting;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import AbstractComponents.AbstractComponent;

public class LandingPage extends AbstractComponent {

    WebDriver driver;
    public LandingPage(WebDriver driver){
        super(driver);
        this.driver=driver;
        PageFactory.initElements(driver,this);

    }
@FindBy(id="userEmail")
    WebElement useremail;

    @FindBy(id="userPassword")
    WebElement userpasword1;

    @FindBy(id="login")
    WebElement login;
    public ProductCatalogue loginApplication(String email, String userpassword){
        useremail.sendKeys("trulynikki.22@gmail.com");
        userpasword1.sendKeys("Test@123");
        login.click();
        ProductCatalogue productCatalogue=new ProductCatalogue(driver);
        return productCatalogue;
    }
    public void goTo(){
        driver.get("https://rahulshettyacademy.com/client/");
    }
}
