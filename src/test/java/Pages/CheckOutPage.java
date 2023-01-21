package Pages;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
@Log4j2
public class CheckOutPage extends BasePages {

    @FindBy(css = "#first-name")
    private WebElement FIRST_NAME_INPUT;
    @FindBy(css = "#last-name")
    private WebElement LAST_NAME_INPUT;
    @FindBy(css = "#postal-code")
    private WebElement ZIP_CODE_INPUT;
    @FindBy(css = "#continue")
    private WebElement CONTINUE_BUTTON;
    @FindBy(css = "#cancel")
    private WebElement CANCEL_BUTTON;
    @FindBy(css = ".error-message-container")
    private WebElement ERROR_MASSAGE_CONTAINER;


    @Override
    public boolean isPageOpened() {
       return CONTINUE_BUTTON.isDisplayed();

    }

    public CheckOutPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public CheckOutPage setFirstNameInput(String firstName) {
        log.info("Setting First Name = '%s'", firstName);
        FIRST_NAME_INPUT.sendKeys(firstName);
        return this;
    }

    public CheckOutPage setLastNameInput(String lastName) {
        log.info("Setting Last Name = '%s'", lastName);
        LAST_NAME_INPUT.sendKeys(lastName);
        return this;
    }

    public CheckOutPage setZipCodeInput (String zipCode) {
        log.info("Setting Zip Code = '%s'", zipCode);
        ZIP_CODE_INPUT.sendKeys(zipCode);
        return this;
    }

    public CheckOutStepTwoPage clickContinueButton() {
        log.info("Clicking Continue Button");
        CONTINUE_BUTTON.click();
        return new CheckOutStepTwoPage(driver);

    }

    public ShoppingCartPage clickCancelButton() {
        log.info("Clicking Cancel Button");
        CANCEL_BUTTON.click();
        return new ShoppingCartPage(driver);
    }

    public boolean isErrorMessagePresent () {
        log.info("Error Message is Displayed");
        log.error("Error Message isn't Displayed");
        return ERROR_MASSAGE_CONTAINER.isDisplayed();
    }


}
