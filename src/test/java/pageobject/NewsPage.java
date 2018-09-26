package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NewsPage extends RedmineBasePage {

    @FindBy(xpath = "//*[@id=\"content\"]/p[3]/span/a")
    WebElement linkExportToAtom;
    public NewsPage(WebDriver driver) {
        super(driver);
    }

    public WebElement getLinkExportToAtom() {
        return linkExportToAtom;
    }
    public void goToAtomExport(){
        linkExportToAtom.click();
    }
}
