package com.onbis.Pages;

import com.onbis.Helper.Config;
import com.onbis.Helper.HelperMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PKIProfileSingnInPage extends PageObject {
    @FindBy(xpath = "//input[@name='browseButton']")
    WebElement browserButton;
    @FindBy(css = "input[id=pki_username]")
    WebElement pkiProfilePath;
    @FindBy(xpath = "//frame[@name='entrustTruePassGuiFrame']")
    WebElement loginFrame;
    @FindBy(id = "pki_password")
    WebElement pkiPasswordField;
    @FindBy(id = "submitButton")
    WebElement signInButton;
    @FindBy(xpath = "//span[contains(text(),'PKI PROFILE')]")
    WebElement profilePageHeading;

    public PKIProfileSingnInPage(WebDriver driver) {
        super(driver);
    }

    public void loginUsingEPFCredentials() throws InterruptedException {
        driver.switchTo().frame(loginFrame);
        HelperMethods.fluentWaitAndCheckVisible(browserButton, driver);
        Thread.sleep(2000);
//        ((JavascriptExecutor) driver).executeScript(
//                "HTMLInputElement.prototype.click = function() {                     " +
//                        "  if(this.type !== 'file') HTMLElement.prototype.click.call(this);  " +
//                        "};                                                                  ");
//
//        JavascriptExecutor js = (JavascriptExecutor) driver;
//        js.executeScript("arguments[0].style.display='block';", browserButton);
//        js.executeScript("arguments[0].value='C:\\workspace\\onbis-e2e\\src\\main\\resources\\psis_qa3.epf';", pkiProfilePath);
        pkiProfilePath.click();
        HelperMethods.highLighterMethod(driver, pkiProfilePath);
        pkiProfilePath.clear();
        HelperMethods.waitAndSendKeys(pkiProfilePath, "C:\\workspace\\onbis-e2e\\src\\main\\resources\\psis_qa3.epf", driver);
//        HelperMethods.waitAndTypeKeys(pkiProfilePath, "C:\\\\workspace\\\\onbis-e2e\\\\src\\\\main\\\\resources\\\\psis_qa3.epf", driver);
        HelperMethods.highLighterMethod(driver, pkiPasswordField);
        HelperMethods.waitAndSendKeys(pkiPasswordField, System.getenv("pkiPassword"), driver);
        Thread.sleep(2000);
        HelperMethods.staleElementClick(signInButton, driver);
        if (profilePageHeading.getText().contains(Config.PKI_PROFILE)) {
            Thread.sleep(1000);
            driver.navigate().to(System.getenv("soAdminWelcome"));
        }
    }
}
