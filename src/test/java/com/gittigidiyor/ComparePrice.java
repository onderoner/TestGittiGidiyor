package com.gittigidiyor;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import java.util.HashMap;

public class ComparePrice {
    public void Price(WebDriver driver, Logger log) throws InterruptedException {
        //Compare Price
        String totalPrice = driver.findElement(By.cssSelector("div[class='total-price'] > strong")).getText();
        log.info("Total Price= " + totalPrice);
        String getBasketPrice = driver.findElement(By.cssSelector("p[class='new-price']")).getText();
        log.info("basket price= " + getBasketPrice);
        Assert.assertEquals(totalPrice, getBasketPrice);
        log.info("Prices are equal.");
    }
}
