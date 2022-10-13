package automationpractice.pages.homePage;

import automationpractice.common.CommonActions;
import automationpractice.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

import static automationpractice.constants.Constant.PriceForTest.PRICE_OF_PRODUCT;

public class HomePage extends BasePage {

    private final By productItem = By.xpath("//ul[@id='homefeatured']/li");
    private final By addToCartButton = By.xpath(String.format("//ul[@id='homefeatured']" +
            "//div[@class='right-block']//span[contains(text(),'%s')]" +
            "/../following::div[1]/a[contains(@class, 'ajax_add_to_cart_button')]/span", PRICE_OF_PRODUCT));
    private final By countCartMessage = By.xpath("//span[@class='ajax_cart_product_txt ']");

    public HomePage() {
        super();
    }

    public List<WebElement> getListOfProduct() {
        return driver.findElements(productItem);
    }

    public void moveToPrice(String testedProductPrice) {
        WebElement price = driver.findElement(By.xpath(String.format("//ul[@id='homefeatured']" +
                "//div[@class='right-block']//span[contains(text(),'%s')]", testedProductPrice)));
        Actions actions = new Actions(driver);
        actions.moveToElement(price).perform();
    }

    public void clickOnAddToCartButton(String testedProductPrice) {
        driver.findElement(By.xpath(String.format("//ul[@id='homefeatured']//div[@class='right-block']" +
                        "//span[contains(text(),'%s')]/../following::div[1]" +
                        "/a[contains(@class, 'ajax_add_to_cart_button')]/span", testedProductPrice)))
                .click();
    }

    public String getCartCountMessage() {
        CommonActions.waitElementIsVisible(countCartMessage);
        return driver.findElement(countCartMessage).getText();
    }
}
