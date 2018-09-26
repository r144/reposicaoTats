package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BuscaPage extends RedmineBasePage {

    @FindBy(tagName = "h3")
    WebElement MessageResults;

    public BuscaPage(WebDriver driver) {
        super(driver);
    }

    public WebElement getMessageResults() {
        return MessageResults;
    }
}
