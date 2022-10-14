package automationpractice.tests;

import automationpractice.pages.homePage.classes.Product;
import automationpractice.services.HomePageService;
import automationpractice.utils.ExpectedProduct;
import automationpractice.utils.PropertiesParser;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

import static automationpractice.constants.Constant.Messages.ONE_PRODUCT_ADDED_TO_CART;
import static automationpractice.constants.Constant.PriceForTest.PRICE_OF_PRODUCT;

public class TestCase extends BaseTest {

    private HomePageService homePageService;
    private ExpectedProduct expectedProduct;

    @Test
    public void testCase1() {
        homePageService = new HomePageService();
        expectedProduct = new ExpectedProduct();

        List<Product> actualProductList = homePageService.getProductList();

        for (int item = 1; item <= homePageService.countProducts(); item++) {
            Product product = expectedProduct.getExpectedProduct(String.format("item%s", item));
            Assert.assertTrue(actualProductList.get(item - 1).equals(product));
        }
    }

    @Test
    public void testCase2() {
        homePageService = new HomePageService();
        homePageService.addProductToCart(PRICE_OF_PRODUCT);
        Assert.assertEquals(homePageService.getCartCountMessage(), ONE_PRODUCT_ADDED_TO_CART);
    }
}