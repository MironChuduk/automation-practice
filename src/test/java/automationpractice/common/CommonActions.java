package automationpractice.common;

import automationpractice.tests.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommonActions {
    public static void waitElementIsVisible(By locator) {
        new WebDriverWait(BaseTest.getWebDriverInstance(), 10)
                .until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
}
