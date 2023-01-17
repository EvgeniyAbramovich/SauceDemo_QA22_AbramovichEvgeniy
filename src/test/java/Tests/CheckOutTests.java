package Tests;

import io.qameta.allure.Attachment;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

public class CheckOutTests extends BaseTests {

    @Test(description = "Positive Checkout Test", groups = {"Smoke"})
    public void positiveCheckoutTest() {
        String testItemName = "Sauce Labs Backpack";
        String expectedItemPrice = "$29.99";
        String expectedItemDescription = "carry.allTheThings() with the sleek, streamlined Sly Pack that melds " +
                "uncompromising style with unequaled laptop and tablet protection.";

        loginPage.setUsername("standard_user").setPassword("secret_sauce").clickLoginButton().
                clickAddToCartButton(testItemName);
        productsPage.clickShoppingCartButton().clickCheckOutButton().setFirstNameInput("Evgeniy").
                setLastNameInput("Abramovich").setZipCodeInput("12345").clickContinueButton().isPageOpened();

        Assert.assertTrue(checkOutStepTwoPage.isFinishButtonPresent());
        Assert.assertEquals(checkOutStepTwoPage.getItemPrice(testItemName), expectedItemPrice);
        Assert.assertEquals(checkOutStepTwoPage.getItemDescription(testItemName), expectedItemDescription);

        checkOutStepTwoPage.clickFinishButton();

        Assert.assertTrue(checkOutCompletePage.checkOutCompleteMessageIsPresent());
        Assert.assertTrue(checkOutCompletePage.completeTextIsPresent());

    }

    @Test(description = "Negative Checkout Test", groups = {"Regression"})
    public void negativeCheckoutTest() {
        String testItemName = "Sauce Labs Backpack";

        loginPage.setUsername("standard_user").setPassword("secret_sauce").clickLoginButton().
                clickAddToCartButton(testItemName);
        productsPage.clickShoppingCartButton().clickCheckOutButton().setFirstNameInput("Evgeniy").setZipCodeInput("12345").
                clickContinueButton();

        Assert.assertTrue(checkOutPage.isErrorMessagePresent());

    }
}
