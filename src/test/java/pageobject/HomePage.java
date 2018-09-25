package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    protected WebDriver driver;

    public HomePage(WebDriver drier){
        this.driver = driver;

        PageFactory.initElements(driver, this);
    }
}
