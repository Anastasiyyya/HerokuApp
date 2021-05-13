package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class LocalHtmlPageTest {
    @Test
    public void getValueFirstRowSecondColumnExample1Test() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get("E:/Courses/Done/Class/HerokuApp/src/test/resources/page.html");
        WebElement getInformation = driver.findElement(By.xpath("//tr[2]/td[2]"));
        String name = getInformation.getText();
        Assert.assertEquals(name, "Smith");
        driver.quit();
    }

    @Test
    public void checkInputFieldTest() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get("E:/Courses/Done/Class/HerokuApp/src/test/resources/page.html");
        WebElement getInformation = driver.findElement(By.xpath("//*[@name='comment']"));
        Assert.assertTrue(getInformation.isDisplayed());
        driver.quit();
    }
    @Test
    public void checkUserInputTest() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get("E:/Courses/Done/Class/HerokuApp/src/test/resources/page.html");
        WebElement getInformation = driver.findElement(By.xpath("//textarea[@name='comment']"));
        getInformation.sendKeys("abc");
        String text = getInformation.getAttribute("value");
        Assert.assertEquals(text,"abc");
        driver.quit();
    }

    @Test
    public void checkboxIsCheckedTest() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get("E:/Courses/Done/Class/HerokuApp/src/test/resources/page.html");
        WebElement checkbox = driver.findElement(By.xpath("//*[@type='checkbox']"));
        checkbox.click();
        Assert.assertTrue(checkbox.isSelected());
        driver.quit();
    }

    @Test
    public void clickLinkTest() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get("E:/Courses/Done/Class/HerokuApp/src/test/resources/page.html");
        WebElement link = driver.findElement(By.xpath("//*[@href='https://www.tut.by/']"));
        link.click();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        WebElement image = driver.findElement(By.xpath("//*[@class='header-logo']"));
        Assert.assertTrue(image.isDisplayed());
        driver.quit();
    }
    @Test
    public void findImageTest() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get("E:/Courses/Done/Class/HerokuApp/src/test/resources/page.html");
        WebElement image = driver.findElement(By.xpath("//img"));
        Assert.assertTrue(image.isDisplayed());
        driver.quit();
    }

}

