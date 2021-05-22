package tests_lesson10;

import constants.IConstants;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ContextMenuTest extends BaseTest implements IConstants {
    public static final String APPEARED_ALERT_TEXT = "You selected a context menu";

    @Test
    public void contextMenuTest() {
        contextMenuPage.openPage(CONTEXT_MENU_PAGE_URL);
        contextMenuPage.rightClickOnAnElementOnThePage();
        Assert.assertEquals(contextMenuPage.getAlertText(), APPEARED_ALERT_TEXT);
        contextMenuPage.closeAlert();
    }
}
