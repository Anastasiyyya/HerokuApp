package pagesLesson10;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FramesPage extends BasePage {

    public static final By IFRAME_FIELD = By.xpath("//*[@id='content']");
    public static final By FRAME_PART = By.xpath("//*[@id='mce_0_ifr']");
    public static final By ACTUAL_TEXT_IN_FRAME = By.xpath("//*[@id='tinymce']/p");

    public FramesPage(WebDriver driver) {
        super(driver);
    }

    public void waitForPageLoading() {
        waitForElementLocated(IFRAME_FIELD, 10);
    }

    public String getTextFromIFrameEditor() {
        driver.switchTo().frame(driver.findElement(FRAME_PART));
        return driver.findElement(ACTUAL_TEXT_IN_FRAME).getText();
    }
}
