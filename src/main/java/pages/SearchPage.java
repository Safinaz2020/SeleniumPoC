package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchPage extends BasePage {

    public SearchPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id="twotabsearchtextbox")
    WebElement searchBox;

    @FindBy(id="nav-search-submit-button")
    WebElement searchButton;

    public void searchItem (String item)
    {
        searchBox.sendKeys(item);
        searchButton.click();
    }
}
