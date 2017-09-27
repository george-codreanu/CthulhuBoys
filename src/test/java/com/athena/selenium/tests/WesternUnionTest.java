package com.athena.selenium.tests;

import AutomationFramework.Log4Test;
import AutomationFramework.TestData;
import PageObjects.Frontend.FE_WesternUnionReceive_Confirm;
import PageObjects.Frontend.FE_WesternUnionReceive_Input;
import com.athena.selenium.DriverBase;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * Created by dbrosteanu on 9/19/2017.
 */
public class WesternUnionTest extends DriverBase{

    @Test(groups = {TestData.WESTERN_UNION_GROUP})
    public void WU_01_Receive_RO() throws Exception {

        WebDriver driver = getDriver();
        FE_WesternUnionReceive_Input WUReceive = new FE_WesternUnionReceive_Input(driver);

        setUp(TestData.FE, "WU_01", "Verify Western union - Receive labels" ,TestData.VN_84_VLY, TestData.USER_PASS);

        Log4Test.info("Accessing WU receive URL: "+ TestData.ENV + TestData.FE_WU_RECEIVE_URL);
        WUReceive.accessWUreceiveURL(TestData.ENV + TestData.FE_WU_RECEIVE_URL, "WU Receive page");

        Log4Test.info("Assert sub-page title ");
        softAssert.assertEquals(WUReceive.getWUogoText(),TestData.WESTERN_UNION, TestData.WESTERN_UNION + TestData.LABEL_IS_NOT_CORRECT);

        Log4Test.info("Assert Receive Money header box");
        softAssert.assertEquals(WUReceive.getReceiveMoneyLabelText(), TestData.RO_RECEIVE_MONEY, "TestData.RO_RECEIVE_MONEY" + TestData.LABEL_IS_NOT_CORRECT);
        softAssert.assertEquals(WUReceive.getWUogoText(), TestData.WESTERN_UNION, "Primeste Bani - " + TestData.WESTERN_UNION + TestData.LABEL_IS_NOT_CORRECT);
        softAssert.assertEquals(WUReceive.checkWUlogoVisiblity(), true, TestData.WESTERN_UNION + TestData.LOGO_IS_NOT_DISPLAYED);

        Log4Test.info("Assert 'In which account' area");
        softAssert.assertEquals(WUReceive.getInText(),"In", "'In' label" + TestData.LABEL_IS_NOT_CORRECT);
        softAssert.assertEquals(WUReceive.getChooseAccText(), "Alege contul din care vrei sa transferi", "Choose account" + TestData.LABEL_IS_NOT_CORRECT);

        Log4Test.info("Assert Sum and currency fields");
        softAssert.assertEquals(WUReceive.getSumText(),"SUMA", "Sum" + TestData.LABEL_IS_NOT_CORRECT);
        softAssert.assertEquals(WUReceive.getCurrencyText(),"MONEDA","Currency" + TestData.LABEL_IS_NOT_CORRECT);

        Log4Test.info("Assert currencies");
        softAssert.assertEquals(WUReceive.getFirstCurrency(),"RON RON", "First currency fields" + TestData.LABEL_IS_NOT_CORRECT);
        softAssert.assertEquals(WUReceive.getSecondCurrency(), "EUR moneda", "Second currency fields" + TestData.LABEL_IS_NOT_CORRECT);

        Log4Test.info("Assert tooltip text");
        softAssert.assertEquals(WUReceive.getInfoTooltipText(),TestData.RO_WU_TOOLTIP_TEXT, "Tooltip" + TestData.LABEL_IS_NOT_CORRECT);

        Log4Test.info("Assert MTCN labels");
        softAssert.assertEquals(WUReceive.getMTCNLabeltext(),TestData.RO_MTCN_LABEL,"MTCN" + TestData.LABEL_IS_NOT_CORRECT);
        softAssert.assertEquals(WUReceive.getMTCNFieldText(),TestData.RO_MTCN_FIELD, "MTCN FIELD" + TestData.LABEL_IS_NOT_CORRECT);

        Log4Test.info("Assert remaining characters available - MTCN field");
        softAssert.assertEquals(WUReceive.getRemainingCharsLabel(),"10 caractere disponibile", "MTCN characters left" + TestData.LABEL_IS_NOT_CORRECT);

        Log4Test.info("Assert Country labels");
        softAssert.assertEquals(WUReceive.getCountryLabelText(),TestData.RO_COUNTRY_LABEL, "Country " + TestData.LABEL_IS_NOT_CORRECT);
        softAssert.assertEquals(WUReceive.getCountryFieldText(), TestData.RO_COUNTRY_FIELD, "Country field" + TestData.LABEL_IS_NOT_CORRECT);

        Log4Test.info("Assert button labels");
        softAssert.assertEquals(WUReceive.getCancelButtonText(),"Anuleaza", "Cancel button" + TestData.LABEL_IS_NOT_CORRECT);
        softAssert.assertEquals(WUReceive.getReceiveButtonText(),"Primeste", "Receive button" + TestData.LABEL_IS_NOT_CORRECT);
        softAssert.assertEquals(WUReceive.getTCButtonText(),TestData.RO_TC, "T&C button" + TestData.LABEL_IS_NOT_CORRECT);

        Log4Test.info("Assert 'From and to' area labels");
        softAssert.assertEquals(WUReceive.getWillReceiveText(), "Urmeaza sa primesti","'Will receive'" + TestData.LABEL_IS_NOT_CORRECT);
        softAssert.assertEquals(WUReceive.getFromAccText(),"Din contul:","From account" + TestData.LABEL_IS_NOT_CORRECT);
        softAssert.assertEquals(WUReceive.getFromAccFields(),TestData.WESTERN_UNION + "\n" + TestData.RO_RECEIVE_MONEY ,"From account field");
        softAssert.assertEquals(WUReceive.getToAccText(),"Catre:","'To'"+TestData.LABEL_IS_NOT_CORRECT);

        Log4Test.info("Assert error messages");
        WUReceive.clickReceive();
        softAssert.assertEquals(WUReceive.getFirstErrorMessage(),TestData.RO_WU_ERROR_MESSAGE, "First error message" + TestData.LABEL_IS_NOT_CORRECT);
        softAssert.assertEquals(WUReceive.getSecondErrorMessage(),TestData.RO_WU_ERROR_MESSAGE, "Second error message" + TestData.LABEL_IS_NOT_CORRECT);
        softAssert.assertEquals(WUReceive.getThirdErrorMessage(),TestData.RO_WU_ERROR_MESSAGE, "Third error message" + TestData.LABEL_IS_NOT_CORRECT);


        Log4Test.info("Asserting 'To Country' label - info area");
        WUReceive.selectRandomCountry();
        softAssert.assertEquals(WUReceive.getToCountry(),"Tara expediere:","'To country'" + TestData.LABEL_IS_NOT_CORRECT);

        WUReceive.setAmmount("10");

        Log4Test.info("Verify that MTCN is updated");
        WUReceive.enterMTCN("1234567890");
        softAssert.assertEquals(WUReceive.getMTCNinfoAreaLabel(),"Numar de control (MTCN):","MTCN label in info area is not displayed");




        softAssert.assertAll();
    }

