package com.gittigidiyor;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;
import static org.junit.Assert.*;

public class MainPageTest extends MainPage {

    @Test
    public void TestCase() throws InterruptedException {

        Login();

        //Searches for the word "bilgisayar" in the searchbar and clicks the search button.
        driver.findElement(By.name("k")).sendKeys("bilgisayar");
        WebElement searchBarClick = driver.findElement(By.xpath("//button[@class='qjixn8-0 sc-1bydi5r-0 hKfdXF']"));
        searchBarClick.click();

        //If you press the "end" key on the keyboard on a page, it goes to the bottom of the page. That's why I scrolled.
        driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL, Keys.END);
        Thread.sleep(2000);

        //After I went down, I did the process of pressing the second page.
        WebElement secondPageClick = driver.findElement(By.cssSelector("ul>li>a[href='/arama/?k=bilgisayar&sf=2']"));
        secondPageClick.click();
        Thread.sleep(3000);

        //2.sayfanın açıldığı kontrol ediliyor.
        String url2 = driver.getCurrentUrl();
        assertEquals("You opened 2nd page unsuccessfully", url2, "https://www.gittigidiyor.com/arama/?k=bilgisayar&sf=2");
        log.info("ikinci syaf açıldı açıldı");

        //There are 48 products on the second page.Therefore, the range is 0-49.
        int min = 0;
        int max = 49;
        log.info("There are 48 products on the second page.Therefore, the range is 0-49.");
        int random = (int)(Math.random()*(max-min+1)+min);
        log.info("Selected item number:"+" "+random);
        WebElement productClick = driver.findElement(By.xpath("/html/body/div[5]/div[1]/div/div[2]/div[3]/div[2]/ul/li["+random+"]/a"));
        productClick.click();
        Thread.sleep(2000);

        //ürün sepete ekleme
        WebElement addProductClick = driver.findElement(By.xpath("//*[@id='add-to-basket']"));
        addProductClick.click();
        Thread.sleep(2000);
        WebElement basketClick = driver.findElement(By.xpath("//*[@id='header_wrapper']/div[4]/div[3]/div/div/div/div[2]/div[4]/div[1]/a"));
        basketClick.click();
        Thread.sleep(2000);
        log.info("sepete eklendi");

        //fiyatları karşılaştırmak için
        String totalPrice = driver.findElement(By.cssSelector("div[class='total-price'] > strong")).getText();
        log.info("Total Price= " + totalPrice);
        String getBasketPrice = driver.findElement(By.cssSelector("p[class='new-price']")).getText();
        log.info("basket price= " + getBasketPrice);
        Assert.assertEquals(totalPrice, getBasketPrice);
        log.info("Fiyatlar eşittir.");

        //ürün adedi arttırma (select)
        Select dropdown = new Select(driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div[1]/form/div/div[2]/div[2]/div[1]/div/div[6]/div[2]/div[2]/div[1]/div[4]/div/div[2]/select")));
        dropdown.selectByIndex(1);

        //sepetteki ürünün 2 olduğu kontrol edilir.
        String option = dropdown.getFirstSelectedOption().getText();
        Assert.assertEquals("2", option);

        Thread.sleep(1000);
        //sepeti boşaltmak için
        WebElement deleteProducts = driver.findElement(By.cssSelector("i[class='gg-icon gg-icon-bin-medium']"));
        deleteProducts.click();

        //sepetin boş olduğu kontrol edilir.
        String actualText = driver.findElement(By.cssSelector("div[class='gg-w-22 gg-d-22 gg-t-21 gg-m-18'] > h2")).getText();
        //Assert.assertEquals("Sepetinizde ürün bulunmamaktadır.", actualText);
        log.info("sepet boşaltılmışltır");
    }
    public void Login () throws InterruptedException{

        //Ana sayfa açıldı mı
        String url = driver.getCurrentUrl();
        assertEquals("You are not in Home Page", url, "https://www.gittigidiyor.com/");
        log.info("Anasayfa açıldı");

        //After pressing the "Login Or Sign Up" button, it goes to the "Member Login Page".
        Thread.sleep(2000);
        WebElement login = driver.findElement(By.cssSelector("div[data-cy='header-user-menu']"));
        login.click();
        Thread.sleep(2000);
        WebElement secondLoginButton = driver.findElement(By.cssSelector("a[data-cy='header-login-button']"));
        secondLoginButton.click();
        Thread.sleep(2000);

        //It places the mail I wrote in the input.
        driver.findElement(By.name("kullanici")).sendKeys("testonder@outlook.com");

        //It places the Password I wrote in the input.
        WebElement password = driver.findElement(By.xpath("//*[@id='L-PasswordField']"));
        password.sendKeys("12345testing");

        //Then click the login button.
        WebElement loginClick = driver.findElement(By.xpath("//*[@id='gg-login-enter']"));
        loginClick.click();
        Thread.sleep(1000);
        String url1 = driver.getCurrentUrl();
        assertEquals("You logged in unsuccessfully", url1, "https://www.gittigidiyor.com/");
        log.info("Login başarılı ");
    }
}
