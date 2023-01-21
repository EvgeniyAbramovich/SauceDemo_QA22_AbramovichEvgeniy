package Pages;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
@Log4j2
public class CheckOutStepTwoPage extends BasePages {

    @FindBy(css = "#finish")
    private WebElement FINISH_BUTTON;
    @FindBy(css = ".inventory_item_price")
    private static WebElement ITEM_PRICE_TEXT;
    @FindBy(css = ".inventory_item_desc")
    private static WebElement ITEM_DESCRIPTION_DESC;
    @FindBy(css = ".summary_subtotal_label")
    private static WebElement SUMMARY_SUBTOTAL_LABEL;
    @FindBy(css = ".summary_tax_label")
    private static WebElement SUMMARY_TAX_LABEL;
    @FindBy(css = ".summary_total_label")
    private static WebElement SUMMARY_TOTAL_LABEL;
    @FindBy(css = "#cancel")
    private WebElement CANCEL_BUTTON;


    @Override
    public boolean isPageOpened() {
        return FINISH_BUTTON.isDisplayed();
    }

    public CheckOutStepTwoPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public boolean isFinishButtonPresent() {
        log.info("Finish Button is Present");
        log.error("Finish Button isn't Present");
        try {
            FINISH_BUTTON.isDisplayed();
        } catch (NoSuchElementException ex) {
            return false;
        }
        return true;
    }

    public CheckOutCompletePage clickFinishButton() {
        log.info("Clicking Finish Button");
        FINISH_BUTTON.click();
        return new CheckOutCompletePage(driver);
    }

    public static String getItemPrice(String testItemName) {
        log.info("Getting Item Price = '%s'",testItemName);
        return ITEM_PRICE_TEXT.getText();
    }

    public static String getItemDescription(String testItemName) {
        log.info("Getting Item Price = '%s'",testItemName);
        return ITEM_DESCRIPTION_DESC.getText();
    }

    public static String getItemSummarySubtotalLabel(String testItemName) {
        log.info("Getting Item Summary Subtotal Label = '%s'",testItemName);
        return SUMMARY_SUBTOTAL_LABEL.getText();
    }

    public static String getItemSummaryTaxLabel (String testItemName) {
        log.info("Getting Item Summary Tax Label = '%s'",testItemName);
        return SUMMARY_TAX_LABEL.getText();
    }

    public static String getItemSummaryTotalLabel (String testItemName) {
        log.info("Getting Item Summary Total Label = '%s'",testItemName);
        return SUMMARY_TOTAL_LABEL.getText();
    }

    public ProductsPage clickCancelButton() {
        log.info("Clicking Cancel Button");
        CANCEL_BUTTON.click();
        return new ProductsPage(driver);
    }
}