    @DataProvider(name ="sum of money inputs")
    public static Object[][] getData() {
        Object sumOfMoney[][] = new Object[8][1];
        sumOfMoney[0][0] = "00000000";
        sumOfMoney[1][0] = "text";
        sumOfMoney[2][0] = "1000";
        sumOfMoney[3][0] = "0.1234";
        sumOfMoney[4][0] = "0,1234";
        sumOfMoney[5][0] = "1234567890123456789012345678901234567890";
        sumOfMoney[6][0] = "$@#$@#%^";
        sumOfMoney[7][0] = "312dsa";

        return sumOfMoney;
    }

    @Test(groups = {TestData.WESTERN_UNION_GROUP}, dataProvider = "sum of money inputs")
    public void WU_02_Receive(String sumOfMoney) throws Exception {

        WebDriver driver = getDriver();
        FE_WesternUnionReceive_Input WUReceive = new FE_WesternUnionReceive_Input(driver);

        setUp(TestData.FE, "WU_02", "Verify Western union - Receive - SUM amount input restrictions", TestData.VN_84_VLY, TestData.USER_PASS);

        Log4Test.info("Accessing WU receive URL: "+ TestData.ENV + TestData.FE_WU_RECEIVE_URL);
        WUReceive.accessWUreceiveURL(TestData.ENV + TestData.FE_WU_RECEIVE_URL, "WU Receive page");
        Assert.assertFalse(WUReceive.verifyValidation(sumOfMoney),"Incorrect input accepted for input: " + sumOfMoney);
    }

