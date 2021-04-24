package com.gittigidiyor;

import org.junit.Test;



public class MainPageTest {

    MainPage mainPage = new MainPage();
    Login loginClass = new Login();
    AddItemsToBasket addItemsToBasket = new AddItemsToBasket();
    SearchProduct searchProduct = new SearchProduct();
    SecondPageProcess secondPageProcess = new SecondPageProcess();
    ChooseRandomProduct chooseRandomProduct = new ChooseRandomProduct();
    ComparePrice comparePrice = new ComparePrice();
    IncreaseProduct increaseProduct = new IncreaseProduct();
    RemoveProductFromBasket removeProductFromBasket = new RemoveProductFromBasket();

    @Test
    public void runTest() throws InterruptedException {
        mainPage.OpenBrowser();
        loginClass.Login(mainPage.driver,mainPage.log);
        searchProduct.SearchComputer(mainPage.driver);
        secondPageProcess.SecondPage(mainPage.driver,mainPage.log);
        chooseRandomProduct.RandomProduct(mainPage.driver,mainPage.log);
        addItemsToBasket.AddBasket(mainPage.driver,mainPage.log);
        comparePrice.Price(mainPage.driver,mainPage.log);
        increaseProduct.IncreaseNumberOfProduct(mainPage.driver,mainPage.log);
        removeProductFromBasket.RemoveProduct(mainPage.driver,mainPage.log);
        mainPage.CloseBrowser();

    }

}
