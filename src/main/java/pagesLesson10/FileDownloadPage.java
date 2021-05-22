package pagesLesson10;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.io.File;

public class FileDownloadPage extends BasePage{

    public static final By CONTENT_DIV = By.xpath("//*[@id='content']");
    public static final String DOWNLOAD_FILE_LINK = "//a[@href='download/%s']";

    public FileDownloadPage(WebDriver driver) {
        super(driver);
    }

    public void waitForPageLoaded() {
        waitForElementLocated(CONTENT_DIV, 10);
    }

    /**
     * Select the file you want to download
     *
     * @param nameOfTheFile
     */
    public void clickDownloadFileLink(String nameOfTheFile) throws InterruptedException {
        driver.findElement(By.xpath(String.format(DOWNLOAD_FILE_LINK, nameOfTheFile))).click();
        Thread.sleep(3000);
    }

    /**
     * This method check if the file has been downloaded
     * @param downloadFileName
     * @return
     */
    public boolean isFileDownloaded(String downloadFileName) {
        File folder = new File(System.getProperty("user.dir"));
        File[] listOfFiles = folder.listFiles();
        boolean found = false;
        File f = null;
        for (File listOfFile : listOfFiles) {
            if (listOfFile.isFile()) {
                String nameOfTheFile = listOfFile.getName();
                System.out.println("File " + listOfFile.getName());
                if (nameOfTheFile.matches(downloadFileName)) {
                    f = new File(nameOfTheFile);
                    found = true;
                }
            }
        }
        return found;
    }
}
