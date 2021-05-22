package tests_lesson10;

import constants.IConstants;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pagesLesson10.*;

import java.util.HashMap;

public class BaseTest implements IConstants {
    WebDriver driver;
    ContextMenuPage contextMenuPage;
    DynamicControlsPage dynamicControlsPage;
    FileDownloadPage fileDownloadPage;
    FileUploadPage fileUploadPage;
    FramesPage iframe;

    @BeforeMethod
    public void initTest(){
        WebDriverManager.chromedriver().setup();
        HashMap<String, Object> chromePrefs = new HashMap<>();
        chromePrefs.put("profile.default_content_settings.popups", 0);
        chromePrefs.put("download.default_directory", System.getProperty("user.dir"));
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("prefs", chromePrefs);
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        contextMenuPage = new ContextMenuPage(driver);
        dynamicControlsPage = new DynamicControlsPage(driver);
        fileDownloadPage = new FileDownloadPage(driver);
        fileUploadPage = new FileUploadPage(driver);
        iframe = new FramesPage(driver);
    }

    @AfterMethod
    public void endTest() {
        driver.quit();
    }
}
