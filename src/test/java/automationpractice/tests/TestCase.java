package automationpractice.tests;

import automationpractice.pages.homePage.classes.Product;
import automationpractice.services.HomePageService;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

import static automationpractice.constants.Constant.Messages.ONE_PRODUCT_ADDED_TO_CART;
import static automationpractice.constants.Constant.PriceForTest.PRICE_OF_PRODUCT;

public class TestCase extends BaseTest {

    private HomePageService homePageService;
    private Product expectedProduct;

    @Test
    public void testCase1() {
        homePageService = new HomePageService();

        List<Product> actualProductList = homePageService.getProductList();

        Product product = Product.getExpectedProduct("item1");
        Assert.assertTrue(actualProductList.get(0).equals(product));
        product = Product.getExpectedProduct("item2");
        Assert.assertTrue(actualProductList.get(1).equals(product));
        product = Product.getExpectedProduct("item3");
        Assert.assertTrue(actualProductList.get(2).equals(product));
        product = Product.getExpectedProduct("item4");
        Assert.assertTrue(actualProductList.get(3).equals(product));
        product = Product.getExpectedProduct("item5");
        Assert.assertTrue(actualProductList.get(4).equals(product));
        product = Product.getExpectedProduct("item6");
        Assert.assertTrue(actualProductList.get(5).equals(product));
        product = Product.getExpectedProduct("item7");
        Assert.assertTrue(actualProductList.get(6).equals(product));
    }

    @Test
    public void testCase2() {
        homePageService = new HomePageService();
        homePageService.addProductToCart(PRICE_OF_PRODUCT);
        Assert.assertEquals(homePageService.getCartCountMessage(), ONE_PRODUCT_ADDED_TO_CART);
    }
}