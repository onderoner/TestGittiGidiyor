package com.gittigidiyor;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import java.util.HashMap;

public class ChooseRandomProduct {
    HashMap<String, String> xPaths = new HashMap<String, String>();

    public void RandomProduct(WebDriver driver, Logger log) throws InterruptedException {

        //There are 48 products on the second page.Therefore, the range is 0-49.
        int min = 0;
        int max = 49;
        log.info("There are 48 products on the second page.Therefore, the range is 0-49.");
        int random = (int)(Math.random()*(max-min+1)+min);
        log.info("Selected item number:"+" "+random);
        xPaths.put("RandomProductClick","/html/body/div[5]/div[1]/div/div[2]/div[3]/div[2]/ul/li["+random+"]/a");
        driver.findElement(By.xpath(xPaths.get("RandomProductClick"))).click();
        Thread.sleep(2000);
    }
}
