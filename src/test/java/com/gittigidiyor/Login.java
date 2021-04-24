package com.gittigidiyor;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.HashMap;

import static org.junit.Assert.assertEquals;

public class Login {

    HashMap<String, String> xPaths = new HashMap<String, String>();
    HashMap<String, String> cssSelector = new HashMap<String, String>();

    public void Login (WebDriver driver, Logger log) throws InterruptedException{

        //It controls the operation of the home page.
        String OpenGittigidiyor = driver.getCurrentUrl();
        assertEquals("You are not in Home Page", OpenGittigidiyor, "https://www.gittigidiyor.com/");
        log.info("Open Main Page");

        //After pressing the "Login Or Sign Up" button, it goes to the "Member Login Page".
        Thread.sleep(2000);
        cssSelector.put("FirstGirisYapButton","div[data-cy='header-user-menu']");
        driver.findElement(By.cssSelector(cssSelector.get("FirstGirisYapButton"))).click();
        Thread.sleep(2000);
        cssSelector.put("SecondGirisYapButton","a[data-cy='header-login-button']");
        driver.findElement(By.cssSelector(cssSelector.get("SecondGirisYapButton"))).click();
        Thread.sleep(2000);

        //It places the mail I wrote in the input.
        driver.findElement(By.name("kullanici")).sendKeys("testonder@outlook.com");

        //It places the Password I wrote in the input.
        xPaths.put("Password","//*[@id='L-PasswordField']");
        driver.findElement(By.xpath(xPaths.get("Password"))).sendKeys("12345testing");

        //Then click the login button.
        xPaths.put("ClickLoginButton","//*[@id='gg-login-enter']");
        driver.findElement(By.xpath(xPaths.get("ClickLoginButton"))).click();
        Thread.sleep(1000);

        //Control
        String LoginControl = driver.getCurrentUrl();
        assertEquals("You logged in unsuccessfully", LoginControl, "https://www.gittigidiyor.com/");
        log.info("Login Succesful");
    }
}
