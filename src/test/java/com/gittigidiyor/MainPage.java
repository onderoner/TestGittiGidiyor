package com.gittigidiyor;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.sql.Time;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.junit.Before;


public class MainPage {
    WebDriver driver;

    static Logger log  = Logger.getLogger(MainPage.class);
    @Before
    public void OpenBrowser() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/driver/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        //chrome size büyütme
        options.addArguments("start-maximized");
        driver = new ChromeDriver(options);
        log.info("Driver başlatıldı");
        driver.get("https://www.gittigidiyor.com");
        TimeUnit.SECONDS.sleep(2);
        WebElement cookiesAndPolicies = driver.findElement(By.cssSelector("a[class='tyj39b-3 fEwnjq']"));
        cookiesAndPolicies.click();

    }
    @After
    public void CloseBrowser(){
        driver.quit();
        log.info("Driver kapatıldı");
    }
}