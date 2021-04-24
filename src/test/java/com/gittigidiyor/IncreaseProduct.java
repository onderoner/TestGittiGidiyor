package com.gittigidiyor;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class IncreaseProduct {

    public void IncreaseNumberOfProduct(WebDriver driver, Logger log) throws InterruptedException {
        //Increase Number Of Product
        Select dropdown = new Select(driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div[1]/form/div/div[2]/div[2]/div[1]/div/div[6]/div[2]/div[2]/div[1]/div[4]/div/div[2]/select")));
        dropdown.selectByIndex(1);

        //Control Increase Number Of Product
        String option = dropdown.getFirstSelectedOption().getText();
        Assert.assertEquals("2", option);

    }
}
