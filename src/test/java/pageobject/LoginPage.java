package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends RedmineBasePage{

    @FindBy(id = "username")
    private WebElement inputUserName;

    @FindBy(id = "password")
    private WebElement inputPassword;

    @FindBy(name = "login")
    private WebElement buttonLogin;

    @FindBy(linkText = "Perdi minha senha")
    private WebElement linkLostPassowrd;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public WebElement getInputUserName() {
        return inputUserName;
    }

    public WebElement getInputPassword() {
        return inputPassword;
    }

    public WebElement getButtonLogin() {
        return buttonLogin;
    }

    public WebElement getLinkLostPassowrd() {
        return linkLostPassowrd;
    }

    public void DoLogin(String user, String password){
        WebElement inputUser = getInputUserName();
        WebElement inputPass = getInputPassword();
        WebElement buttonLogin = getButtonLogin();

        inputUser.sendKeys(user);
        inputPass.sendKeys(password);

        buttonLogin.click();
    }
}
