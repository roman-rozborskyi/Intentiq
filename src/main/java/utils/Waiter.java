package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.drivermanager.DriverManager;

import java.time.Duration;

public class Waiter {
    protected WebDriver webDriver;

    {
        DriverManager driverManager = DriverManager.getInstance();
        webDriver  = driverManager.getDriver();
    }

    public Waiter waitVisibility(By locator) {
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
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
        new WebDriverWait(webDriver, Duration.ofSeconds(2)).until(
                webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
        return this;
    }
}
