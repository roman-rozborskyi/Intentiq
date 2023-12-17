package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.drivermanager.DriverManager;

import java.time.Duration;

public class Waiter {
    private static final int DEFAULT_WAIT_TIME = 10;
    private WebDriver webDriver;

    {
        DriverManager driverManager = DriverManager.getInstance();
        webDriver  = driverManager.getDriver();
    }

    public Waiter waitVisibility(By locator) {
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(DEFAULT_WAIT_TIME));
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        return this;
    }

    public Waiter waitVisibility(WebElement webElement) {
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(DEFAULT_WAIT_TIME));
        wait.until(ExpectedConditions.visibilityOf(webElement));
        return this;
    }

    public Waiter waitInvisibility(By locator) {
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(DEFAULT_WAIT_TIME));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
        return this;
    }

    public Waiter wait(int milliSeconds) {
        try {
            Thread.sleep(milliSeconds);
        } catch (InterruptedException e) {
            //do nothing
        }
        return this;
    }

    public Waiter waitDocumentReady() {
        new WebDriverWait(webDriver, Duration.ofSeconds(DEFAULT_WAIT_TIME)).until(
                webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
        return this;
    }
}
