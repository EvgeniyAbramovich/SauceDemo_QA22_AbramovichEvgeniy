package Pages;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
@Log4j2
public class ProductsPage extends BasePages {

    @FindBy(css = ".shopping_cart_link")
    private WebElement SHOPPING_CART_BUTTON;
    private final static String ITEM_CONTAINER_LOCATOR = "//div[@class='inventory_item_name' and text()='%s']/ancestor::div[@class='inventory_item']";
    private final static By ADD_TO_CART_BUTTON = By.xpath("//button[text()='Add to cart']");
    private final static By ITEM_PRICE_TEXT = By.cssSelector(".inventory_item_price");
    private final static By ITEM_DESRRIPTION_DESC = By.cssSelector(".inventory_item_desc");
    private final static By ITEM_NAME_LINK = By.cssSelector(".inventory_item_name");
    @FindBy(css = "#react-burger-menu-btn")
    private WebElement MENU_BUTTON;
    @FindBy(css = "#logout_sidebar_link")
    private WebElement LOGOUT_BUTTON;
    @FindBy(css = ".product_sort_container")
    private WebElement PRODUCT_SORT_CONTAINER;

    @Override
    public boolean isPageOpened() {
        return PRODUCT_SORT_CONTAINER.isDisplayed();
    }

    public ProductsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public boolean isShoppingCartButtonPresent() {
       try {
            SHOPPING_CART_BUTTON.isDisplayed();
        } catch (NoSuchElementException ex) {
            return false;
        }
        return true;
    }

    public ShoppingCartPage clickShoppingCartButton() {
        log.info("Clicking Shopping Cart Button");
        SHOPPING_CART_BUTTON.click();
        return new ShoppingCartPage(driver);
    }

    public void clickAddToCartButton(String itemName) {
        log.info("Clicking AddToCart Button by Item Name = '%s'",itemName);
        driver.findElement(getItemContainerByName(itemName)).findElement(ADD_TO_CART_BUTTON).click();
    }

    public void clickItemNameLink(String itemName) {
        log.info("Clicking ItemName Link by Item Name = '%s'",itemName);
        driver.findElement(getItemContainerByName(itemName)).findElement(ITEM_NAME_LINK).click();
    }


    public String getItemPrice(String itemName) {
        log.info("Getting Item Price = '%s'",itemName);
        return driver.findElement(getItemContainerByName(itemName)).findElement(ITEM_PRICE_TEXT).getText();
    }

    public String getItemName(String itemName) {
        log.info("Getting Item Name = '%s'",itemName);
        return driver.findElement(getItemContainerByName(itemName)).findElement(ITEM_NAME_LINK).getText();
    }

    public String getItemDescription(String itemName) {
        log.info("Getting Item Description = '%s'",itemName);
        return driver.findElement(getItemContainerByName(itemName)).findElement(ITEM_DESRRIPTION_DESC).getText();
    }

    public void openItem(String itemName) {
        log.info("Clicking ItemName Link by Item Name = '%s'",itemName);
        driver.findElement(getItemContainerByName(itemName)).findElement(ITEM_NAME_LINK).click();
    }

    private By getItemContainerByName(String itemName) {
        log.debug("Getting Item Container = '%s'",itemName);
        return By.xpath(String.format(ITEM_CONTAINER_LOCATOR, itemName));
    }

    public ProductsPage clickMenuButton() {
        log.info("Clicking Menu Button");
        MENU_BUTTON.click();
        return this;
    }

    public LoginPage clickLogoutButton() {
        log.info("Clicking LogOut Button");
        LOGOUT_BUTTON.click();
        return new LoginPage(driver);
    }

    public void selectSortingOrderOption(String optionName) {
        log.info("Selecting Sorting Order Option {}",optionName);
        Select select = new Select((WebElement) PRODUCT_SORT_CONTAINER);
        select.selectByVisibleText(optionName);

    }
}