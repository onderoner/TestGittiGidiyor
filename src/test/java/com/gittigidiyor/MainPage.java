package com.gittigidiyor;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.util.concurrent.TimeUnit;

public class MainPage {
    public static WebDriver driver;
    public static Logger log  = Logger.getLogger(MainPage.class);

    public static void main(String[] args) {
    }

    @Before
    public  void OpenBrowser() throws InterruptedException {
        //Chrome Process
        System.setProperty("webdriver.chrome.driver", "src/test/resources/driver/chromedriver.exe");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("start-maximized");
        driver = new ChromeDriver(chromeOptions);
        log.info("Driver started");
        driver.get("https://www.gittigidiyor.com");
        TimeUnit.SECONDS.sleep(2);

        //Cookies Process
        WebElement cookiesAndPolicies = driver.findElement(By.cssSelector("a[class='tyj39b-3 fEwnjq']"));
        cookiesAndPolicies.click();
    }
    @After
    public void CloseBrowser(){
        driver.quit();
        log.info("Driver Shut Down");
    }
}