package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends BaseTests {

    @Test
    public void positiveLoginTest() {
        loginPage.setUsername("standard_user");
        loginPage.setPassword("secret_sauce");
        loginPage.clickLoginButton();
        Assert.assertTrue(productsPage.isShoppingCartButtonPresent());
    }

    @Test
    public void negativeLoginTest() {
        loginPage.setUsername("standard_user");
        loginPage.setPassword("fdjidfjdfjd");
        loginPage.clickLoginButton();
        Assert.assertTrue(true, loginPage.getErrorMessageText());
    }

}
