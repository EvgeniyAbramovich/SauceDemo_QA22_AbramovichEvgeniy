package Tests;

import Pages.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public abstract class BaseTests {
    protected WebDriver driver;
    protected LoginPage loginPage;
    protected ProductsPage productsPage;
    protected ShoppingCartPage shoppingCartPage;

    protected CheckOutPage checkOutPage;

    protected CheckOutStepTwoPage checkOutStepTwoPage;

    protected CheckOutCompletePage checkOutCompletePage;

    @BeforeClass
    public void setUp() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        loginPage = new LoginPage(driver);
        productsPage = new ProductsPage(driver);
        shoppingCartPage = new ShoppingCartPage(driver);
        checkOutPage = new CheckOutPage(driver);
        checkOutStepTwoPage = new CheckOutStepTwoPage(driver);
        checkOutCompletePage = new CheckOutCompletePage(driver);
    }

    @BeforeMethod
    public void navigate() {
        driver.get("https://www.saucedemo.com/");
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() {
        driver.quit();
    }
}
