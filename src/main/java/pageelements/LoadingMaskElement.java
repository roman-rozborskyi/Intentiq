package pageelements;

import org.openqa.selenium.By;
import utils.Waiter;

public class LoadingMaskElement {
    private static final By LOADING_MASK_LOCATOR = By.xpath("//div[@class='loading-mask']");

    public void waitLoading() {
        new Waiter()
                .waitVisibility(LOADING_MASK_LOCATOR)
                .waitInvisibility(LOADING_MASK_LOCATOR);
    }
}
