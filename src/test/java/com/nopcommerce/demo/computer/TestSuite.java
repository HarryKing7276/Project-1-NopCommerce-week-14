package com.nopcommerce.demo.computer;

import com.nopcommerce.demo.pages.ComputerPage;
import com.nopcommerce.demo.pages.TopMenuPage;
import com.nopcommerce.demo.testbase.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TestSuite extends BaseTest {
    /**
     * ● Create the package name computer
     * 1. Create class “TestSuite”
     * Write the following Test:
     * 1.Test name verifyProductArrangeInAlphaBaticalOrder()
     * 1.1 Click on Computer Menu.
     * 1.2 Click on Desktop
     * 1.3 Select Sort By position "Name: Z to A"
     * 1.4 Verify the Product will arrange in Descending order.
     */
    TopMenuPage topMenuPage = new TopMenuPage();
    ComputerPage computerPage = new ComputerPage();
    @Test
    public void verifyProductsArrangeInAlphabeticalOrder() throws InterruptedException {
        //1.1 Click on Computer Menu
        Thread.sleep(2000);
        topMenuPage.selectMenu("Computers");

        //   * 1.2 Click on Desktop
        computerPage.clickOnDesktop();

        //get list before filter the name
        List<WebElement> beforeFilterNameZtoAList = driver.findElements(By.xpath("item-grid"));
        List<Double> beforeFileNameZtoAList = new ArrayList<>();
        for (WebElement nameZtoA : beforeFilterNameZtoAList) {
            beforeFileNameZtoAList.add(Double.valueOf(nameZtoA.getText().replace("$", "")));
        }

        // * 1.3 Select Sort By position "Name: Z to A"
        Thread.sleep(2000);
        computerPage.sortByPosition("Name: Z to A");
//Get list after filter name
        List<WebElement> afterFilterNameZtoAList = driver.findElements(By.xpath("item-grid"));
        List<Double> afterFileNameZtoAList = new ArrayList<>();
        for (WebElement nameZtoA : afterFilterNameZtoAList) {
            afterFileNameZtoAList.add(Double.valueOf(nameZtoA.getText().replace("$", "")));
        }
//1.4 Verify the Product will arrange in Descending order.
        Collections.sort(beforeFileNameZtoAList);
        Assert.assertEquals(beforeFilterNameZtoAList, afterFilterNameZtoAList);
    }

@Test
        public void verifyProductAddedToShoppingCartSuccessfully() throws InterruptedException {

    //2.1 Click on Computer Menu
    Thread.sleep(2000);
    topMenuPage.selectMenu("Computers");

    //   * 2.2 Click on Desktop
    computerPage.clickOnDesktop();
    // * 2.3 Select Sort By position "Name: A to Z"
    Thread.sleep(2000);
    computerPage.sortByPosition("Name: A to Z");

    // 2.4 Click on "Add To Cart"
    Thread.sleep(2000);
    computerPage.addToCart();

    // 2.5 Verify the Text "Build your own computer"

    String expectedText = "Build your own computer";
    String actualText = computerPage.buildYourOwnComputer();
    Assert.assertEquals(actualText, expectedText, "Login page not displayed");

    //2.6 Select "2.2 GHz Intel Pentium Dual-Core E2200" using Select class
    computerPage.selectComputerProcessorFromList("2.2 GHz Intel Pentium Dual-Core E2200");
    // 2.7.Select "8GB [+$60.00]" using Select class.
    computerPage.selectRamLinkFromList("8GB [+$60.00]");
//2.8 Select HDD radio "400 GB [+$100.00]"
    computerPage.clickOnHddRadioLink();
    //2.9 Select OS radio "Vista Premium [+$60.00]"
    computerPage.clickOnVistaPremium();
// 2.10 Check Two Check boxes "Microsoft Office [+$50.00]" and "Total Commander [+$5.00]"
    Thread.sleep(5000);
    computerPage.clickOnMicrosoftOfficeRadioButton();
    computerPage.clickOnTotalCommanderRadioButton();

    //2.11 Verify the price "$1,470.00"
    String actualText1 = computerPage.verifyPriceOfComputer();
    String expectedText1 = "$1470.00";
    Assert.assertEquals (actualText1, expectedText1, "Login page not displayed");

   // 2.12 Click on "ADD TO CARD" Button.
    computerPage.clickOnFinalCartButton();
    //2.13 Verify the Message "The product has been added to your shopping cart" on Top green Bar"
     String actualText2 = computerPage.verifyFinalMessage();
     String expectedText2 = "The product has been added to your shopping cart";
     Assert.assertEquals(actualText2,expectedText2,"Message not verified");
  // After that close the bar clicking on the cross button.
    computerPage.closeClick();
    ////2.14 Then MouseHover on "Shopping cart" and Click on "GO TO CART" button.
    computerPage.shoppingCartTopButton();
    computerPage.goToCartTopButton();
 //2.15 Verify the message "Shopping cart"
    //2.15 Verify the message "Shopping cart"
    String expectedText3 = "Shopping cart";
    String actualText3 = computerPage.verifyShoppingCartText();
    Assert.assertEquals(expectedText3, actualText3);
    Thread.sleep(2000);
//2.16 Change the Qty to "2" and Click on "Update shopping cart"
    computerPage.updateShoppingCart();
//2.17 Verify the Total"$2,950.00
    String actualTotalMessage = computerPage.getTotalText();
    Assert.assertEquals(actualTotalMessage, "$2,950.00", "error");
    Thread.sleep(2000);
    // 2.18 click on checkbox “I agree with the terms of service”
    computerPage.clickOnTermsOfServiceCheckBox();

    // 2.19 Click on “CHECKOUT”
    computerPage.clickOnCheckOutButton();
    Thread.sleep(2000);

    // 2.20 Verify the Text “Welcome, Please Sign In!”
    String actualWelcomeSignInText = computerPage.getWelcomePageSignInText();
    Assert.assertEquals(actualWelcomeSignInText, "Welcome, Please Sign In!", "error");

    //2.21 Click on “CHECKOUT AS GUEST” Tab
    computerPage.clickOnCheckoutAsGuestButton();

//2.22 Fill the all mandatoryfield
    computerPage.inputFirstname("Prime");
    computerPage.inputLastname("Patel");
    computerPage.inputEmail("Prime234Patel@gmail.com");
    computerPage.selectCountry("United Kingdom");
    computerPage.inputCity("London");
    computerPage.inputAddress1("12 Downing street");
    computerPage.inputPostalCode("NW5 6JH");
    computerPage.inputPhoneNumber("12345678");

    //2.23 Click on “CONTINUE”
    computerPage.clickOnContinueButton();

    //2.24 Click on Radio Button “Next Day Air($0.00)”
    computerPage.clickOnNextDayAirRadioButton();

// 2.25 Click on “CONTINUE”
    computerPage.clickOnContinueButton1();

    // 2.26 Select Radio Button “Credit Card”
    computerPage.clickOnCreditCard();
    computerPage.clickOnPaymentContinueButton();

    //2.27 Select “Master card” From Select credit card dropdown
    computerPage.selectCreditCard("Master card");

    //2.28 Fill all the details
    computerPage.inputCardHolderName("Mr Prime Patel");
    computerPage.inputCardNumber("5356 6548 1418 5420");
    computerPage.selectExpireMonth("12");
    computerPage.selectExpireYear("2028");
    computerPage.inputCardCode("598");

    // 2.29 Click on “CONTINUE”
    computerPage.clickOnContinueButton2();

    //2.30 Verify “Payment Method” is “Credit Card”
    String actualCardMessage = computerPage.getCreditCardText();
    Assert.assertEquals(actualCardMessage, "Credit Card", "error");
// 2.32 Verify “Shipping Method” is “Next Day Air”
    String actualShippingMessage = computerPage.getNextDayAirText();
    Assert.assertEquals(actualShippingMessage, "Next Day Air", "error");

    //2.33 Verify Total is “$2,950.00”
    String actualTotalAmountMessage = computerPage.getTotalAmountText();
    Assert.assertEquals(actualTotalMessage, "$2,950.00", "error");

    //2.34 Click on “CONFIRM”
    computerPage.clickOnConfirmButton();

    //2.35 Verify the Text “Thank You”
    String actualThankYouText = computerPage.getThankYouText();
    Assert.assertEquals(actualThankYouText, "Thank you", "error");
    // 2.36 Verify the message “Your order has been successfully processed!”
    String actualOrderSuccessText = computerPage.getOrderSuccessProcessText();
    Assert.assertEquals(actualOrderSuccessText, "Your order has been successfully processed!", "error");

    // 2.37 Click on “CONTINUE”
    computerPage.clickOnContinueButton3();

    // 2.38 Verify the text “Welcome to our store”
    String actualWelcomeStoreText = computerPage.getWelcomeOurStoreText();
    Assert.assertEquals(actualWelcomeStoreText, "Welcome to our store", "error");

}


}
