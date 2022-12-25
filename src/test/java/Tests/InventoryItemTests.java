package Tests;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.testng.Assert;
import org.testng.annotations.Test;

public class InventoryItemTests extends BaseTests {

    @Test(description = "Positive Inventory Item Test", groups = {"Smoke"})
    public void positiveInventoryItemTest() {
        String testItemName = "Sauce Labs Backpack";
        String expectedItemPrice = "$29.99";
        String expectedItemDescription = "carry.allTheThings() with the sleek, streamlined Sly Pack that melds " +
                "uncompromising style with unequaled laptop and tablet protection.";

        loginPage.setUsername("standard_user");
        loginPage.setPassword("secret_sauce");
        loginPage.clickLoginButton();

        productsPage.clickItemNameLink(testItemName);

        Assert.assertEquals(inventoryItemPage.getItemPrice(testItemName), expectedItemPrice);
        Assert.assertEquals(inventoryItemPage.getItemDecription(testItemName), expectedItemDescription);
        Assert.assertEquals(inventoryItemPage.getItemName(testItemName), testItemName);

        inventoryItemPage.clickAddToCartButton();
        inventoryItemPage.clickShoppingCartButton();

        Assert.assertEquals(shoppingCartPage.getItemPrice(testItemName), expectedItemPrice);
        Assert.assertEquals(shoppingCartPage.getItemDescription(testItemName), expectedItemDescription);

    }

}