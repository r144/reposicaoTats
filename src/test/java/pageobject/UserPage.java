/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 *
 * @author viniciusbs
 */
public class UserPage extends RedmineBasePage {
    @FindBy(tagName = "h2")
    WebElement titleFullName;
    
    @FindBy(css = ".splitcontentleft li a")
    WebElement linkEmail;
    
    public UserPage(WebDriver driver) { super(driver); }
}
