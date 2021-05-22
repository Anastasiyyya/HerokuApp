package pagesLesson10;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FileUploadPage extends BasePage {

    public static final By CHOOSE_FILE_BUTTON = By.xpath("//*[@id='file-upload']");
    public static final By UPLOAD_BUTTON = By.xpath("//*[@id='file-submit']");
    public static final By UPLOADED_FILE_NAME_FIELD = By.xpath("//*[@id='uploaded-files']");

    public FileUploadPage(WebDriver driver) {
        super(driver);
    }

    public void uploadFile(String path) {
        waitForElementLocated(CHOOSE_FILE_BUTTON, 20);
        driver.findElement(CHOOSE_FILE_BUTTON).sendKeys(path);
        driver.findElement(UPLOAD_BUTTON).click();
    }

    public String getFileUploadedName() {
        return driver.findElement(UPLOADED_FILE_NAME_FIELD).getText();
    }
}
