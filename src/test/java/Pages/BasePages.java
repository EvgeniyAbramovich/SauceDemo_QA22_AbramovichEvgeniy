package Pages;

import org.openqa.selenium.WebDriver;

public abstract class BasePages {
    protected static WebDriver driver;

    public abstract boolean isPageOpened();

    public BasePages(WebDriver driver) {
        this.driver = driver;
    }

}
