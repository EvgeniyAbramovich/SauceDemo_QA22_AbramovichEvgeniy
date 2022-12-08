import com.fasterxml.jackson.annotation.JsonTypeInfo;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class SauceDemoTest {

    @Test
    public void sauceDemoTest() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.saucedemo.com/");

        WebElement userName = driver.findElement(By.cssSelector("[data-test=\"username\"]"));
        userName.sendKeys("standard_user");
        WebElement password = driver.findElement(By.cssSelector("[data-test=\"password\"]"));
        password.sendKeys("secret_sauce");
        WebElement loginButton = driver.findElement(By.id("login-button"));
        loginButton.click();

        String itemName = "Sauce Labs Bolt T-Shirt";
        String price = "15.99";

        WebElement addToCard = driver.findElement(By.cssSelector("[data-test=\"add-to-cart-sauce-labs-bolt-t-shirt\"]"));
        addToCard.click();
        WebElement shoppingCard = driver.findElement(By.cssSelector("[class=\"shopping_cart_link\"]"));
        shoppingCard.click();

        WebElement addItem = driver.findElement(By.xpath("//*[contains(text(), 'Sauce Labs Bolt T-Shirt')]"));
        Assert.assertEquals(addItem.getText(), itemName);
        WebElement cardPrice = driver.findElement(By.xpath("//div[text()='15.99']"));
        Assert.assertEquals(cardPrice.getText(), price);










    }
}
