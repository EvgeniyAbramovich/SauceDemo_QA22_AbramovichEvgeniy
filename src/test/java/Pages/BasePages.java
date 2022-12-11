package Pages;

import org.openqa.selenium.WebDriver;

public abstract class BasePages {
    protected static WebDriver driver;

    public BasePages(WebDriver driver) {
        this.driver = driver;
    }

}
