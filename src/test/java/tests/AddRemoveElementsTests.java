package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class AddRemoveElementsTests {
    @Test
    public void addTwoThenDeleteOneElementsTest() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get("http://the-internet.herokuapp.com/add_remove_elements/");
        WebElement addTwoElementsButton = driver.findElement(By.xpath("//button[text()='Add Element']"));
        WebElement deleteButton;
        boolean isDeleteButtonDisplayed;
        for (int i = 1; i <= 2;i++) {
            addTwoElementsButton.click();
            deleteButton = driver.findElement(By.xpath("//*[@id='elements']/*[" + i + "]" ));
            isDeleteButtonDisplayed = deleteButton.isDisplayed();
            Assert.assertTrue(isDeleteButtonDisplayed);
        }
        List<WebElement> countOfElements = driver.findElements(By.xpath("//*[@onclick='deleteElement()']"));
        int numberOfElements = countOfElements.size();
        deleteButton = driver.findElement(By.xpath("//*[@id='elements']/*[1]" ));
        deleteButton.click();
        countOfElements = driver.findElements(By.xpath("//*[@onclick='deleteElement()']"));
        numberOfElements = countOfElements.size();
        System.out.println("The number of buttons 'Delete'" +  numberOfElements);
        driver.quit();
    }
}
