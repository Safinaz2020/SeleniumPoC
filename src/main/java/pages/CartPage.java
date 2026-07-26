package pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class CartPage extends BasePage{

    @FindBy(xpath="//button[normalize-space()='Continue shopping']")
    WebElement contButton;
    @FindBy(id="add-to-cart-button")
    WebElement addToCartBtn;

    public CartPage (WebDriver driver) {
        super(driver);
    }

    public void clickContShopping()
    {
        //Click Continue Shopping button when user is not logged in
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        contButton = wait.until(
                ExpectedConditions.elementToBeClickable(contButton));
        contButton.click();
    }

    public void addToCart ()
    {
        addToCartBtn.click();
    }
}
