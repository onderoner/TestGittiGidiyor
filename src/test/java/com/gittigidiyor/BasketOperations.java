package com.gittigidiyor;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.HashMap;

public class BasketOperations {
    HashMap<String, String> xPaths = new HashMap<String, String>();
    HashMap<String, String> cssSelector = new HashMap<String, String>();
    public void Price(WebDriver driver, Logger log) throws InterruptedException {
        //Compare Price
        String totalPrice = driver.findElement(By.cssSelector("div[class='total-price'] > strong")).getText();
        log.info("Total Price= " + totalPrice);
        String getBasketPrice = driver.findElement(By.cssSelector("p[class='new-price']")).getText();
        log.info("basket price= " + getBasketPrice);
        Assert.assertEquals(totalPrice, getBasketPrice);
        log.info("Prices are equal.");
    }
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
    public void IncreaseNumberOfProduct(WebDriver driver, Logger log) throws InterruptedException {
        //Increase Number Of Product
        Select dropdown = new Select(driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div[1]/form/div/div[2]/div[2]/div[1]/div/div[6]/div[2]/div[2]/div[1]/div[4]/div/div[2]/select")));
        dropdown.selectByIndex(1);

        //Control Increase Number Of Product
        String option = dropdown.getFirstSelectedOption().getText();
        Assert.assertEquals("2", option);

    }
}
