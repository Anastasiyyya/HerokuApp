package tests_lesson10;

import org.testng.Assert;
import org.testng.annotations.Test;

public class FileUploadTest extends BaseTest{

    public static final String PATH_TO_THE_FILE = System.getProperty("user.dir") + "/src/test/resources/txt";
    public static final String FILE_NAME = "txt";

    @Test
    public void uploadFileTest() {
        fileUploadPage.openPage(FILE_UPLOAD_PAGE_URL);
        fileUploadPage.uploadFile(PATH_TO_THE_FILE);
        Assert.assertEquals(fileUploadPage.getFileUploadedName(), FILE_NAME);
    }
}
