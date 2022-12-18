package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckOutPage extends BasePages {
    private final static By FIRST_NAME_INPUT = By.cssSelector("#first-name");
    private final static By LAST_NAME_INPUT = By.cssSelector("#last-name");
    private final static By ZIP_CODE_INPUT = By.cssSelector("#postal-code");
    private final static By CONTINUE_BUTTON = By.cssSelector("#continue");
    private final static By CANCEL_BUTTON = By.cssSelector("#cancel");
    private By ERROR_MASSAGE_CONTAINER = By.cssSelector(".error-message-container");


    public CheckOutPage(WebDriver driver) {
        super(driver);
    }

    public void setFirstNameInput(String firstName) {
        driver.findElement(FIRST_NAME_INPUT).sendKeys(firstName);
    }

    public void setLastNameInput(String lastName) {
        driver.findElement(LAST_NAME_INPUT).sendKeys(lastName);
    }

    public void setZipCodeInput (String zipCode) {
        driver.findElement(ZIP_CODE_INPUT).sendKeys(zipCode);
    }

    public void clickContinueButton() {
        driver.findElement(CONTINUE_BUTTON).click();
    }

    public void clickCancelButton() {
        driver.findElement(CANCEL_BUTTON).click();
    }

    public boolean isErrorMessagePresent () {
        return driver.findElement(ERROR_MASSAGE_CONTAINER).isDisplayed();
    }


}
