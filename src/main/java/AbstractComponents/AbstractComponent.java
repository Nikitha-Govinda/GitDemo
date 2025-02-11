package AbstractComponents;

import PageObject.OrderPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AbstractComponent {

    WebDriver driver;
    public AbstractComponent(WebDriver driver) {
        this.driver=driver;
    }
    @FindBy(css = "[routerlink*='cart']")
    WebElement cartHeader;

    @FindBy(css = "[routerlink*='myorders']")
    WebElement orderHeader;

    public void waitforElementToAppear(By findBy) {
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(500));
        wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
    }
    public OrderPage goToOrdersPage() {
        orderHeader.click();
        OrderPage orderPage = new OrderPage(driver);
        return orderPage;
    }
    public void waitForElementToDisappear(WebElement ele){
        WebDriverWait wait=new WebDriverWait(driver,Duration.ofMillis(500));
        wait.until(ExpectedConditions.invisibilityOf(ele));

    }
}
