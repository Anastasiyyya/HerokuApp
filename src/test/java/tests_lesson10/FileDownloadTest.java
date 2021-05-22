package tests_lesson10;

import constants.IConstants;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FileDownloadTest extends BaseTest implements IConstants {

    public static final String SELECTED_FILE_NAME = "some-file.txt";

    @Test
    public void fileDownloadTest() throws InterruptedException {
        fileDownloadPage.openPage(FILE_DOWNLOAD_PAGE_URL);
        fileDownloadPage.waitForPageLoaded();
        fileDownloadPage.clickDownloadFileLink(SELECTED_FILE_NAME);
        Assert.assertTrue(fileDownloadPage.isFileDownloaded(SELECTED_FILE_NAME));
    }
}
