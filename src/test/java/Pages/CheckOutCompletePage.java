package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckOutCompletePage extends BasePages {

    @FindBy(css = ".complete-header")
    private WebElement CHECKOUT_COMPLETE_MESSAGE;
    @FindBy(css = ".complete-text")
    private WebElement COMPLETE_TEXT;
    @FindBy (css = ".btn btn_primary btn_small")
    private WebElement BACK_HOME_BUTTON;


    @Override
    public boolean isPageOpened() {
        return CHECKOUT_COMPLETE_MESSAGE.isDisplayed();
    }

    public CheckOutCompletePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public boolean checkOutCompleteMessageIsPresent () {
        return CHECKOUT_COMPLETE_MESSAGE.isDisplayed();
        }

    public boolean completeTextIsPresent () {
        return COMPLETE_TEXT.isDisplayed();
        }


    public CheckOutCompletePage clickBackHomeMessage () {
        BACK_HOME_BUTTON.click();
        return this;

    }
}