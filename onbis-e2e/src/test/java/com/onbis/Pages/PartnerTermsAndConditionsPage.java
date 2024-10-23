package com.onbis.Pages;

import com.onbis.Helper.HelperMethods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PartnerTermsAndConditionsPage extends PageObject {
    public PartnerTermsAndConditionsPage(WebDriver driver) {
        super(driver);
    }

    //    @FindBy(xpath = "//button[contains(@class,'appButton registerBusinessNameSoleProp-commonEditIncludesBox-commonEditIncludesNonInternalBox-termsAndConditionsBox-termsAndConditionsDialogBox-buttonsBox-acceptTerms')]")
    @FindBy(xpath = "//button[contains(@class,'termsAndConditionsBox-termsAndConditionsDialogBox-buttonsBox-acceptTerms')]")
    WebElement acceptButton;

    public void acceptTermsAndConditions() {
        driver.getWindowHandle();
        HelperMethods.fluentWaitAndCheckVisible(acceptButton, driver);
        HelperMethods.fluentWaitAndClick(acceptButton, driver);
    }

}
