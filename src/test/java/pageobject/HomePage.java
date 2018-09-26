package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends RedmineBasePage {

    @FindBy(linkText = "register for an account")
    public WebElement linkRegister;

    @FindBy(linkText = "create your own project")
    private WebElement linkCreateOwnProject;
    
    @FindBy(tagName = "h2")
    private WebElement pageTitle;

    public HomePage(WebDriver driver) {
        super(driver);
        driver.get("http://demo.redmine.org/");
    }

    public WebElement getLinkRegister() {
        return linkRegister;
    }

    public WebElement getLinkCreateOwnProject() {
        return linkCreateOwnProject;
    }
    
    public WebElement getPageTitle() {
        return pageTitle;
    }
}
