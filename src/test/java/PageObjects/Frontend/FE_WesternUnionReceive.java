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

    @FindBy(css = "label[class='payments-descriptionInputLabel ng-binding ng-scope']")
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
    private WebElement termsCondButton;

    @FindBy(css = "button.button")
    private WebElement receiveButton;

    @FindBy(css = "div.payments-field.payments-error > p.payments-error-label.cf > span")
    private WebElement firstErrorMessage;

    @FindBy(css = "div.payments-descriptionInput.cf > p.payments-error-label.cf > span")
    private WebElement secondErrorMessage;

    @FindBy(css = "div.payments-search.payments-typeahead > p.payments-error-label.cf > span")
    private WebElement thirdErrorMessage;

    @FindBy(css = "h3")
    private WebElement willReceiveLabel;

    @FindBy(css = "ul > li:nth-of-type(1) > label")
    private WebElement fromAccountLabel;

    @FindBy(css = "ul > li:nth-of-type(1) > p > strong" )
    private WebElement fromAccountFirstField;

    @FindBy(css = "ul > li:nth-of-type(1) > p > span")
    private WebElement fromAccountSecondField;

    @FindBy(css = "ul > li:nth-of-type(2) > label")
    private WebElement toAccountLabel;

    @FindBy(css = "[name=\"amount\"]")
    private WebElement sumField;




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
    public String getTCButtonText(){
        return CommonTask.getText(termsCondButton,"T&C button");
    }
    public String getReceiveButtonText(){
        return CommonTask.getText(receiveButton,"Receive button");
    }
    public String getCancelButtonText(){
        return CommonTask.getText(cancelButton,"Cancel button");
    }

    public String getFirstErrorMessage(){
        return CommonTask.getText(firstErrorMessage,"First error message field");
    }

    public String getSecondErrorMessage(){
        return CommonTask.getText(secondErrorMessage,"Seccond error message");
    }

    public void clickReceive(){
        receiveButton.click();
    }

    public String getThirdErrorMessage(){
        return CommonTask.getText(thirdErrorMessage,"Third error message");
    }

    public String getWillReceiveText(){
        return CommonTask.getText(willReceiveLabel, "'Will receive' label");
    }

    public String getFromAccText(){
        return CommonTask.getText(fromAccountLabel,"'From account' label");
    }

    public String getFromAccFields(){
        return CommonTask.getText(fromAccountFirstField,"First 'From account' field") + "\n" +
               CommonTask.getText(fromAccountSecondField,"Second 'From account' field");
    }

    public String getToAccText(){
        return CommonTask.getText(toAccountLabel,"'To account' label");
    }

    public boolean verifyValidation(String input){
        CommonTask.sendKeys(driver,sumField,input,"Sum field");
        CommonTask.clickElement(driver,infoTooltipText,"Tooltip button");

        return CommonTask.getText(sumField,"Sum field").equals(input);

    }
}
