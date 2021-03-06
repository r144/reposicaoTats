/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package redmineTests;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.util.concurrent.TimeUnit;

import org.junit.*;

import static org.junit.Assert.*;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageobject.*;

/**
 * @author viniciusbs
 */
public class MultiTests {

    WebDriver driver;

    @BeforeClass
    public static void setUpClass() {
        WebDriverManager.chromedriver().setup();
    }

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
    public void tearDown() {
        driver.close();
    }


    @Test
    public void loginTest() {
        HomePage hp = new HomePage(driver);

        HomePage lhp = doLogin(hp);
        
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.titleIs("Redmine demo"));
        Assert.assertEquals("Página inicial", lhp.getPageTitle().getText());
    }

    @Test
    public void tryRegisterInvalidUserTest() {
        HomePage hp = new HomePage(driver);
        Menu m = hp.getMenu();
        RegisterPage rp = m.goToRegister();
        rp.fillUser("vinibs");
        rp.fillPass("abacaxi");
        rp.fillPassConfirm("abacaxi");
        rp.fillName("Vinicius");
        rp.fillLastName("Baroni");
        rp.fillEmail("vsoares@gmail.com");
        rp.fillLanguage("Portuguese/Brasil (Português/Brasil)");
        rp.clickRegisterButton();
        Assert.assertEquals("Usuário não está disponível", rp.getMessageError().getText());
    }

    @Test
    public void buscaTest() {
        HomePage hp = new HomePage(driver);
        BuscaPage bp = hp.getMenu().writeOnBusca("lorem Ipsum").SendBusca();

        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.titleIs("Busca - Redmine demo"));
        Assert.assertEquals("Resultados (1)", bp.getMessageResults().getText());

    }

    @Test
    public void menuOptionsTest() {
        HomePage hp = new HomePage(driver);
        RegisterPage rp = hp.getMenu().goToRegister();
        Assert.assertEquals("http://demo.redmine.org/account/register", rp.getLink());

        LoginPage lp = rp.getMenu().goToLogin();
        Assert.assertEquals("http://demo.redmine.org/login", lp.getLink());

        HelpPage helpPage = lp.getMenu().goToHelp();
        Assert.assertEquals("http://www.redmine.org/guide", helpPage.getLink());

        ProjectsPage pp = helpPage.getMenu().goToProjects();
        Assert.assertEquals("http://www.redmine.org/projects", pp.getLink());

        hp = pp.getMenu().goToHome();
        Assert.assertEquals("http://demo.redmine.org/", hp.getLink());
    }

    @Test
    public void myPageTest() {
        HomePage hp = new HomePage(driver);
        HomePage lhp = doLogin(hp);
        lhp.getMenu().goToUserPage();
        
        Assert.assertEquals("http://demo.redmine.org/my/page", lhp.getLink());
    }

    @Test
    public void tryRegisterWithoutEmailTest() {
        HomePage hp = new HomePage(driver);
        Menu m = hp.getMenu();
        RegisterPage rp = m.goToRegister();
        rp.fillUser("vini");
        rp.fillPass("abacaxi");
        rp.fillPassConfirm("abacaxi");
        rp.fillName("Vinicius");
        rp.fillLastName("Baroni");
        rp.getInputEmail().clear();
        rp.fillLanguage("Portuguese/Brasil (Português/Brasil)");
        rp.clickRegisterButton();
        Assert.assertEquals("E-mail não pode ficar vazio", rp.getMessageError().getText());
    }
    
    private HomePage doLogin(HomePage hp) {
        return hp.getMenu()
                .goToLogin()
                .fillUser("vinibs")
                .fillPass("abacaxi")
                .clickLoginButton();
    }
}
