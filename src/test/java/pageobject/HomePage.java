package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends RedmineBasePage {

    @FindBy(linkText = "register for an account")
    public WebElement linkRegister;

    @FindBy(linkText = "create your own project")
    private WebElement linkCreateOwnProject;

    @FindBy(xpath = "//*[@id=\"content\"]/div[1]/div/a")
    private WebElement linkNews;
    public HomePage(WebDriver driver) {
        super(driver);
        driver.get("http://demo.redmine.org/");
    }

    public WebElement getLinkNews() {
        return linkNews;
    }

    public WebElement getLinkRegister() {
        return linkRegister;
    }

    public WebElement getLinkCreateOwnProject() {
        return linkCreateOwnProject;
    }

    public NewsPage goToNews() {
        getLinkNews().click();
        return new NewsPage(driver);
    }
}
