package com.gittigidiyor;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import java.util.HashMap;

public class AddItemsToBasket {

    HashMap<String, String> xPaths = new HashMap<String, String>();

    public void AddBasket(WebDriver driver, Logger log) throws InterruptedException {

        //Adding the product to the basket.
        xPaths.put("FirsClickBasket","//*[@id='add-to-basket']");
        driver.findElement(By.xpath(xPaths.get("FirsClickBasket"))).click();
        Thread.sleep(2000);
        xPaths.put("SecondClickBasket","//*[@id='header_wrapper']/div[4]/div[3]/div/div/div/div[2]/div[4]/div[1]/a");
        driver.findElement(By.xpath(xPaths.get("SecondClickBasket"))).click();
        Thread.sleep(2000);
        log.info("Aded to Basket");
    }
}
