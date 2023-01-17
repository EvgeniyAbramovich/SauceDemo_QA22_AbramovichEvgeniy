package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class InventoryItemPage extends BasePages{

    @FindBy(xpath = "//button[text()='Add to cart']")
    private WebElement ADD_TO_CART_BUTTON;
    @FindBy(id = "back-to-products")
    private WebElement BACK_TO_PRODUCTS_BUTTON;
    @FindBy(css = ".inventory_details_name")
    private static WebElement ITEM_NAME_TEXT;
    @FindBy(css = ".inventory_details_desc")
    private static WebElement ITEM_DESCRIPTION_TEXT;
    @FindBy(css = ".inventory_details_price")
    private static WebElement ITEM_PRICE_TEXT;
    @FindBy(css = ".shopping_cart_link")
    private WebElement SHOPPING_CART_BUTTON;


    @Override
    public boolean isPageOpened() {
       return ADD_TO_CART_BUTTON.isDisplayed();
    }

    public InventoryItemPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public InventoryItemPage clickAddToCartButton() {
        ADD_TO_CART_BUTTON.click();
        return this;
    }

    public ProductsPage clickBackToProductsButton() {
        BACK_TO_PRODUCTS_BUTTON.click();
        return new ProductsPage(driver);
    }

    public static String getItemName(String testItemName) {
        return ITEM_NAME_TEXT.getText();
    }

    public static String getItemDecription(String testItemName) {
        return ITEM_DESCRIPTION_TEXT.getText();
    }

    public static String getItemPrice(String testItemName) {
        return ITEM_PRICE_TEXT.getText();
     }

     public ShoppingCartPage clickShoppingCartButton() {
        SHOPPING_CART_BUTTON.click();
        return new ShoppingCartPage(driver);
     }
}
