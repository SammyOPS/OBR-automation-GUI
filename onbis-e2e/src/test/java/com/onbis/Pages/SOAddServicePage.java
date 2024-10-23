package com.onbis.Pages;

import com.onbis.Helper.HelperMethods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SOAddServicePage  extends PageObject {
    public SOAddServicePage(WebDriver driver) { super(driver); }

    @FindBy(xpath = "//*[@id=\"myServicesModel\"]/table/tbody/tr[4]/td[2]/a")
    WebElement ontarioBusinessRegistryStartNow;

    @FindBy(xpath = "//a[contains(text(),'Ontario business registry')]")
    WebElement ontarioBusinessRegistryLink;


    public void selectStartOntarioBusinessRegistry() {
        HelperMethods.fluentWaitAndClick(ontarioBusinessRegistryStartNow, driver);
    }

    public void selectServiceName() {
        HelperMethods.fluentWaitAndCheckVisible(ontarioBusinessRegistryLink, driver);
        HelperMethods.staleElementClick(ontarioBusinessRegistryLink, driver);
    }
}
