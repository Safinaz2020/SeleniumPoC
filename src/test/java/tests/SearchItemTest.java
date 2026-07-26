package tests;

import factory.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.HomePage;

import java.time.Duration;

public class SearchItem {

    private static String searchkey = "laptop";
    public static WebDriver driver;
    public static HomePage homepg;
    public static WebElement cont;

    public static void searchKeyword()  {
        driver = DriverFactory.getDriver();
        driver.get("https://www.amazon.com/dp/B01A6BPAN4");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement button = wait.until(
                ExpectedConditions.elementToBeClickable(By.xpath("//button[normalize-space()='Continue shopping']"))
        );
        button.click();


        driver.get("https://www.amazon.com/dp/B01A6BPAN4");

        WebElement addToCart = driver.findElement(By.id("add-to-cart-button"));
        addToCart.click();

      //  homepg = new HomePage(driver);
      //  homepg.searchItem("backbag");

       // driver.quit();
    }

    public static void main (String args[])
    {
        searchKeyword();
    }
}
