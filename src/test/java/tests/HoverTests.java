package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class HoverTests {
    @Test
    public void hoverOnFirstProfileTest() {
        System.setProperty("webdriver.chrome.driver","src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get("http://the-internet.herokuapp.com/hovers");
        Actions actions = new Actions(driver);
        WebElement userPhoto = driver.findElement(By.xpath("//*[@id='content']//div[1]/img"));
        actions.moveToElement(userPhoto).build().perform();
        WebElement userInfoElement = driver.findElement(By.xpath("//*[@href='/users/1']/../h5"));
        String userName = userInfoElement.getText();
        Assert.assertEquals(userName, "name: user1");
        driver.findElement(By.xpath("//*[@href='/users/1']")).click();
        Assert.assertFalse(driver.getTitle().contains("404"));
        driver.quit();
    }
    @Test
    public void hoverOnSecondProfileTest() {
        System.setProperty("webdriver.chrome.driver","src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get("http://the-internet.herokuapp.com/hovers");
        Actions actions = new Actions(driver);
        WebElement userPhoto = driver.findElement(By.xpath("//*[@id='content']//div[2]/img"));
        actions.moveToElement(userPhoto).build().perform();
        WebElement userInfoElement = driver.findElement(By.xpath("//*[@href='/users/2']/../h5"));
        String userName = userInfoElement.getText();
        Assert.assertEquals(userName, "name: user2");
        driver.findElement(By.xpath("//*[@href='/users/2']")).click();
        Assert.assertFalse(driver.getTitle().contains("404"));
        driver.quit();
    }
    @Test
    public void hoverOnThirdProfileTest() {
        System.setProperty("webdriver.chrome.driver","src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get("http://the-internet.herokuapp.com/hovers");
        Actions actions = new Actions(driver);
        WebElement userPhoto = driver.findElement(By.xpath("//*[@id='content']//div[3]/img"));
        actions.moveToElement(userPhoto).build().perform();
        WebElement userInfoElement = driver.findElement(By.xpath("//*[@href='/users/3']/../h5"));
        String userName = userInfoElement.getText();
        Assert.assertEquals(userName, "name: user3");
        driver.findElement(By.xpath("//*[@href='/users/3']")).click();
        Assert.assertFalse(driver.getTitle().contains("404"));
        driver.quit();
    }
}
