package automationpractice.services;

import automationpractice.pages.homePage.HomePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class HomePageService {

    private HomePage homePage;

    public byte countProducts() {
        homePage = new HomePage();
        return (byte) homePage.getListOfProduct().size();
    }

    public List<String> getNames() {
        List<WebElement> products = homePage.getListOfProduct();
        By title = By.xpath(".//a[@class='product-name']");
        List<WebElement> productTitles = products
                .stream().map(WebElement -> WebElement.findElement(title)).collect(Collectors.toList());
        return productTitles.stream().map(WebElement::getText).collect(Collectors.toList());
    }

    public List<String> getActualPrice() {
        List<WebElement> products = homePage.getListOfProduct();
        By actualPrice = By.xpath(".//div[@class='right-block']//span[@itemprop='price']");
        List<WebElement> actualPrices = products
                .stream().map(WebElement -> WebElement.findElement(actualPrice)).collect(Collectors.toList());
        return actualPrices.stream().map(WebElement::getText).collect(Collectors.toList());
    }

    public List<String> getFullPrice() {
        List<WebElement> products = homePage.getListOfProduct();
        By fullPrice = By.xpath(".//div[@class='right-block']//span[@class='old-price product-price']");
        List<List<WebElement>> fullPricesLists = products
                .stream().map(WebElement -> WebElement.findElements(fullPrice)).collect(Collectors.toList());
        List<String> fullPrices = new ArrayList<>();
        fullPricesLists.forEach(fullPriceList -> {
            if (fullPriceList.isEmpty()) {
                fullPrices.add("");
            } else {
                fullPrices.add(fullPriceList.get(0).getText());
            }
        });
        return fullPrices;
    }

    public List<String> getDiscount() {
        List<WebElement> products = homePage.getListOfProduct();
        By discount = By.xpath(".//div[@class='right-block']//span[@class='price-percent-reduction']");
        List<List<WebElement>> fullPricesLists = products
                .stream().map(WebElement -> WebElement.findElements(discount)).collect(Collectors.toList());
        List<String> discounts = new ArrayList<>();
        fullPricesLists.forEach(fullPriceList -> {
            if (fullPriceList.isEmpty()) {
                discounts.add("");
            } else {
                discounts.add(fullPriceList.get(0).getText());
            }
        });
        return discounts;
    }

    public void addProductToCart(String price) {
        homePage = new HomePage();
        homePage.moveToPrice(price);
        homePage.clickOnAddToCartButton(price);
    }

    public String getCartCountMessage() {
        return homePage.getCartCountMessage();
    }
}
