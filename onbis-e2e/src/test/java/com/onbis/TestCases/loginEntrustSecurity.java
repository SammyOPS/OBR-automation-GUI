package com.onbis.TestCases;

import com.onbis.Helper.HelperMethods;
import com.onbis.Helper.ListenersTestNG;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.awt.*;
import java.io.IOException;

@Listeners(ListenersTestNG.class)
public class loginEntrustSecurity {


    /*
    nuansAddReportNumber
     */
    @Test
    public void loginEntrustSecurityStore() throws InterruptedException, IOException, AWTException {
//        SOAccountLandingPage.loginEntrustSecurityStore("Ps1sCatalyst");

        HelperMethods.excCommand("C://Program Files (x86)//Common Files//Entrust//ESP//eesystry.exe");
        Thread.sleep(2000);
        // HelperMethods.robotSendValue("Ps1sCatalyst");
//        Thread.sleep(10000);
        HelperMethods.robotSendValue(System.getenv("pkiPassword"));
        Thread.sleep(200);
        HelperMethods.robotSendTAB();
        Thread.sleep(200);
        HelperMethods.robotSendENTER();
        Thread.sleep(200);
    }


    // +++++++++

    //++++++


    // ++++
}
