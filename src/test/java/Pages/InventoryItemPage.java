package Pages;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
@Log4j2
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
        log.info("Clicking AddToCart Button");
        ADD_TO_CART_BUTTON.click();
        return this;
    }

    public ProductsPage clickBackToProductsButton() {
        log.info("Clicking BackToProduct Button");
        BACK_TO_PRODUCTS_BUTTON.click();
        return new ProductsPage(driver);
    }

    public static String getItemName(String testItemName) {
        log.info("Getting Item Name = {}",testItemName);
        return ITEM_NAME_TEXT.getText();
    }

    public static String getItemDescription(String testItemName) {
        log.info("Getting Item Description = {}",testItemName);
        return ITEM_DESCRIPTION_TEXT.getText();
    }

    public static String getItemPrice(String testItemName) {
        log.info("Getting Item Price = {}",testItemName);
        return ITEM_PRICE_TEXT.getText();
     }

     public ShoppingCartPage clickShoppingCartButton() {
        log.info("Clicking Shopping Cart Button");
        SHOPPING_CART_BUTTON.click();
        return new ShoppingCartPage(driver);
     }
}
