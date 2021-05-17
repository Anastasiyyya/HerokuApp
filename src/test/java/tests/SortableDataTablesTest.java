package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;


import java.util.Collections;
import java.util.concurrent.TimeUnit;

public class SortableDataTablesTest {
    @Test
    public void getValueFirstRowSecondColumnExample1Test (){
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get("http://the-internet.herokuapp.com/tables");
        WebElement getInformation = driver.findElement(By.xpath("//table[@id='table1']//tr[1]//td[2]"));
        String firstName = getInformation.getText();
        Assert.assertEquals(firstName,"John");
        driver.quit();
    }
    @Test
    public void getDueThirdRowFourthColumnExample2Test (){
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
        driver.get("http://the-internet.herokuapp.com/tables");
        WebElement getInformation = driver.findElement(By.xpath("//*[@id='table2']//tr[3]//td[4]"));
        String dueText = getInformation.getText();
        Assert.assertEquals(dueText,"$100.00");
        driver.quit();
    }
    @Test
    public void tryToClickEditButtonTest (){
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
        driver.get("http://the-internet.herokuapp.com/tables");
        WebElement findButton = driver.findElement(By.xpath("//*[@id=\"table2\"]//tr[3]/td[6]/a[1]"));
        findButton.click();
        driver.quit();
    }
    @Test
    public void checkTheSameValuesOfTwoExamplesTest (){
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
        driver.get("http://the-internet.herokuapp.com/tables");
        WebElement findButton = driver.findElement(By.xpath("//*[@id=\"table2\"]//tr[3]/td[6]/a[1]"));
        findButton.click();
        driver.quit();
    }
    @Test
    public void tryToUseWebSiteLinkTest (){
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("useAutomationExtension", false);
        options.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
        WebDriver driver = new ChromeDriver(options);

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
        driver.get("http://the-internet.herokuapp.com/tables");
        WebElement getInformation = driver.findElement(By.xpath("//*[@id='table1']//tr[2]/td[5]"));
        String due = getInformation.getText();
        driver.get(due);
        driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
        WebElement waitImage = driver.findElement(By.xpath("//*[@id='site-logo']/img"));
        Assert.assertTrue(waitImage.isDisplayed());
        driver.quit();
    }
}
