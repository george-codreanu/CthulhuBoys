package com.athena.selenium.tests;

import AutomationFramework.Log4Test;
import AutomationFramework.TestData;
import PageObjects.Frontend.FE_WesternUnionReceive;
import com.athena.selenium.DriverBase;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
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
        softAssert.assertEquals(WUReceive.getReceiveMoneyLabelText(), "Primeste bani", "'Primeste bani'" + TestData.LABEL_IS_NOT_CORRECT);
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
        Assert.assertEquals(WUReceive.getMTCNFieldText(),TestData.RO_MTCN_FIELD, "MTCN FIELD" + TestData.LABEL_IS_NOT_CORRECT);

        Log4Test.info("Assert Country labels");
        softAssert.assertEquals(WUReceive.getCountryLabelText(),TestData.RO_COUNTRY_LABEL, "Country " + TestData.LABEL_IS_NOT_CORRECT);
        softAssert.assertEquals(WUReceive.getCountryFieldText(), TestData.RO_COUNTRY_FIELD, "Country field" + TestData.LABEL_IS_NOT_CORRECT);

        Log4Test.info("Assert button labels");

        softAssert.assertAll();
    }
}



