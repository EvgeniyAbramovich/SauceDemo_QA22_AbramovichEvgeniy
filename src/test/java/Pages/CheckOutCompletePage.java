package Pages;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
@Log4j2
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
        log.info("Complete Message is Displayed");
        log.error("Complete Message isn't Displayed");
        return CHECKOUT_COMPLETE_MESSAGE.isDisplayed();
        }

    public boolean completeTextIsPresent () {
        log.info("Complete Text is Displayed");
        log.error("Complete Text isn't Displayed");
        return COMPLETE_TEXT.isDisplayed();
        }


    public CheckOutCompletePage clickBackHomeMessage () {
        log.info("Clicking BackHome Button");
        BACK_HOME_BUTTON.click();
        return this;

    }
}