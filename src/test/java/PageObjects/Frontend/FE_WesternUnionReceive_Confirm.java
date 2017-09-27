package PageObjects.Frontend;

import AutomationFramework.CommonTask;
import PageObjects.MainPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FE_WesternUnionReceive_Confirm extends MainPage {

    public FE_WesternUnionReceive_Confirm(WebDriver passedDriver) {
        super(passedDriver);
    }

    @FindBy(css = ".westernUnion-info > div:nth-child(1) > div:nth-child(1)")
    private WebElement WULogo;

    @FindBy(css = "div.westernUnion-info > p > strong")
    private WebElement WULabel;

    @FindBy(css = "div.payments-confirm > h3")
    private WebElement goingToReceiveMoneyLabel;

    @FindBy(css = "div.payments-confirm > ul > li:nth-of-type(1) > label")
    private WebElement fromAccountLabel;

    @FindBy(css = "div.payments-confirm > ul > li:nth-of-type(2) > label")
    private WebElement toAccountLabel;

    @FindBy(css = "div.payments-confirm > ul > li:nth-of-type(4) > label")
    private WebElement mtcnLabel;

    @FindBy(css = "div.payments-confirm > ul > li:nth-of-type(5) > label")
    private WebElement FromCountryLabel;

    @FindBy(css = "div.payments-confirm > ul > li:nth-of-type(6) > label")
    private WebElement dateLabel;

    @FindBy(css = "div.westernUnion-transfer > h3")
    private WebElement infoLabelOne;

    @FindBy(css ="div.westernUnion-transfer > small")
    private WebElement infoLabelTwo;

    @FindBy(css = "div.westernUnion-transfer > ul > li:nth-of-type(1) > label")
    private WebElement nameLabel;

    @FindBy(css ="div.westernUnion-transfer > ul > li:nth-of-type(2) > label")
    private WebElement seriesAndNumberLabel;

    @FindBy(css = "div.westernUnion-transfer > ul > li:nth-of-type(3) > p")
    private WebElement cnpLabel;

    @FindBy(css ="div.westernUnion-transfer > ul > li:nth-of-type(4) > label")
    private WebElement telephoneLabel;

    @FindBy(css ="div.westernUnion-transfer > ul > li:nth-of-type(5) > label")
    private WebElement addressLabel;

    @FindBy(css = "div.westernUnion-transfer > ul > li:nth-of-type(6) > label")
    private WebElement birthdayLabel;

    @FindBy(css ="ul > li:nth-of-type(7) > label")
    private WebElement originCountryLabel;

    @FindBy(css = "button.button.fright")
    private WebElement confirmButton;

    @FindBy(css ="div.payments-previous-act")
    private WebElement previousPageButton;

    public boolean isWUlogoDisplayed(){
        return CommonTask.isDisplayed(WULogo,"WU logo");
    }





}
