package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class RegisterPage extends RedmineBasePage {

    @FindBy(id = "user_login")
    private WebElement inputUser;

    @FindBy(id = "user_password")
    private WebElement inputPassword;

    @FindBy(id = "user_password_confirmation")
    private WebElement inputPasswordConfirm;

    @FindBy(id = "user_firstname")
    private WebElement inputFirstName;

    @FindBy(id = "user_lastname")
    private WebElement inputLastName;

    @FindBy(id = "user_mail")
    private WebElement inputEmail;

    @FindBy(id = "user_language")
    private WebElement comboLanguage;

    @FindBy(id = "user_custom_field_values_3")
    private WebElement inputNick;

    @FindBy(xpath = "//*[@id=\"new_user\"]/input[3]")
    private WebElement buttonCommit;

    @FindBy(xpath = "//*[@id=\"errorExplanation\"]/ul/li")
    private WebElement MessageError;

    public RegisterPage(WebDriver driver) {
        super(driver);
    }

    public WebElement getInputUser() {
        return inputUser;
    }

    public WebElement getInputPassword() {
        return inputPassword;
    }

    public WebElement getInputPasswordConfirm() {
        return inputPasswordConfirm;
    }

    public WebElement getInputFirstName() {
        return inputFirstName;
    }

    public WebElement getInputLastName() {
        return inputLastName;
    }

    public WebElement getInputEmail() {
        return inputEmail;
    }

    public WebElement getComboLanguage() {
        return comboLanguage;
    }

    public WebElement getInputNick() {
        return inputNick;
    }

    public WebElement getButtonCommit() {
        return buttonCommit;
    }

    public WebElement getMessageError() { return MessageError; }

    public RegisterPage fillUser(String user) {
        getInputUser().sendKeys(user);
        return this;
    }
    public RegisterPage fillPass(String password) {
        getInputPassword().sendKeys(password);
        return this;

    }

    public RegisterPage fillPassConfirm(String passwordConfirm) {
        getInputPasswordConfirm().sendKeys(passwordConfirm);
        return this;

    }

    public RegisterPage fillName(String name) {
        getInputFirstName().sendKeys(name);
        return this;

    }

    public RegisterPage fillLastName(String lastName) {
        getInputLastName().sendKeys(lastName);
        return this;

    }

    public RegisterPage fillEmail(String email) {
        getInputEmail().sendKeys(email);
        return this;

    }

    public RegisterPage fillLanguage(String language) {

        Select selectLanguage = new Select(getComboLanguage());

        selectLanguage.selectByVisibleText(language);
        return this;

    }

    public RegisterPage fillNick(String nick) {

        getInputNick().sendKeys(nick);
        return this;

    }

    public MyAccountPage clickRegisterButton() {

        getButtonCommit().click();
        return new MyAccountPage(driver);

    }

}
