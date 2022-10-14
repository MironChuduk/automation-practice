package automationpractice.tests;

import automationpractice.pages.homePage.classes.Product;
import automationpractice.services.HomePageService;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;
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

        List<String> keys = Arrays.asList("item1", "item2", "item3", "item4", "item5", "item6", "item7");
        List<Product> expectedProductList = Product.getExpectedProduct(keys);
        Assert.assertEquals(expectedProductList, actualProductList);
    }

    @Test
    public void testCase2() {
        homePageService = new HomePageService();
        homePageService.addProductToCart(PRICE_OF_PRODUCT);
        Assert.assertEquals(homePageService.getCartCountMessage(), ONE_PRODUCT_ADDED_TO_CART);
    }
}