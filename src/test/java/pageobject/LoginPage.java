package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends RedmineBasePage{

    @FindBy(id = "username")
    WebElement inputUserName;

    @FindBy(id = "password")
    WebElement inputPassword;

    @FindBy(name = "login")
    WebElement buttonLogin;

    @FindBy(linkText = "Perdi minha senha")
    WebElement linkLostPassowrd;

    public LoginPage(WebDriver driver) {
        super(driver);
    }


}
