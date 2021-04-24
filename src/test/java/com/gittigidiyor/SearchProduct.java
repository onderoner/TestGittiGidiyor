package com.gittigidiyor;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import java.util.HashMap;

public class SearchProduct {

    HashMap<String, String> xPaths = new HashMap<String, String>();
    HashMap<String, String> Byname = new HashMap<String, String>();

    public void SearchComputer(WebDriver driver) throws InterruptedException {
        //Searches for the word "bilgisayar" in the searchbar and clicks the search button.
        Byname.put("Searchbilgisayar","k");
        driver.findElement(By.name(Byname.get("Searchbilgisayar"))).sendKeys("bilgisayar");

        xPaths.put("SearchButtonClick","//button[@class='qjixn8-0 sc-1bydi5r-0 hKfdXF']");
        driver.findElement(By.xpath(xPaths.get("SearchButtonClick"))).click();

    }
}
