package PageObjects.Frontend;

import PageObjects.MainPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FE_Transaction_List extends MainPage {


    public FE_Transaction_List(WebDriver passedDriver) {
        super(passedDriver);
    }









    public void accessAccountHistory(String accountName){

        System.out.println(driver.findElement(By.cssSelector("div.accountsList-group.ui-sortable > div:nth-of-type(1) > ui-raiffeisen-account-tile > div.accountItem-container > div.accountItem-name")).getAttribute("xpath"));

    }
}

//*[@id="main"]/div[3]/div/div/div[2]/div/div[1]/div[2]/div[3]/div/div/div/div/div/div[1]/ui-raiffeisen-account-tile/div/div[2]/div[2]