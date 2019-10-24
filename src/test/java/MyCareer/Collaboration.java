package MyCareer;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Collaboration {

    private WebDriver driver;


    @BeforeTest
    public void setUP(){
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://my.vmdcs.cistest.local/en-us/vacancies/collaboration-with-freelancers");
    }

    @Test
    public void test1() throws InterruptedException {
        WebElement applyButton = driver.findElement(By.xpath("//button[@class='action-button']"));
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", applyButton);
        WebElement name = driver.findElement(By.xpath("//input[@name='first_name']"));
        name.sendKeys("Eugene");
        Thread.sleep(3000);
        WebElement selectInfoSource = driver.findElement(By.xpath("//*[@id=\"select2-info_source-container\"]"));
        selectInfoSource.click();
        Thread.sleep(5000);
        WebElement webSite = driver.findElement(By.xpath("//span[text()='Website softserveinc.com']"));
        webSite.click();
        Thread.sleep(5000);


    }

    @AfterTest
    public void tearDown(){
        driver.quit();
    }
}
