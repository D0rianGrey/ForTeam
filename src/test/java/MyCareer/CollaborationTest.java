package MyCareer;

import PageObject.Collaboration;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;


public class CollaborationTest {

    public WebDriver driver;
    public Collaboration collaboration;


    @BeforeTest
    public void setUP() throws InterruptedException {
        driver = new ChromeDriver();
        collaboration = new Collaboration(driver);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://my.vmdcs.cistest.local/en-us/vacancies/collaboration-with-freelancers");
        Thread.sleep(3000);
        collaboration.clickApplyButton();
    }

    @Test //(enabled = false)
    public void test1() throws InterruptedException {

        //Name
        /*WebElement name = driver.findElement(By.xpath("//input[@name='first_name']"));
        name.sendKeys("Eugene");
        Thread.sleep(5000);*/

        collaboration.enterName("Eugene")
                .enterSurname("Vakerin");


        /*//Surname
        WebElement lastName = driver.findElement(By.xpath("//input[@name='last_name']"));
        lastName.sendKeys("Vakerin");*/

        //Phone
        WebElement phone = driver.findElement(By.xpath("//input[@name='pnone']"));
        phone.sendKeys("+380980539988");

        //Email
        WebElement email = driver.findElement(By.xpath("//input[@name='email']"));
        email.sendKeys("imats@cistest.local");

        //InfoSource
        WebElement selectInfoSource = driver.findElement(By.xpath("//*[@id=\"select2-info_source-container\"]"));
        selectInfoSource.click();
        WebElement webSite = driver.findElement(By.xpath("//span[text()='Website softserveinc.com']"));
        webSite.click();

        //Resume
        //WebElement resume = driver.findElement(By.xpath("//input[@type='file']"));
        //resume.sendKeys("C:\\Users\\yvake\\Downloads\\ForTeam\\src\\main\\resources\\1MBThis is_resume_very big resume_ for Peter Gold!!_Lviv 2019.PDF");
        //resume.sendKeys("C:\\Users\\yvake\\Downloads\\ForTeam\\src\\main\\resources\\3Mb.pdf");
        //Thread.sleep(6000);

        //Linkedin
        WebElement linkedin = driver.findElement(By.xpath("//input[@name='linkedin']"));
        linkedin.sendKeys("https://www.linkedin.com/in/ievgenii-vakerin-4b6936102/");

        //Click 'Submit' button

        /*WebElement submitButton = driver.findElement(By.xpath("//button[@class='collaboration-form-submit-btn']"));
        submitButton.click();*/
        collaboration.clickSubmitButton();

        //Assertion

        WebElement message = driver.findElement(By.xpath("//div[@class='main-message']"));
        String actualMessage = message.getText();
        System.out.println(actualMessage);
        String expectedMessage = "GREAT\n" +
                "JOB";
        Assert.assertTrue(actualMessage.contains(expectedMessage), "Something went wrong");


    }

    @Test(enabled = false)
    public void test2() {
        collaboration.enterName("Elena")
                .clickSubmitButton();
        String surnameErrorExpected = "The Surname field is required.";
        WebElement error = driver.findElement(By.xpath("//span[@class='collaboration-form-control-error']"));
        String surnameErrorActual = error.getText();
        Assert.assertEquals(surnameErrorActual,surnameErrorExpected);
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}
