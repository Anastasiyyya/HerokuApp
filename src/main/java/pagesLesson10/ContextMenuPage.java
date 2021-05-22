package pagesLesson10;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class ContextMenuPage extends BasePage{

    public static By CONTEXT_MENU_PAGE_ELEMENT = By.xpath("//*[@id='hot-spot']");

    public ContextMenuPage(WebDriver driver) {
        super(driver);
    }

    /**
     * We perform the right mouse click on the borders of the element
     * when it appears on the page.
     */
    public void rightClickOnAnElementOnThePage() {
        Actions action = new Actions(driver);
        waitForElementLocated(CONTEXT_MENU_PAGE_ELEMENT, 10);
        action.contextClick(driver.findElement(CONTEXT_MENU_PAGE_ELEMENT)).perform();
    }

    public String getAlertText() {
        waitAlertIsPresents(10);
        return driver.switchTo().alert().getText();
    }

    public void closeAlert() {
        driver.switchTo().alert().accept();
    }
}
