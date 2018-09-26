/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pageobject;

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
    
    @FindBy(css = "#top-menu li.home")
    WebElement linkHome;
    
    @FindBy(css = "#top-menu li.projects")
    WebElement linkProjects;
    
    @FindBy(css = "#top-menu li.help")
    WebElement linkHelp;
    
    @FindBy(css = "#top-menu li.my-page")
    WebElement linkMyPage;
    
    @FindBy(css = "#top-menu #loggedas .user.active")
    WebElement linkLoggedUser;
    
    @FindBy(css = "#top-menu #account li.login")
    WebElement linkLogin;
    
    @FindBy(css = "#top-menu #account li.register")
    WebElement linkRegister;
    
    @FindBy(css = "#top-menu #account li.my-account")
    WebElement linkMyAccount;
    
    @FindBy(css = "#top-menu #account li.logout")
    WebElement linkLogout;
    
    @FindBy(id = "q")
    WebElement inputBusca;
    
    public Menu (WebDriver driver) { super(driver); }
    
    public LoginPage goToLogin() {
        linkLogin.click();
        return new LoginPage(driver);
    }
    
    public LoggedUserHomePage goToMyAccount() {
        linkMyAccount.click();
        return new LoggedUserHomePage(driver);
    }
    
    private void clickMenuOption(WebElement menuOption) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until( ExpectedConditions.elementToBeClickable(menuOption));
        menuOption.click();
    }
    
    public void writeOnBusca(String buscaText){
        inputBusca.sendKeys(buscaText);

    }
}
