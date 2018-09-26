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

    @FindBy(name = "commit")
    private WebElement buttonCommit;


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

    public void Register(String user,
                         String password,
                         String passwordConfirm,
                         String name,
                         String lastName,
                         String email,
                         String language,
                         String nick) {

        getInputUser().sendKeys(user);

        getInputPassword().sendKeys(password);

        getInputPasswordConfirm().sendKeys(passwordConfirm);

        getInputFirstName().sendKeys(name);

        getInputLastName().sendKeys(lastName);

        getInputEmail().sendKeys(email);

        Select selectLanguage = new Select(getComboLanguage());

        selectLanguage.selectByVisibleText(language);

        getInputNick().sendKeys(nick);

        getButtonCommit().click();

    }
}
