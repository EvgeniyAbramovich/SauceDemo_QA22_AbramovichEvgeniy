package Pages;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;

@Log4j2
public abstract class BasePages {
    protected static WebDriver driver;

    public abstract boolean isPageOpened();

    public BasePages(WebDriver driver) {
        this.driver = driver;
    }

}
