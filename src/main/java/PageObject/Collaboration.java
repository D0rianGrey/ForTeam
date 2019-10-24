package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Collaboration {
    public WebDriver driver;
    public WebDriverWait wait;


    public Collaboration(WebDriver driver) {
        this.driver = driver;
    }


    public By nameField = By.xpath("//input[@name='first_name']");
    public By surnameField = By.xpath("//input[@name='last_name']");
    public By submitButton = By.xpath("//button[@class='collaboration-form-submit-btn']");


    public Collaboration enterName(String name) {
        driver.findElement(nameField).sendKeys(name);
        return new Collaboration(driver);
    }

    public Collaboration enterSurname(String surname) {
        driver.findElement(surnameField).sendKeys(surname);
        return new Collaboration(driver);
    }

    public Collaboration clickSubmitButton(){
        driver.findElement(submitButton).click();
        return new Collaboration(driver);
    }

    public Collaboration clickApplyButton(){
        WebElement applyButton = driver.findElement(By.xpath("//button[@class='action-button']"));
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", applyButton);
        return new Collaboration(driver);
    }

}
