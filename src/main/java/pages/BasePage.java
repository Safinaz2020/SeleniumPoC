package pages;

import factory.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BasePage {

    //private WebDriver driver = DriverFactory.getDriver();

        protected WebDriver driver;

        public BasePage(WebDriver driver){

            this.driver = driver;

            PageFactory.initElements(driver, this);

        }

    /** These also can go here:
     * Explicit waits
     * Screenshot methods
     * JavaScript executor
     * Scrolling
     * Common click methods
     * Logging
     */

    }



