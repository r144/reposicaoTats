package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage{

    @FindBy(linkText = "register for an account")
    private WebElement linkRegister;

    @FindBy(linkText = "create your own project")
    private WebElement linkCreateOwnProject;

    public HomePage(WebDriver drier) {
        super(drier);
    }

    public WebElement getLinkRegister() {
        return linkRegister;
    }

    public WebElement getLinkCreateOwnProject() {
        return linkCreateOwnProject;
    }
}
