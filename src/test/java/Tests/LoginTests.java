package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends BaseTests {

    @Test(description = "Positive Login Test", groups = {"Smoke"})
    public void positiveLoginTest() {
        loginPage.setUsername("standard_user").setPassword("secret_sauce").clickLoginButton().isPageOpened();
        Assert.assertTrue(productsPage.isShoppingCartButtonPresent());
    }

    @Test(description = "Negative Login Test", groups = {"Regression"})
    public void negativeLoginTest() {
        loginPage.setUsername("standard_user").setPassword("fdjidfjdfjd").clickLoginButton();
        Assert.assertTrue(loginPage.isErrorMessagePresent());
    }

    @Test(description = "Logout Test", groups = {"Smoke"})
    public void logoutTest() {
        loginPage.setUsername("standard_user").setPassword("secret_sauce").clickLoginButton().clickMenuButton().
                clickLogoutButton().isPageOpened();
        Assert.assertTrue(loginPage.isBotColumnPresent());

    }


}
