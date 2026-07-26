package tests;

import factory.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.CartPage;

public class CartTest {


    private static String productSKU = "B07DPGMPWD";
    private static String URL ="https://www.amazon.com/dp/";
    private static String confirmationURL = "https://www.amazon.com/cart";

    public WebDriver driver;
    private static CartPage cartPage;

    @BeforeMethod
    public void setUP()
    {
        driver = DriverFactory.getDriver();
    }

    @Test
    public void addProductToCart() {

        driver.get(URL);


        //skip "Continue Shopping" flow for unrecognized user
        cartPage = new CartPage(driver);
        // cartPage.clickContShopping();
        driver.get(URL+productSKU);

       //Log product page url with test SKU
        System.out.println("webdriver navigates to test SKU "+driver.getCurrentUrl());

        // add product to cart
        cartPage.addToCart();

        //assert product is in the cart
        Assert.assertTrue(driver.getCurrentUrl().contains(confirmationURL),"Failed: Incorrect navigation");

        System.out.println("Pass: Correct navigation after adding item to cart");
    }

    @AfterMethod
    public void tearDown() {

        DriverFactory.removeDriver();
    }

}
