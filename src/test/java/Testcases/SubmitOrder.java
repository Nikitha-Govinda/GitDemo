package Testcases;

import PageObject.OrderPage;
import PageObject.ProductCatalogue;
import TestComponents.BaseTest;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import static org.bouncycastle.cms.RecipientId.password;

public class SubmitOrder extends BaseTest {
    String productName = "ZARA COAT 3";
    @Test(@DataProvider="getData",groups={"Purchase"})

    public void submitOrder(String email,String password,String productName)
    {
        ProductCatalogue productCatalogue = landingPage.loginApplication(email,password);
        List<WebElement> products = productCatalogue.getProductList();
        productCatalogue.addProductToCart(productName);
//        CartPage cartPage = productCatalogue.goToCartPage();
//
//        Boolean match = cartPage.VerifyProductDisplay(input.get("product"));
//        Assert.assertTrue(match);
//        CheckoutPage checkoutPage = cartPage.goToCheckout();
//        checkoutPage.selectCountry("india");
//        ConfirmationPage confirmationPage = checkoutPage.submitOrder();
//        String confirmMessage = confirmationPage.getConfirmationMessage();
//        Assert.assertTrue(confirmMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));


    }

    @Test(dependsOnMethods= {"submitOrder"})
    public void OrderHistoryTest()
    {
        //"ZARA COAT 3";
        ProductCatalogue productCatalogue = landingPage.loginApplication("anshika@gmail.com", "Iamking@000");
        OrderPage ordersPage = productCatalogue.goToOrdersPage();
        Assert.assertTrue(ordersPage.VerifyOrderDisplay(productName));

    }
    @DataProvider
            public Object[][] getData()
    {
        return new Object[][] {{"test@gmail.com","test","productName"},{"ysad@gmail.com","test","test"}};
    }
}
