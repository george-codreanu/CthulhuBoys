package com.athena.selenium.tests;

import AutomationFramework.Log4Test;
import AutomationFramework.TestData;
import PageObjects.Frontend.FE_WesternUnionReceive;
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
        FE_WesternUnionReceive WUReceive = new FE_WesternUnionReceive(driver);

        setUp(TestData.FE, "Verify Western union - Receive labels", "WU_01","vn-84-vly","test1234");

        Log4Test.info("Accessing WU receive URL: "+ TestData.ENV + TestData.FE_WU_RECEIVE_URL);
        WUReceive.accessWUreceiveURL(TestData.ENV + TestData.FE_WU_RECEIVE_URL, "WU Receive page");

        Log4Test.info("Assert sub-page title ");
        softAssert.assertEquals(WUReceive.getWUogoText(),TestData.WESTERN_UNION, TestData.WESTERN_UNION + TestData.LABEL_IS_NOT_CORRECT);

        Log4Test.info("Assert Receive Money header box");
        softAssert.assertEquals(WUReceive.getReceiveMoneyLabelText(), TestData.RO_RECEIVE_MONEY, "TestData.RO_RECEIVE_MONEY" + TestData.LABEL_IS_NOT_CORRECT);
        softAssert.assertEquals(WUReceive.getWUogoText(), TestData.WESTERN_UNION, "Primeste Bani - " + TestData.WESTERN_UNION + TestData.LABEL_IS_NOT_CORRECT);
        softAssert.assertEquals(WUReceive.checkWUlogoVisiblity(),true,TestData.WESTERN_UNION + TestData.LOGO_IS_NOT_DISPLAYED);

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
        FE_WesternUnionReceive WUReceive = new FE_WesternUnionReceive(driver);

        setUp(TestData.FE, "Verify Western union - Receive - SUM amount input restrictions", "WU_02","vn-84-vly","test1234");

        Log4Test.info("Accessing WU receive URL: "+ TestData.ENV + TestData.FE_WU_RECEIVE_URL);
        WUReceive.accessWUreceiveURL(TestData.ENV + TestData.FE_WU_RECEIVE_URL, "WU Receive page");
        Assert.assertFalse(WUReceive.verifyValidation(sumOfMoney),"Incorrect input accepted for input: " + sumOfMoney);
    }

    @Test(groups = {TestData.WESTERN_UNION_GROUP})
    public void WU_03_Receive() throws  Exception{
        WebDriver driver = getDriver();
        FE_WesternUnionReceive WUReceive = new FE_WesternUnionReceive(driver);

        setUp(TestData.FE, "Verify that info area is updated when the user inputs data.","WU_03","vn-84-vly","test1234");

        Log4Test.info("Accessing WU receive URL: "+ TestData.ENV + TestData.FE_WU_RECEIVE_URL);
        WUReceive.accessWUreceiveURL(TestData.ENV + TestData.FE_WU_RECEIVE_URL, "WU Receive page");

        Log4Test.info("Selecting a random account");
        WUReceive.selectAccountWithBalance();

        Log4Test.info("Verify that TO account is updated");
        softAssert.assertEquals(WUReceive.getDisplayedAccInfoArea(),WUReceive.getSelectedAccName(),"Account displayed in info area is not correct");
        softAssert.assertEquals(WUReceive.getDisplayedIBANinfoArea(),WUReceive.getselectedAccountIBAN(),"IBAN displayed in info area is not correct");

        Log4Test.info("Verify that the entered amount is updated");
        WUReceive.enterValidAmount();
        softAssert.assertEquals(WUReceive.getSumInfoArea().replaceAll("[^0-9]", ""),WUReceive.getSumFieldAmount().replaceAll("[^0-9]", ""),"Entered amount is not correctly displayed in infoa area");

        Log4Test.info("Verify that entered country is updated");
        WUReceive.selectRandomCountry();
        softAssert.assertEquals(WUReceive.getInfoAreaCountry(),WUReceive.getEnteredCountry(),"Enter country is not displayed correctly");

        Log4Test.info("Verify that MTCN is updated");
        WUReceive.enterMTCN("123456789");
        softAssert.assertEquals(WUReceive.getMTCNinfoAreaLabel(),"Numar de control (MTCN):","MTCN label in info area is not displayed");

        softAssert.assertAll();
    }

    @DataProvider(name ="MTCN inputs")
    public static Object[][] getMTCN() {
        Object MTCNinput[][] = new Object[10][2];
        MTCNinput[0][0] = "1";
        MTCNinput[0][1] = "1";

        MTCNinput[1][0] = "2";
        MTCNinput[1][1] = "12";

        MTCNinput[2][0] = "3";
        MTCNinput[2][1] = "123";

        MTCNinput[3][0] = "4";
        MTCNinput[3][1] = "1234";

        MTCNinput[4][0] = "5";
        MTCNinput[4][1] = "12345";

        MTCNinput[5][0] = "6";
        MTCNinput[5][1] = "123456";

        MTCNinput[6][0] = "7";
        MTCNinput[6][1] = "1234567";

        MTCNinput[7][0] = "8";
        MTCNinput[7][1] = "12345678";

        MTCNinput[8][0] = "9";
        MTCNinput[8][1] = "123456789";

        MTCNinput[9][0] = "10";
        MTCNinput[9][1] = "1234567890";

        return MTCNinput;
    }


    @Test(groups = {TestData.WESTERN_UNION_GROUP}, dataProvider = "MTCN inputs")
    public void WU_04_Receive(String nrChars, String mtcn) throws Exception{
        WebDriver driver = getDriver();
        FE_WesternUnionReceive WUReceive = new FE_WesternUnionReceive(driver);

        setUp(TestData.FE, "Verify that remaining characters at the MTCN field is updated when entering strings","WU_04","vn-84-vly","test1234");

        Log4Test.info("Accessing WU receive URL: "+ TestData.ENV + TestData.FE_WU_RECEIVE_URL);
        WUReceive.accessWUreceiveURL(TestData.ENV + TestData.FE_WU_RECEIVE_URL, "WU Receive page");

        Log4Test.info("Entering a " +nrChars +" chars number in the MTCN field");
        WUReceive.enterMTCN(mtcn);

        Log4Test.info("Verifying nr of chars left label");
        softAssert.assertEquals(WUReceive.getCharsLeft() , nrChars , "MTCN remaining chars label incorrect");

        Log4Test.info("Verifying if error message is displayed");
        softAssert.assertTrue(WUReceive.isMtcnErrorDisplayed(nrChars),"Error message displayed incorrectly");

        softAssert.assertAll();
    }


}



