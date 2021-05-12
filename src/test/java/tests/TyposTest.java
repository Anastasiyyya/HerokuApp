package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;


import java.util.concurrent.TimeUnit;

public class TyposTest {

    @Test
    public void typoTest() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get("http://the-internet.herokuapp.com/typos");
        WebElement paragraph = driver.findElement(By.xpath("//*/p[2]"));
        String actualText = paragraph.getText();
        Assert.assertEquals(actualText, "Sometimes you'll see a typo, other times you won't.");
        driver.quit();
    }
}
