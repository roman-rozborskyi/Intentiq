package pageobjects;

import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SectionContentPage extends PageObject {
    private String productContainerXpath = "//li[@class='item product product-item']";

    public SectionContentPage addSecondProductToCart() {
        getSecondProduct()
                .hoverImage()
                .clickAddToCartButton();
        return this;
    }

    private ProductItem getSecondProduct() {
        List<WebElement> products = webDriver.findElements(By.xpath(productContainerXpath));
        WebElement secondProduct = products.get(1);
        return new ProductItem(secondProduct);
    }

    @Getter
    private class ProductItem{
        private WebElement productItemContainer;
        private String addToCartButtonXpath = ".//button[@type='submit']";
        private String productImageXpath = ".//img";

        private ProductItem(WebElement productItemContainer) {
            this.productItemContainer = productItemContainer;
        }

        private ProductItem hoverImage() {
            productItemContainer.findElement(By.xpath(productImageXpath));
            return this;
        }

        private ProductItem clickAddToCartButton() {
            productItemContainer.findElement(By.xpath(addToCartButtonXpath));
            return this;
        }
    }
}
