package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class InputsTest {
    @Test
    public void inputIntTest() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get("http://the-internet.herokuapp.com/inputs");
        int number = (int) (Math.random() * 1000);
        WebElement inputField = driver.findElement(By.xpath("//*[@type='number']"));
        inputField.sendKeys(Integer.toString(number));
        String actualText = inputField.getAttribute("value");
        Assert.assertEquals(actualText, Integer.toString(number));
        driver.quit();
    }
    @Test
    public void inputTxtTest() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get("http://the-internet.herokuapp.com/inputs");
        WebElement inputField = driver.findElement(By.xpath("//*[@type='number']"));
        inputField.sendKeys("Some Text");
        String actualText = inputField.getAttribute("value");
        Assert.assertEquals(actualText, "Some Text");
        driver.quit();
    }
    @Test
    public void plusOneTest() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get("http://the-internet.herokuapp.com/inputs");
        WebElement inputField = driver.findElement(By.xpath("//*[@type='number']"));
        inputField.sendKeys("15");
        inputField.sendKeys(Keys.ARROW_UP);
        String actualText = inputField.getAttribute("value");
        Assert.assertEquals(actualText,"16");
        driver.quit();
    }
    @Test
    public void minusOneTest() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get("http://the-internet.herokuapp.com/inputs");
        WebElement inputField = driver.findElement(By.xpath("//*[@type='number']"));
        inputField.sendKeys("15");
        inputField.sendKeys(Keys.ARROW_DOWN);
        String actualText = inputField.getAttribute("value");
        Assert.assertEquals(actualText,"14");
        driver.quit();
    }
}
