package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

public class CheckOutStepTwoPage extends BasePages {
    private final static By FINISH_BUTTON = By.cssSelector("#finish");
    private final static By ITEM_PRICE_TEXT = By.cssSelector(".inventory_item_price");
    private final static By ITEM_DESRRIPTION_DESC = By.cssSelector(".inventory_item_desc");
    private final static By SUMMARY_SUBTOTAL_LABEL = By.cssSelector(".summary_subtotal_label");
    private final static By SUMMARY_TAX_LABEL = By.cssSelector(".summary_tax_label");
    private final static By SUMMARY_TOTAL_LABEL = By.cssSelector(".summary_total_label");
    private final static By CANCEL_BUTTON = By.cssSelector("#cancel");


    public CheckOutStepTwoPage(WebDriver driver) {
        super(driver);
    }

    public boolean isFinishButtonPresent() {
        try {
            driver.findElement(FINISH_BUTTON);
        } catch (NoSuchElementException ex) {
            return false;
        }
        return true;
    }

    public void clickFinishButton() {
        driver.findElement(FINISH_BUTTON).click();
    }

    public static String getItemPrice(String testItemName) {
        return driver.findElement(ITEM_PRICE_TEXT).getText();
    }

    public static String getItemDescription(String testItemName) {
        return driver.findElement(ITEM_DESRRIPTION_DESC).getText();
    }

    public static String getItemSummarySubtotalLabel(String testItemName) {
        return driver.findElement(SUMMARY_SUBTOTAL_LABEL).getText();
    }

    public static String getItemSummaryTaxLabel (String testItemName) {
        return driver.findElement(SUMMARY_TAX_LABEL).getText();
    }

    public static String getItemSummaryTotalLabel (String testItemName) {
        return driver.findElement(SUMMARY_TOTAL_LABEL).getText();
    }

    public void clickCancelButton() {
        driver.findElement(CANCEL_BUTTON).click();
    }
}