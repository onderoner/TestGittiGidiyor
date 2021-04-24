package com.gittigidiyor;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import java.util.HashMap;

public class RemoveProductFromBasket {
    HashMap<String, String> xPaths = new HashMap<String, String>();
    HashMap<String, String> cssSelector = new HashMap<String, String>();

    public void RemoveProduct(WebDriver driver, Logger log) throws InterruptedException {

        Thread.sleep(1000);
        //RemoveProduct
        cssSelector.put("Remove","i[class='gg-icon gg-icon-bin-medium']");
        driver.findElement(By.cssSelector(cssSelector.get("Remove"))).click();
        Thread.sleep(2000);

        //Control RemoveProduct
        String actualText = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div[1]/form/div/div[2]/div[3]/div/div[1]/div/div[1]/h2")).getText();
        if(actualText.contains("Sipariş Özeti")){
            Assert.assertEquals("AppOkay", "AppCrashed");

        }else{
            Assert.assertEquals("AppOkay", "AppOkay");

        }
        log.info("basket is emptied");
    }
}
