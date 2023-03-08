package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Waits {
    private WebDriverWait wait;
    private int timeOutSeconds;

    public Waits(WebDriver driver, int seconds){
        this.timeOutSeconds = seconds;
        wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
    }
    public void waitToBeDisplayed(By locator){
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
}