    @Test(groups = {TestData.WESTERN_UNION_GROUP})
    public void WU_03_Receive() throws  Exception{
        WebDriver driver = getDriver();
        FE_WesternUnionReceive_Input WUReceive = new FE_WesternUnionReceive_Input(driver);

        setUp(TestData.FE, "WU_03", "Verify that info area is updated when the user inputs data.", TestData.VN_84_VLY, TestData.USER_PASS);

        Log4Test.info("Accessing WU receive URL: "+ TestData.ENV + TestData.FE_WU_RECEIVE_URL);
        WUReceive.accessWUreceiveURL(TestData.ENV + TestData.FE_WU_RECEIVE_URL, "WU Receive page");

        Log4Test.info("Selecting a random account");
        WUReceive.selectAccountWithBalance();

        Log4Test.info("Verify that TO account is updated");
        softAssert.assertEquals(WUReceive.getDisplayedAccInfoArea(),WUReceive.getSelectedAccName(),"Account displayed in info area is not correct");
        softAssert.assertEquals(WUReceive.getDisplayedIBANinfoArea(),WUReceive.getSelectedAccountIBAN(),"IBAN displayed in info area is not correct");

        Log4Test.info("Verify that the entered amount is updated");
        WUReceive.enterValidAmount();
        softAssert.assertEquals(WUReceive.getSumInfoArea(), WUReceive.getSumFieldAmount(),"Entered amount is not correctly displayed in infoa area");

        Log4Test.info("Verify that entered country is updated");
        WUReceive.selectRandomCountry();
        softAssert.assertEquals(WUReceive.getInfoAreaCountry(), WUReceive.getEnteredCountry(),"Enter country is not displayed correctly");

        softAssert.assertAll();
    }


    @Test(groups = {TestData.WESTERN_UNION_GROUP})
    public void WU_04_Receive() throws Exception{
        WebDriver driver = getDriver();
        FE_WesternUnionReceive_Input WUReceive = new FE_WesternUnionReceive_Input(driver);

        setUp(TestData.FE, "WU_04", "Verify that remaining characters at the MTCN field is updated when entering strings", TestData.VN_84_VLY, TestData.USER_PASS);

        Log4Test.info("Accessing WU receive URL: "+ TestData.ENV + TestData.FE_WU_RECEIVE_URL);
        WUReceive.accessWUreceiveURL(TestData.ENV + TestData.FE_WU_RECEIVE_URL, "WU Receive page");

        Assert.assertTrue(WUReceive.isMTCNCounterWorking(10), "Counter is broken");
    }



    @Test(groups = {TestData.WESTERN_UNION_GROUP})
    public void WU_05_Receive_RO() throws Exception{

        WebDriver driver = getDriver();
        FE_WesternUnionReceive_Input WUReceive_Input = new FE_WesternUnionReceive_Input(driver);
        FE_WesternUnionReceive_Confirm WUReceive_Confirm = new FE_WesternUnionReceive_Confirm(driver);

        setUp(TestData.FE, "WU_05","Verify confirmation page labels",TestData.VN_84_VLY,TestData.USER_PASS);

        Log4Test.info("Filling form in order to proceed to confirmation page");
        WUReceive_Input.accessWUreceiveURL(TestData.ENV + TestData.FE_WU_RECEIVE_URL, "WU Receive page");
        WUReceive_Input.completeFormWithValidInput("1234567890", "Germania");
        WUReceive_Input.clickReceive();

        Log4Test.info("Assert WU logo and label");
        softAssert.assertTrue(WUReceive_Confirm.isWUlogoDisplayed(),"WU Logo not displayed");

        softAssert.assertAll();

    }




}



