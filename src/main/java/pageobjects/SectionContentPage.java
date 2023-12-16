package pageobjects;

import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utils.Waiter;

import java.util.List;

public class SectionContentPage extends PageObject {
    private By productContainerLocator = By.xpath("//li[@class='item product product-item']");

    public SectionContentPage waitUntilPageReady() {
        new Waiter()
                .waitVisibility(productContainerLocator)
                .wait(250);
        return this;
    }

    public SectionContentPage addSecondProductToCart() {
        getSecondProduct()
                .hoverImage()
                .clickAddToCartButton();
        return this;
    }

    private ProductItem getSecondProduct() {
        List<WebElement> products = webDriver.findElements(productContainerLocator);
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
            WebElement productContainer = productItemContainer.findElement(By.xpath(productImageXpath));
            new Actions(webDriver)
                    .moveToElement(productContainer)
                    .perform();
            return this;
        }

        private ProductItem clickAddToCartButton() {
            WebElement button = productItemContainer.findElement(By.xpath(addToCartButtonXpath));
            button.click();
            return this;
        }
    }
}
