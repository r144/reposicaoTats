package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BasePage {
    protected WebDriver driver;

    public BasePage(WebDriver drier){
        this.driver = driver;

        PageFactory.initElements(driver, this);
    }
}
