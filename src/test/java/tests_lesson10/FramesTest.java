package tests_lesson10;

import constants.IConstants;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FramesTest extends BaseTest implements IConstants {

    public static final String EXPECTED_TEXT_IN_FRAME = "Your content goes here.";

    @Test
    public void checkTextInFrameTest() {
        iframePage.openPage(FRAMES_PAGE_URL);
        iframePage.waitForPageLoading();
        Assert.assertEquals(iframePage.getTextFromIFrameEditor(), EXPECTED_TEXT_IN_FRAME);
    }
}
