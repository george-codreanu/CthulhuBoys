package PageObjects.Frontend;

import AutomationFramework.CommonTask;
import PageObjects.MainPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

/**
 * Created by dbrosteanu on 9/19/2017.
 */
public class FE_WesternUnionReceive extends MainPage {

    public FE_WesternUnionReceive(WebDriver passedDriver) {
        super(passedDriver);
    }

    @FindBy(css = "#btn-append-to-single-button > strong")
    private WebElement firstCurrencyFirstField;

    @FindBy(css = "#btn-append-to-single-button > small")
    private WebElement firstCurrencySecondField;

    @FindBy(css = "li > strong")
    private WebElement secondCurrencyFirstField;

    @FindBy(css = "li > small")
    private WebElement secondCurrencySecondField;

    @FindBy(css = "h2.payments--title")
    private WebElement WUlabel;

    @FindBy(css ="div.westernUnion-head > p > strong")
    private WebElement receiveMoneyLabel;

    @FindBy(css = "div.westernUnion-head > p > small")
    private WebElement receiveMoneyWUlabel;

    @FindBy(css = "div.westernUnion-logo")
    private WebElement WUlogo;

    @FindBy(css = "ui-raiffeisen-account-selection-ng > label.payments--label")
    private WebElement inLabel;

    @FindBy(css = "div.payments-from.payments-fromEmpty > p")
    private WebElement chooseAccString;

    @FindBy(css = "[name=\"form\"] > div:nth-of-type(1) > label.payments--label")
    private WebElement sumLabel;

    @FindBy(css = "[name=\"form\"] > div:nth-of-type(2) > label.payments--label")
    private WebElement currencyLabel;

    @FindBy(css = "label.payments--label.fleft")
    private WebElement mtcnLabel;


    @FindBy(xpath = "//*[@id=\"main\"]/div[3]/div/div/div[2]/div/div[1]/div/div[3]/div/div/div/div/ui-raiffeisen-western-union-ng/div/div[2]/div/div/div/ui-raiffeisen-western-union-details-ng/div[2]/ui-raiffeisen-payments-input-description-ng/form/div/div[2]/div/div/label")
    private WebElement mtcnField;

    @FindBy(css = "div.accountsList-icon.western-union.tooltip.westernUnion-tooltip")
    private WebElement tooltipButton;

    @FindBy(css = "div.tooltiptext")
    private WebElement infoTooltipText;

    @FindBy(css = "div.payments-search.payments-typeahead > label.payments--label")
    private WebElement countryLabel;

    @FindBy(css = "div.payments-typeaheadSearch--label > p > strong")
    private WebElement countryFieldFirstLabel;

    @FindBy(css = "div.payments-typeaheadSearch--label > p > small")
    private WebElement countryFieldSecondLabel;

    @FindBy(css = "u")
    private WebElement cancelButton;

    @FindBy(css = "a.payments-action--later")
    private WebElement TCButton;

    @FindBy(css = "button.button")
    private WebElement ReceiveButton;


    //-------------------------------------- Methods
    public void accessWUreceiveURL (String URL, String URLname){
        CommonTask.accessDirectLink(driver,URL,WUlabel,URLname);
    }

    public String getWUogoText(){
        return CommonTask.getText(WUlabel,"WU label");}

    public String getReceiveMoneyLabelText(){
        return CommonTask.getText(receiveMoneyLabel, "Receive money label");
    }

    public boolean checkWUlogoVisiblity() {
        return CommonTask.isElementEnabledAndDisplayed(WUlogo,"WU Logo");
    }

    public String getInText(){return CommonTask.getText(inLabel,"'In' label");}

    public String getChooseAccText(){
        return CommonTask.getText(chooseAccString,"Choose account string");
    }

    public String getSumText(){
        return CommonTask.getText(sumLabel,"Sum label");
    }

    public String getCurrencyText(){
        return CommonTask.getText(currencyLabel, "Currency label");
    }

    public String getMTCNLabeltext(){
        return CommonTask.getText(mtcnLabel,"MTCN label");
    }

    public String getFirstCurrency(){
        CommonTask.clickElement(driver,firstCurrencyFirstField, "Currency dropdown");
        String value = CommonTask.getText(firstCurrencyFirstField,"RON currency main label") +" "+
                       CommonTask.getText(firstCurrencySecondField,"RON currency second label");
        return value;
    }

    public String getSecondCurrency(){
        String value = CommonTask.getText(secondCurrencyFirstField, "EUR currency main label") + " " +
                       CommonTask.getText(secondCurrencySecondField,"EUR currency second label");
        CommonTask.clickElement(driver,firstCurrencyFirstField, "Currency dropdown");
        return value;
    }

    public String getInfoTooltipText(){
        Actions action = new Actions(driver);
        action.moveToElement(tooltipButton).build().perform();
        return CommonTask.getText(infoTooltipText,"Info tooltip text");
    }
    public String getMTCNFieldText(){
        return CommonTask.getText(mtcnField,"MTCN Field");
    }

    public String getCountryLabelText(){
        return CommonTask.getText(countryLabel,"Country label");
    }
    public String getCountryFieldText(){
        return CommonTask.getText(countryFieldFirstLabel,"Country field first row") + "\n" +
               CommonTask.getText(countryFieldSecondLabel,"Country field second row");

    }

}
