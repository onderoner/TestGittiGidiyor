package com.gittigidiyor;

import org.junit.Test;



public class MainPageTest {

    MainPage mainPage = new MainPage();
    Login loginClass = new Login();
    AddItemsToBasket addItemsToBasket = new AddItemsToBasket();
    SecondPageOperations secondPageOperations = new SecondPageOperations();

    BasketOperations basketOperations = new BasketOperations();



    @Test
    public void runTest() throws InterruptedException {
        mainPage.OpenBrowser();
        loginClass.Login(mainPage.driver,mainPage.log);
        loginClass.SearchComputer(mainPage.driver);
        secondPageOperations.SecondPage(mainPage.driver,mainPage.log);
        secondPageOperations.RandomProduct(mainPage.driver,mainPage.log);
        addItemsToBasket.AddBasket(mainPage.driver,mainPage.log);
        basketOperations.Price(mainPage.driver,mainPage.log);
        basketOperations.IncreaseNumberOfProduct(mainPage.driver,mainPage.log);
        basketOperations.RemoveProduct(mainPage.driver,mainPage.log);
        mainPage.CloseBrowser();

    }

}
