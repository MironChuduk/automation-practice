package automationpractice.pages.homePage;

import automationpractice.common.CommonActions;
import automationpractice.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class HomePage extends BasePage {

    private final By productItem = By.xpath("//ul[@id='homefeatured']/li");
    private final By price26 = By.xpath("//ul[@id='homefeatured']//div[@class='right-block']" +
            "//span[contains(text(),'$26.00')]");
    private final By addToCartButton = By.xpath("//ul[@id='homefeatured']" +
            "//div[@class='right-block']//span[contains(text(),'$26.00')]" +
            "/../following::div[1]/a[contains(@class, 'ajax_add_to_cart_button')]/span");
    private final By countCartMessage = By.xpath("//span[@class='ajax_cart_product_txt ']");

    public HomePage() {
        super();
    }

    public List<WebElement> getListOfProduct() {
        return driver.findElements(productItem);
    }

    public void moveToPrice26() {
        WebElement price = driver.findElement(price26);
        Actions actions = new Actions(driver);
        actions.moveToElement(price).perform();
    }

    public void clickOnAddToCartButton() {
        driver.findElement(addToCartButton).click();
    }

    public String getCartCountMessage() {
        CommonActions.waitElementIsVisible(countCartMessage);
        return driver.findElement(countCartMessage).getText();
    }
}
