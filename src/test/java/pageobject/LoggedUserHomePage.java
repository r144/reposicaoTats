/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

/**
 *
 * @author viniciusbs
 */
public class LoggedUserHomePage extends RedmineBasePage {
    @FindBy(id = "user_firstname")
    WebElement inputFirstName;
    
    @FindBy(id = "user_lastname")
    WebElement inputLastName;
    
    @FindBy(id = "user_mail")
    WebElement inputEmail;
    
    @FindBy(id = "user_language")
    WebElement comboboxLanguage;
    
    @FindBy(name = "commit")
    WebElement buttonSaveChanges;
    
    @FindBy(id = "user_mail_notification")
    WebElement comboboxMailNotification;
    
    @FindBy(id = "pref_no_self_notified")
    WebElement checkboxNoSelfNotified;
    
    @FindBy(id = "pref_hide_mail")
    WebElement checkboxHideMyEmail;
    
    @FindBy(id = "pref_time_zone")
    WebElement inputTimeZone;
    
    @FindBy(id = "pref_comments_sorting")
    WebElement comboboxCommentsSorting;
    
    @FindBy(id = "pref_warn_on_leaving_unsaved")
    WebElement checkboxWarnLeavingUnsaved;
    
    @FindBy(css = "#sidebar .user.active")
    WebElement linkUser;
    
    @FindBy(css = "#sidebar .icon.icon-del")
    WebElement linkAccountDelete;
    
    
    public LoggedUserHomePage (WebDriver driver) { super(driver); }
    
    public LoggedUserHomePage fillFirstName(String firstName) {
        inputFirstName.clear();
        inputFirstName.sendKeys(firstName);
        return this;
    }
    
    public LoggedUserHomePage fillLastName(String lastName) {
        inputLastName.clear();
        inputLastName.sendKeys(lastName);
        return this;
    }
    
    public LoggedUserHomePage fillEmail(String email) {
        inputEmail.clear();
        inputEmail.sendKeys(email);
        return this;
    }
    
    public LoggedUserHomePage selectLanguage(String language) {
        Select comboboxLang = new Select(comboboxLanguage);
        comboboxLang.selectByVisibleText(language);
        return this;
    }
    
    public LoggedUserHomePage clickSaveButton() {
        buttonSaveChanges.click();
        return new LoggedUserHomePage(driver);
    }  
    
}
