package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class InventoryItemPage extends BasePages{

    private final static By ADD_TO_CART_BUTTON = By.xpath("//button[text()='Add to cart']");
    private final static By BACK_TO_PRODUCTS_BUTTON = By.id("back-to-products");
    private final static By ITEM_NAME_TEXT = By.cssSelector(".inventory_details_name");
    private final static By ITEM_DESCRIPTION_TEXT = By.cssSelector(".inventory_details_desc");
    private final static By ITEM_PRICE_TEXT = By.cssSelector(".inventory_details_price");

    private final static By SHOPPING_CART_BUTTON = By.cssSelector(".shopping_cart_link");


    public InventoryItemPage(WebDriver driver) {
        super(driver);
    }

    public void clickAddToCartButton() {
        driver.findElement(ADD_TO_CART_BUTTON).click();
    }

    public void clickBackToProductsButton() {
        driver.findElement(BACK_TO_PRODUCTS_BUTTON);
    }

    public static String getItemName(String testItemName) {
        return driver.findElement(ITEM_NAME_TEXT).getText();
    }

    public static String getItemDecription(String testItemName) {
        return driver.findElement(ITEM_DESCRIPTION_TEXT).getText();
    }

    public static String getItemPrice(String testItemName) {
        return driver.findElement(ITEM_PRICE_TEXT).getText();
     }

     public void clickShoppingCartButton() {
        driver.findElement(SHOPPING_CART_BUTTON).click();
     }
}
