package com.onbis.TestCases;

import com.onbis.Helper.EmailUtils;
import com.onbis.Helper.ListenersTestNG;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.io.IOException;

import static com.onbis.Helper.EmailUtils.emailTransactionNumberTIsDisplayed;

@Listeners(ListenersTestNG.class)
public class outLook extends BaseTestNoPage {
    @FindBy(css ="div#folder0>div:nth-of-type(2)>div:nth-of-type(6)>span:nth-of-type(2)")
    WebElement nuans_report_number;
    @FindBy(css = "div#folder0>div>span:nth-of-type(2)")
    WebElement nuansReportNumber;
    @FindBy(xpath = "/nuans_report_list/nuans_report_item[1]/a/span[3]")
    WebElement nuansReportNumberIE;
    @FindBy(xpath = "/nuans_report_list/nuans_report_item[1]")
    WebElement nuansReportNumberFirefox;

    @FindBy(css = "div#folder1 > div:nth-of-type(2) > div:nth-of-type(1) > span:nth-of-type(2)")
    WebElement nuansReportTitle;
    @FindBy(xpath = "/nuans_report_list/nuans_report_item[1]/report_title")
    WebElement nuansReportTitleIE;
    @FindBy(xpath = "/nuans_report_list/nuans_report_item[1]/report_title")
    WebElement nuansReportTitleFirefox;
// +++++++


    /*
    nuansAddReportNumber
     */
    @Test
    public void outLook() throws InterruptedException, IOException {
        driver.get("https://outlook.live.com/");

//        HelperMethods.waitAndSendKeys(driver.findElement(By.xpath("//span[text()='Use your Google Account']/following::input")), Config.CONTACT_CONFIRM_EMAIL_VALUE, driver);
//        HelperMethods.fluentWaitAndClick(driver.findElement(By.xpath("//span[text()='Next']")), driver);
//        Assert.assertTrue(genericUtilsPage.emailSubjectAndContentIsDisplayed());

        // Define the username and password
        String username = "onbistestautomation@outlook.com";
        String password = "TestAuto123!";

        // Define the start and end strings
        String start = "Transaction Number:";
        String end = "Dear Client";

        // Call the function and print the result
        EmailUtils.emailTransactionNumberIsDisplayed(username, password, start, end);
//        String result = emailTransactionNumberTIsDisplayed(username, password, start, end);
//        System.out.println("Text Between Strings:\n" + result);

    }
}
