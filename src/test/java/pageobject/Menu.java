/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pageobject;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 *
 * @author viniciusbs
 */
public class Menu extends BasePage {
    
    @FindBy(xpath = "//*[@id=\"top-menu\"]/ul/li[1]/a")
    WebElement linkHome;
    
    @FindBy(xpath = "//*[@id=\"top-menu\"]/ul/li[2]/a")
    WebElement linkProjects;
    
    @FindBy(xpath = "//*[@id=\"top-menu\"]/ul/li[3]/a")
    WebElement linkHelp;
    
    @FindBy(xpath = "//*[@id=\"top-menu\"]/ul/li[2]/a")
    WebElement linkMyPage;
    
    @FindBy(xpath = "//*[@id=\"loggedas\"]/a")
    WebElement linkLoggedUser;
    
    @FindBy(xpath = "//*[@id=\"account\"]/ul/li[1]/a")
    WebElement linkLogin;

    @FindBy(xpath = "//*[@id=\"account\"]/ul/li[2]/a")
    WebElement linkRegister;

    @FindBy(xpath = "//*[@id=\"account\"]/ul/li[1]/a")
    WebElement linkMyAccount;

    @FindBy(xpath = "//*[@id=\"account\"]/ul/li[2]/a")
    WebElement linkLogout;

    @FindBy(id = "q")
    WebElement inputBusca;
    
    public Menu (WebDriver driver) { super(driver); }

    public LoginPage goToLogin() {
        clickMenuOption(linkLogin);
        return new LoginPage(driver);
    }
    public HomePage goToHome() {
        clickMenuOption(linkHome);
        return new HomePage(driver);
    }
    public ProjectsPage goToProjects() {
        clickMenuOption(linkProjects);
        return new ProjectsPage(driver);
    }
    public RegisterPage goToRegister() {
        clickMenuOption(linkRegister);
        return new RegisterPage(driver);
    }
    public HelpPage goToHelp() {
        clickMenuOption(linkHelp);
        return new HelpPage(driver);
    }
    public MyAccountPage goToMyAccount() {
        clickMenuOption(linkMyAccount);
        return new MyAccountPage(driver);
    }
    public UserPage goToUserPage() {
        clickMenuOption(linkMyPage);
        return new UserPage(driver);
    }
    
    private void clickMenuOption(WebElement menuOption) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until( ExpectedConditions.elementToBeClickable(menuOption));
        menuOption.click();
    }
    
    public Menu writeOnBusca(String buscaText){
        inputBusca.sendKeys(buscaText);
        return this;
    }
    public BuscaPage SendBusca(){
        inputBusca.sendKeys(Keys.ENTER);
        return new BuscaPage(driver);
    }

    public WebElement getLinkHome() {
        return linkHome;
    }

    public WebElement getLinkProjects() {
        return linkProjects;
    }

    public WebElement getLinkHelp() {
        return linkHelp;
    }

    public WebElement getLinkMyPage() {
        return linkMyPage;
    }

    public WebElement getLinkLoggedUser() {
        return linkLoggedUser;
    }

    public WebElement getLinkLogin() {
        return linkLogin;
    }

    public WebElement getLinkRegister() {
        return linkRegister;
    }

    public WebElement getLinkMyAccount() {
        return linkMyAccount;
    }

    public WebElement getLinkLogout() {
        return linkLogout;
    }

    public WebElement getInputBusca() {
        return inputBusca;
    }
}
