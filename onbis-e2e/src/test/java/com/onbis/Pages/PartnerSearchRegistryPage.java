package com.onbis.Pages;

import com.onbis.Helper.HelperMethods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PartnerSearchRegistryPage extends PageObject{
    public PartnerSearchRegistryPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(id = "QueryString")
    WebElement searchField;
    @FindBy(xpath = "//span[text()=' Advanced']")
    WebElement advancedLink;

    public boolean soleProprietorshipIsRegistered() {
        boolean isCorrect = HelperMethods.fluentWaitAndCheckVisible(searchField, driver);
        return isCorrect;
    }
}
