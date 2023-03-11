package Tests;

import Pages.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import jdk.jfr.Description;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;

import java.util.concurrent.TimeUnit;

@Listeners(TestListener.class)

public abstract class BaseTests {
    protected WebDriver driver;
    protected LoginPage loginPage;
    protected ProductsPage productsPage;
    protected ShoppingCartPage shoppingCartPage;
    protected CheckOutPage checkOutPage;
    protected CheckOutStepTwoPage checkOutStepTwoPage;
    protected CheckOutCompletePage checkOutCompletePage;
    protected InventoryItemPage inventoryItemPage;




    @BeforeClass (alwaysRun = true)
    public void setUp(ITestContext testContext) throws Exception {
        String browserName = System.getProperty("browser", "chrome");
        String headless = System.getProperty("headless","false");
        if (browserName.equals("chrome")) {
            ChromeOptions options = new ChromeOptions();
            if (headless.equals("true")){
                options.addArguments("--headless");
            }
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else if (browserName.equals("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        } else {
            throw new Exception("Incorrect browser name");
        }


        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        testContext.setAttribute("driver", driver);

        loginPage = new LoginPage(driver);
        productsPage = new ProductsPage(driver);
        shoppingCartPage = new ShoppingCartPage(driver);
        checkOutPage = new CheckOutPage(driver);
        checkOutStepTwoPage = new CheckOutStepTwoPage(driver);
        checkOutCompletePage = new CheckOutCompletePage(driver);
        inventoryItemPage = new InventoryItemPage(driver);

    }

    @BeforeMethod (alwaysRun = true)
    public void navigate() {
        driver.get("https://www.saucedemo.com/");
    }

    @Description("Close a browser")
    @AfterClass(alwaysRun = true)
    public void tearDown() {
        driver.quit();
    }
}
