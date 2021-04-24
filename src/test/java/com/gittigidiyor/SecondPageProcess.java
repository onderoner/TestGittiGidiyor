package com.gittigidiyor;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.HashMap;

import static org.junit.Assert.assertEquals;

public class SecondPageProcess {
    HashMap<String, String> xPaths = new HashMap<String, String>();
    HashMap<String, String> cssSelector = new HashMap<String, String>();
    HashMap<String, String> Byname = new HashMap<String, String>();

    public void SecondPage(WebDriver driver, Logger log) throws InterruptedException {

        //If you press the "end" key on the keyboard on a page, it goes to the bottom of the page. That's why I scrolled.
        cssSelector.put("scroll","body");
        driver.findElement(By.cssSelector(cssSelector.get("scroll"))).sendKeys(Keys.CONTROL, Keys.END);
        Thread.sleep(2000);

        //After I went down, I did the process of pressing the second page.
        cssSelector.put("SecondPage","ul>li>a[href='/arama/?k=bilgisayar&sf=2']");
        driver.findElement(By.cssSelector(cssSelector.get("SecondPage"))).click();
        Thread.sleep(3000);

        //Control SecondPage
        String url2 = driver.getCurrentUrl();
        assertEquals("You opened 2nd page unsuccessfully", url2, "https://www.gittigidiyor.com/arama/?k=bilgisayar&sf=2");
        log.info("second page opened");


    }
}
