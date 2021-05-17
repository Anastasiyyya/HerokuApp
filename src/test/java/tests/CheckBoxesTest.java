package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class CheckBoxesTest {

    @Test
    public void firstCheckboxIsUncheckedTest() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("http://the-internet.herokuapp.com/checkboxes");
        WebElement firstCheckbox = driver.findElement(By.xpath("//*[@id='checkboxes']/*[@type='checkbox'][1]"));
        Assert.assertFalse(firstCheckbox.isSelected(), "Test passed. First checkbox is unchecked.");
        driver.quit();
    }

    @Test
    public void checkFirstCheckboxTest() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("http://the-internet.herokuapp.com/checkboxes");
        WebElement firstCheckbox = driver.findElement(By.xpath("//*[@id='checkboxes']/*[@type='checkbox'][1]"));
        firstCheckbox.click();
        Assert.assertTrue(firstCheckbox.isSelected(), "Test passed. First checkbox is checked.");
        driver.quit();
    }

    @Test
    public void checkedSecondCheckboxTest() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("http://the-internet.herokuapp.com/checkboxes");
        WebElement secondCheckbox = driver.findElement(By.xpath("//*[@id='checkboxes']/*[@type='checkbox'][2]"));
        Assert.assertTrue(secondCheckbox.isSelected(), "Test passed.Second checkbox is checked");
        driver.quit();
    }

    @Test
    public void uncheckedSecondCheckboxTest() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get("http://the-internet.herokuapp.com/checkboxes");
        WebElement secondCheckbox = driver.findElement(By.xpath("//*[@id='checkboxes']/*[@type='checkbox'][2]"));
        secondCheckbox.click();
        Assert.assertFalse(secondCheckbox.isSelected(), "Test passed.Second checkbox is unchecked");
        driver.quit();
    }
}
