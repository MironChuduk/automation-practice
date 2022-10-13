package automationpractice.tests;

import automationpractice.pages.homePage.classes.Product;
import automationpractice.services.HomePageService;
import org.apache.commons.lang3.StringUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import static automationpractice.constants.Constant.Messages.ONE_PRODUCT_ADDED_TO_CART;
import static automationpractice.constants.Constant.PriceForTest.PRICE_OF_PRODUCT;

public class TestCase extends BaseTest {

    private HomePageService homePageService;

    @Test
    public void testCase1() {
        homePageService = new HomePageService();
        FileInputStream propertyFile;
        Properties property = new Properties();

        try {
            for (int item = 1; item <= homePageService.countProducts(); item++) {

                propertyFile = new FileInputStream("src/test/resources/testData.properties");
                property.load(propertyFile);
                String dataString = property.getProperty(String.format("item%s", item));
                String[] listOfProperties = StringUtils
                        .splitByWholeSeparatorPreserveAllTokens(dataString, ";");
                Product expectedProduct = new Product.ProductBuilder()
                        .setProductTitle(listOfProperties[0])
                        .setActualPrice(listOfProperties[1])
                        .setFullPrice(listOfProperties[2])
                        .setDiscount(listOfProperties[3])
                        .build();
                System.out.println(expectedProduct);

                String actualName = homePageService.getNames().get(item - 1);
                String actualActualPrice = homePageService.getActualPrice().get(item - 1);
                String actualFullPrice = homePageService.getFullPrice().get(item - 1);
                String actualDiscount = homePageService.getDiscount().get(item - 1);
                Product actualProduct = new Product.ProductBuilder()
                        .setProductTitle(actualName)
                        .setActualPrice(actualActualPrice)
                        .setFullPrice(actualFullPrice)
                        .setDiscount(actualDiscount)
                        .build();
                System.out.println(actualProduct);

                Assert.assertTrue(actualProduct.equals(expectedProduct));
            }
        } catch (IOException e) {
            System.err.println("ERROR! File of 'testData' is not found.");
        }
    }

    @Test
    public void testCase2() {
        homePageService = new HomePageService();
        homePageService.addProductToCart(PRICE_OF_PRODUCT);
        Assert.assertEquals(homePageService.getCartCountMessage(), ONE_PRODUCT_ADDED_TO_CART);
    }
}
