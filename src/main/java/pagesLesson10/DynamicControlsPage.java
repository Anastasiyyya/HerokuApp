package pagesLesson10;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class DynamicControlsPage extends BasePage {

    public static final By CHECKBOX = By.xpath("//*[@type='checkbox']");
    public static final By REMOVE_BUTTON = By.xpath("//*[text()='Remove']");
    public static final By MESSAGE = By.xpath("//*[@id='message']");
    public static final By INPUT_FIELD = By.xpath("//*[@type='text']");
    public static final By ENABLE_BUTTON = By.xpath("//*[text()='Enable']");

    public DynamicControlsPage(WebDriver driver) {
        super(driver);
    }

    public void waitForPageLoading() {
        waitForElementLocated(ENABLE_BUTTON, 10);
    }

    public boolean isCheckboxDisplayed() {
        List<WebElement> checkboxesList = driver.findElements(CHECKBOX);
        return !checkboxesList.isEmpty();
    }

    public void clickCheckbox() {
        waitForPageLoading();
        driver.findElement(CHECKBOX).click();
    }

    public boolean isCheckboxSelected() {
        return driver.findElement(CHECKBOX).isSelected();
    }

    public void clickRemoveButton() {
        driver.findElement(REMOVE_BUTTON).click();
    }

    /**
     * Wait until a message that the checkbox has been deleted appears
     * @param message
     */
    public void waitMessage(String message) {
        waitTextDisplayed(MESSAGE, 20, message);
    }

    public boolean isInputFieldEnabled() {
        return driver.findElement(INPUT_FIELD).isEnabled();
    }

    public void clickEnableButton() {
        driver.findElement(ENABLE_BUTTON).click();
    }
}

