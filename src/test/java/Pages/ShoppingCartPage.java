package Pages;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShoppingCartPage extends BasePages {

    @FindBy(xpath = "//button[contains(@id,'remove')]")
    private WebElement REMOVE_BUTTON;
    @FindBy(css = "#checkout")
    private WebElement CHECKOUT_BUTTON;
    @FindBy(css = "#continue-shopping")
    private WebElement CONTINUE_SHOPPING_BUTTON;
    @FindBy(css = ".inventory_item_price")
    private static WebElement ITEM_PRICE_TEXT;
    @FindBy(css = ".inventory_item_desc")
    private static WebElement ITEM_DESCRIPTION_DESC;
    @FindBy(css = ".inventory_item_name")
    private WebElement ITEM_NAME_LINK;
    @FindBy(css = ".inventory_item_name")
    private WebElement ITEM_NAME_TEXT;


    @Override
    public boolean isPageOpened() {
       return CHECKOUT_BUTTON.isDisplayed();
    }

    public ShoppingCartPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public ShoppingCartPage clickRemoveButton() {
        REMOVE_BUTTON.click();
        return this;
    }

    public CheckOutPage clickCheckOutButton() {
        CHECKOUT_BUTTON.click();
        return new CheckOutPage(driver);
    }

    public ProductsPage clickContinueShoppingButton() {
        CONTINUE_SHOPPING_BUTTON.click();
        return new ProductsPage(driver);
    }

    public static String getItemPrice(String testItemName) {
        return ITEM_PRICE_TEXT.getText();
    }

    public static String getItemDescription(String testItemName) {
        return ITEM_DESCRIPTION_DESC.getText();
    }

    public InventoryItemPage openItem() {
        ITEM_NAME_LINK.click();
        return new InventoryItemPage(driver);
    }

    public String getItemName() {
        return ITEM_NAME_TEXT.getText();
    }

    public boolean addedItemIsPresent () {
        try {
            ITEM_NAME_TEXT.isDisplayed();
        }
        catch (NoSuchElementException ex) {
            return false;
        }
        return true;
    }


}

