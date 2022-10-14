package automationpractice.services;

import automationpractice.pages.homePage.HomePage;
import automationpractice.pages.homePage.classes.Product;
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

    public Product getProduct(WebElement parentElement) {
        String productTitle = homePage.getTitle(parentElement);
        String actualPrice = homePage.getActualPrice(parentElement);
        String fullPrice = homePage.getFullPrice(parentElement);
        String discount = homePage.getDiscount(parentElement);
        return new Product.ProductBuilder()
                .setProductTitle(productTitle)
                .setActualPrice(actualPrice)
                .setFullPrice(fullPrice)
                .setDiscount(discount)
                .build();
    }

    public List<Product> getProductList() {
        homePage = new HomePage();
        return homePage.getListOfProduct().stream().map(this::getProduct).collect(Collectors.toList());
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