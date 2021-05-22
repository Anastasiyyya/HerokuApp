package pagesLesson10;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

abstract class BasePage {
    WebDriver driver;
    WebDriverWait wait;

    BasePage(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * Opens page according to the passed parameter
     * @param URL
     */
    public void openPage(String URL){
        driver.get(URL);
    }

    /**
     * Wait until the element displayed on the page
     * @param element
     * @param timeout
     */
    public void waitForElementLocated(By element, int timeout) {
        wait = new WebDriverWait(driver, timeout);
        wait.until(ExpectedConditions.visibilityOfElementLocated(element));
    }

    /**
     * Wait until the alert displayed on the page
     * @param timeout
     */
    public void waitAlertIsPresents(int timeout) {
        wait = new WebDriverWait(driver, timeout);
        wait.until(ExpectedConditions.alertIsPresent());
    }

    /**
     * Wait until the alert displayed on the page
     * @param element
     * @param timeout
     * @param string
     */
    public void waitTextDisplayed(By element, int timeout, String string) {
        wait = new WebDriverWait(driver, timeout);
        wait.until(ExpectedConditions.textToBe(element, string));
    }
}