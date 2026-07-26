package tests;

import factory.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.SearchPage;

import java.util.List;


public class SearchItemTest {

    private static String searchkey = "backpack";
    private static String URL = "https://www.amazon.com/";

    public WebDriver driver;
    public SearchPage homepg;
    public boolean matchFound = false;

    @BeforeMethod
    public void setUP()
    {
        driver = DriverFactory.getDriver();
    }

    @Test
    public void searchKeyword()  {

        driver.get(URL);
        homepg = new SearchPage(driver);
        homepg.searchItem(searchkey);

        // Combined selector targeting returned product titles across grid and list views
        String titleSelector = "h2 a span.a-text-normal, .a-size-medium.a-text-normal, .a-size-base-plus.a-text-normal";

        // 1. Fetch all matching title elements
        List<WebElement> productTitles = driver.findElements(By.cssSelector(titleSelector));

        // 2. Loop results and check for the keyword
        for (WebElement title : productTitles) {
            String titleText = title.getText().toLowerCase();
            if (titleText.contains(searchkey)) {
                matchFound = true;
                System.out.println(titleText);
                break; // Exit loop early once a match is confirmed
            }
        }

        // 3. Assert returned results contain the correct searchkey
        Assert.assertTrue(matchFound, "Assertion Failed: The keyword '" + searchkey + "' was not found in any product titles.");
        System.out.println("Success! Verified 'laptop' appears in the search results.");

    }

    @AfterMethod
    public void tearDown() {

        DriverFactory.removeDriver();

    }

}
