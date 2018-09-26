package redmineTests;/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageobject.BuscaPage;
import pageobject.HomePage;
import pageobject.RegisterPage;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.*;

/**
 *
 * @author viniciusbs
 */
public class TesteExemplo01 {

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
    public void registerTest() {
        HomePage hp = new HomePage(driver);
        RegisterPage rp = hp.getMenu().goToRegister();

        rp.getMenu()
                .goToRegister()
                .fillUser("vinibs")
                .fillPass("abacaxi")
                .fillPassConfirm("abacaxi")
                .fillName("Vinicius")
                .fillLastName("Baroni")
                .fillEmail("vsoares@gmail.com")
                .fillLanguage("Português(Brasil)")
                .clickRegisterButton();
        //Assert
    }
    @Test
    public void buscaTest() {
        HomePage hp = new HomePage(driver);
        BuscaPage bp  = hp.getMenu().writeOnBusca("teste").SendBusca();

        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.titleIs("Busca - Redmine"));
        //Assert

    }
}

