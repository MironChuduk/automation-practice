package automationpractice.tests;

import automationpractice.common.Config;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

import static automationpractice.constants.Constant.Urls.HOME_PAGE;

public class BaseTest {

    private static WebDriver driver;

    public static WebDriver getWebDriverInstance() {
        if (driver == null) {
            System.setProperty("webdriver.chrome.driver", Config.CHROME_PATH);
            driver = new ChromeDriver();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            driver.manage().window().maximize();
        }
        return driver;
    }

    @BeforeTest
    public void setUp() {
        driver = getWebDriverInstance();
        driver.get(HOME_PAGE);
    }

    @AfterTest
    public void clearCookiesAndLocalStorage() {
        if (Config.CLEAR_COOKIES_AND_STORAGE) {
            JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
            driver.manage().deleteAllCookies();
            javascriptExecutor.executeScript("window.sessionStorage.clear()");
        }
    }

    @AfterTest(alwaysRun = true)
    public void close() {
        if (Config.HOLD_BROWSER_OPEN) {
            driver.quit();
        }
    }
}
