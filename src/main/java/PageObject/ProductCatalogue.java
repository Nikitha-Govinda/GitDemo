package PageObject;

import AbstractComponents.AbstractComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ProductCatalogue extends AbstractComponent {
    WebDriver driver;
    public ProductCatalogue(WebDriver driver){
        super(driver);
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }
    @FindBy(css=".mb-3")
    List<WebElement> products;

    @FindBy(css=".ng-animating")
            WebElement spinner;
    By productBy= By.cssSelector(".mb-3");
    By addToCart=By.cssSelector(".card-body button:last-of-type");
    By Toastmessage=By.cssSelector(".#toast-container");

    By invisibleElement=By.cssSelector("ng-animating");

    public List<WebElement> getProductList()
    {
      waitforElementToAppear(productBy);
      return  products;
    }

    public WebElement getProductName(String productName) {
        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".mb-3")));
        List<WebElement> Products = driver.findElements(By.cssSelector("productBy"));
        WebElement prod = Products.stream().
                filter(product -> product.findElement(By.cssSelector("b")).
                        getText().equals("ZARA COAT 3")).findFirst().orElse(null);

        return prod;
    }
    public void addProductToCart(String productName)
    {
        WebElement prod=getProductName(productName);
        prod.findElement(addToCart).click();
        waitforElementToAppear(Toastmessage);
        waitForElementToDisappear(spinner);
    }

}
