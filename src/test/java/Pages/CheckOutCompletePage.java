package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckOutCompletePage extends BasePages {
    private final static By CHECKOUT_COMPLETE_MESSAGE = By.cssSelector(".complete-header");
    private final static By COMPLETE_TEXT = By.cssSelector(".complete-text");
    private final static By BACK_HOME_BUTTON = By.cssSelector(".btn btn_primary btn_small");


    public CheckOutCompletePage(WebDriver driver) {
        super(driver);
    }

    public boolean checkOutCompleteMessageIsPresent () {
        return driver.findElement(CHECKOUT_COMPLETE_MESSAGE).isDisplayed();
        }

    public boolean completeTextIsPresent () {
        return driver.findElement(COMPLETE_TEXT).isDisplayed();
        }


    public void clickBackHomeMessage () {
        driver.findElement(BACK_HOME_BUTTON).click();
    }
}