package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Collaboration {
    public WebDriver driver;
    public WebDriverWait wait;


    public Collaboration(WebDriver driver) {
        this.driver = driver;
    }



   public By nameField = By.xpath("//input[@name='first_name']");
    public By surnameField = By.xpath("//input[@name='last_name']");




    public Collaboration enterName(String name){
        driver.findElement(nameField).sendKeys(name);
        return new Collaboration(driver);
    }

    public Collaboration enterSurname(String surname){
        driver.findElement(surnameField).sendKeys(surname);
        return new Collaboration(driver);
    }






}
