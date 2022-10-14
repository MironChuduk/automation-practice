package automationpractice.pages.homePage.classes;

import automationpractice.utils.PropertiesParser;

import java.util.Objects;

public class Product {
    private final String productTitle;
    private final String actualPrice;
    private final String fullPrice;
    private final String discount;

    private Product(ProductBuilder builder) {
        this.productTitle = builder.productTitle;
        this.actualPrice = builder.actualPrice;
        this.fullPrice = builder.fullPrice;
        this.discount = builder.discount;
    }

    public static class ProductBuilder {
        private String productTitle;
        private String actualPrice;
        private String fullPrice;
        private String discount;

        public ProductBuilder setProductTitle(String productTitle) {
            this.productTitle = productTitle;
            return this;
        }

        public ProductBuilder setActualPrice(String actualPrice) {
            this.actualPrice = actualPrice;
            return this;
        }

        public ProductBuilder setFullPrice(String fullPrice) {
            this.fullPrice = fullPrice;
            return this;
        }

        public ProductBuilder setDiscount(String discount) {
            this.discount = discount;
            return this;
        }

        public Product build() {
            return new Product(this);
        }
    }

    @Override
    public String toString() {
        return productTitle + "|" + actualPrice + "|" + fullPrice + "|" + discount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product)) return false;

        Product product = (Product) o;

        if (!Objects.equals(productTitle, product.productTitle)) return false;
        if (!Objects.equals(actualPrice, product.actualPrice)) return false;
        if (!Objects.equals(fullPrice, product.fullPrice)) return false;
        return Objects.equals(discount, product.discount);
    }

    public static Product getExpectedProduct(String key) {
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
