package Pages;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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
    public BasePages isPageOpened() {
        FINISH_BUTTON.isDisplayed();
        return this;
    }

    public CheckOutStepTwoPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public boolean isFinishButtonPresent() {
        try {
            FINISH_BUTTON.isDisplayed();
        } catch (NoSuchElementException ex) {
            return false;
        }
        return true;
    }

    public CheckOutCompletePage clickFinishButton() {
        FINISH_BUTTON.click();
        return new CheckOutCompletePage(driver);
    }

    public static String getItemPrice(String testItemName) {
        return ITEM_PRICE_TEXT.getText();
    }

    public static String getItemDescription(String testItemName) {
        return ITEM_DESCRIPTION_DESC.getText();
    }

    public static String getItemSummarySubtotalLabel(String testItemName) {
        return SUMMARY_SUBTOTAL_LABEL.getText();
    }

    public static String getItemSummaryTaxLabel (String testItemName) {
        return SUMMARY_TAX_LABEL.getText();
    }

    public static String getItemSummaryTotalLabel (String testItemName) {
        return SUMMARY_TOTAL_LABEL.getText();
    }

    public ProductsPage clickCancelButton() {
        CANCEL_BUTTON.click();
        return new ProductsPage(driver);
    }
}