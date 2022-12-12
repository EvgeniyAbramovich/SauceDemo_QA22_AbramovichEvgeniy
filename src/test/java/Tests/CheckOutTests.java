package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckOutTests extends BaseTests {

    @Test
    public void positiveCheckoutTest() {
        String testItemName = "Sauce Labs Backpack";
        String expectedItemPrice = "$29.99";
        String expectedItemDescription = "carry.allTheThings() with the sleek, streamlined Sly Pack that melds uncompromising style with unequaled laptop and tablet protection.";

        loginPage.setUsername("standard_user");
        loginPage.setPassword("secret_sauce");
        loginPage.clickLoginButton();

        productsPage.clickAddToCartButton(testItemName);
        productsPage.clickShoppingCartButton();

        shoppingCartPage.clickCheckOutButton();

        checkOutPage.setFirstNameInput("Evgeniy");
        checkOutPage.setLastNameInput("Abramovich");
        checkOutPage.setZipCodeInput("12345");
        checkOutPage.clickContinueButton();

        Assert.assertTrue(checkOutStepTwoPage.isFinishButtonPresent());
        Assert.assertEquals(checkOutStepTwoPage.getItemPrice(testItemName), expectedItemPrice);
        Assert.assertEquals(checkOutStepTwoPage.getItemDescription(testItemName), expectedItemDescription);

        checkOutStepTwoPage.clickFinishButton();

        Assert.assertTrue(checkOutCompletePage.checkOutCompleteMessageIsPresent());
        Assert.assertTrue(checkOutCompletePage.completeTextIsPresent());

    }
}
