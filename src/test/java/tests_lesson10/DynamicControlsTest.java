package tests_lesson10;

import org.testng.Assert;
import org.testng.annotations.Test;

public class DynamicControlsTest extends BaseTest {

    public static final String CHECKBOX_REMOVED_MESSAGE = "It's gone!";
    public static final String INPUT_FIELD_ENABLED_MESSAGE = "It's enabled!";

    @Test
    public void dynamicControlsTest() {
        dynamicControlsPage.openPage(DYNAMIC_CONTROLS_PAGE_URL);
        Assert.assertTrue(dynamicControlsPage.isCheckboxDisplayed());
        dynamicControlsPage.clickCheckbox();
        Assert.assertTrue(dynamicControlsPage.isCheckboxSelected());
        dynamicControlsPage.clickRemoveButton();
        dynamicControlsPage.waitMessage(CHECKBOX_REMOVED_MESSAGE);
        Assert.assertFalse(dynamicControlsPage.isCheckboxDisplayed());
        Assert.assertFalse(dynamicControlsPage.isInputFieldEnabled());
        dynamicControlsPage.clickEnableButton();
        dynamicControlsPage.waitMessage(INPUT_FIELD_ENABLED_MESSAGE);
        Assert.assertTrue(dynamicControlsPage.isInputFieldEnabled());
    }
}
