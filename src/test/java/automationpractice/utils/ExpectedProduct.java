package automationpractice.utils;

import automationpractice.pages.homePage.classes.Product;

public class ExpectedProduct {

    public Product getExpectedProduct(String key) {
        PropertiesParser propertiesParser = new PropertiesParser();
        String[] listOfProperties = propertiesParser.parsProperties(key);
        return new Product.ProductBuilder()
                .setProductTitle(listOfProperties[0])
                .setActualPrice(listOfProperties[1])
                .setFullPrice(listOfProperties[2])
                .setDiscount(listOfProperties[3])
                .build();
    }
}