package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePages {
    private final static By usernameInput = By.cssSelector("#user-name");
    private By passwordInput = By.cssSelector("#password");
    private By logInButton = By.cssSelector("#login-button");
    private By errorMessageContainer = By.cssSelector(".error-message-container");


    public LoginPage(WebDriver driver) {
        super(driver);

    }

    public void clickLoginButton() {

        driver.findElement(logInButton).click();
    }

    public void setUsername (String username) {
        driver.findElement(usernameInput).sendKeys(username);
    }

    public void setPassword (String password) {
        driver.findElement(passwordInput).sendKeys(password);
    }

    public boolean getErrorMessageText () {
       return driver.findElement(errorMessageContainer).isDisplayed();
    }


}
