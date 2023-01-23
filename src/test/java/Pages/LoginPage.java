package Pages;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
@Log4j2
public class LoginPage extends BasePages {

    @FindBy(css = "#user-name")
    private WebElement usernameInput;
    @FindBy(css = "#password")
    private WebElement passwordInput;
    @FindBy(css = "#login-button")
    private WebElement logInButton;
    @FindBy(css = ".error-message-container")
    private WebElement errorMessageContainer;
    @FindBy(css = ".bot_column")
    private WebElement BOT_COLUMN;


    @Override
    public boolean isPageOpened() {
        return logInButton.isDisplayed();
    }

    public LoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public ProductsPage clickLoginButton() {
        log.info("Clicking LogIn Button");
        logInButton.click();
        return new ProductsPage(driver);
    }

    public LoginPage setUsername (String username) {
        log.info("Setting Username = {}",username);
        usernameInput.sendKeys(username);
        return this;
    }

    public LoginPage setPassword (String password) {
        log.info("Setting Password = {}",password);
        passwordInput.sendKeys(password);
        return this;
    }

    public boolean isErrorMessagePresent () {
        return errorMessageContainer.isDisplayed();
    }

    public boolean isBotColumnPresent () {
        return BOT_COLUMN.isDisplayed();
    }


}
