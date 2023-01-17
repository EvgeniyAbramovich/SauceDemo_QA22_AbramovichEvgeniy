package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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
        FIRST_NAME_INPUT.sendKeys(firstName);
        return this;
    }

    public CheckOutPage setLastNameInput(String lastName) {
        LAST_NAME_INPUT.sendKeys(lastName);
        return this;
    }

    public CheckOutPage setZipCodeInput (String zipCode) {
        ZIP_CODE_INPUT.sendKeys(zipCode);
        return this;
    }

    public CheckOutStepTwoPage clickContinueButton() {
        CONTINUE_BUTTON.click();
        return new CheckOutStepTwoPage(driver);

    }

    public ShoppingCartPage clickCancelButton() {
        CANCEL_BUTTON.click();
        return new ShoppingCartPage(driver);
    }

    public boolean isErrorMessagePresent () {
        return ERROR_MASSAGE_CONTAINER.isDisplayed();
    }


}
