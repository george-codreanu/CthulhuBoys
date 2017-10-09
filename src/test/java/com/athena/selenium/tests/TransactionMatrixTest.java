package com.athena.selenium.tests;

import AutomationFramework.TestData;
import PageObjects.Frontend.FE_Transaction_List;
import com.athena.selenium.DriverBase;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TransactionMatrixTest extends DriverBase {



    @Test(groups = {TestData.WESTERN_UNION_GROUP})
    public void TransactionMatrix_GRN() throws Exception {

        WebDriver driver = getDriver();
        FE_Transaction_List FE_TranList = new FE_Transaction_List(driver);
        setUp(TestData.FE, "TransactionMatrix_GRN", "Verify SWF type transactions", TestData.VN_84_VLY, TestData.USER_PASS);
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        FE_TranList.accessAccountHistory("RO14 RZBR 0000 0600 1805 9989");



    }


}
//*[@id="main"]/div[3]/div/div/div[2]/div/div[1]/div[2]/div[3]/div/div/div/div/div/div[1]/ui-raiffeisen-account-tile/div/div[2]/div[2]
//*[@id="main"]/div[3]/div/div/div[2]/div/div[1]/div[2]/div[3]/div/div/div/div/div/div[3]/ui-raiffeisen-account-tile/div/div[2]/div[2]
//*[@id="main"]/div[3]/div/div/div[2]/div/div[1]/div[2]/div[3]/div/div/div/div/div/div[8]/ui-raiffeisen-account-tile/div/div[2]/div[2]
//*[@id="main"]/div[3]/div/div/div[2]/div/div[1]/div[2]/div[3]/div/div/div/div/div/div[26]/ui-raiffeisen-account-tile/div/div[2]/div[2]


//*[@id="main"]/div[3]/div/div/div[2]/div/div[1]/div[2]/div[3]/div/div/div/div/div/div[26]/ui-raiffeisen-account-tile/div/div[4]/div[1]/a
//*[@id="main"]/div[3]/div/div/div[2]/div/div[1]/div[2]/div[3]/div/div/div/div/div/div[26]/ui-raiffeisen-account-tile/div/div[4]/div[1]/a