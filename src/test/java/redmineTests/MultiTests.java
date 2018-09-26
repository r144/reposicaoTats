/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package redmineTests;

import io.github.bonigarcia.wdm.WebDriverManager;
import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pageobject.HomePage;
import pageobject.LoggedUserHomePage;

/**
 *
 * @author viniciusbs
 */
public class MultiTests {
    
    WebDriver driver;
    
    @BeforeClass
    public static void setUpClass() { WebDriverManager.chromedriver().setup(); }
    
    @Before
    public void setUp() {
        ChromeOptions chromeOptions = new ChromeOptions();
        //chromeOptions.addArguments("headless");
        chromeOptions.addArguments("window-size=1200x600");
        chromeOptions.addArguments("start-maximized");
        
        driver = new ChromeDriver(chromeOptions);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    
    @After
    public void tearDown() { driver.close(); }


     @Test
     public void loginTest() {
         HomePage hp = new HomePage(driver);
         
         LoggedUserHomePage luhp = hp.getMenu()
                 .goToLogin()
                 .fillUser("vinibs")
                 .fillPass("abacaxi")
                 .clickLoginButton();
     }
}