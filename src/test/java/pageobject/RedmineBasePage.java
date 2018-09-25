package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RedmineBasePage extends BasePage{
    @FindBy(tagName = "h2")
    private WebElement title;

    Menu menu;

    public RedmineBasePage(WebDriver driver){
        super(driver);
        menu = new Menu(driver);
    }

    public Menu getMenu(){
        return this.menu;
    }

    public String getTitle(){
        return title.getAttribute();
    }
}
