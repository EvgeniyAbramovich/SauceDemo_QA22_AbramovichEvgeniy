package Tests;

import Pages.ShoppingCartPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class ShoppingCartTest extends BaseTests {

    @Test(description = "Positive Shopping Cart Test", groups = {"Smoke"})
    public void positiveShoppingCartTest() {
        String testItemName = "Sauce Labs Backpack";
        String expectedItemPrice = "$29.99";
        String expectedItemDescription = "carry.allTheThings() with the sleek, streamlined Sly Pack that melds " +
                "uncompromising style with unequaled laptop and tablet protection.";

        loginPage.setUsername("standard_user").setPassword("secret_sauce").clickLoginButton().isPageOpened();

        productsPage.clickAddToCartButton(testItemName);
        productsPage.clickShoppingCartButton().isPageOpened();

        Assert.assertEquals(shoppingCartPage.getItemPrice(testItemName), expectedItemPrice);
        Assert.assertEquals(shoppingCartPage.getItemDescription(testItemName), expectedItemDescription);

    }

    @Test(description = "Remove Test", groups = {"Smoke"})
    public void removeTest() {
        String testItemName = "Sauce Labs Backpack";
        String expectedItemPrice = "$29.99";
        String expectedItemDescription = "carry.allTheThings() with the sleek, streamlined Sly Pack that melds " +
                "uncompromising style with unequaled laptop and tablet protection.";

        loginPage.setUsername("standard_user").setPassword("secret_sauce").clickLoginButton().isPageOpened();

        productsPage.clickAddToCartButton(testItemName);
        productsPage.clickShoppingCartButton();

        shoppingCartPage.clickRemoveButton();
        Assert.assertFalse(shoppingCartPage.addedItemIsPresent());

    }

}
