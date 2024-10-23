package com.onbis.TestCases;

import com.onbis.Helper.ListenersTestNG;
import org.junit.Assert;
import org.junit.jupiter.api.DisplayName;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.io.IOException;

@Listeners(ListenersTestNG.class)
public class TC01_BCAR001_TestCasesForIncorportatDeleteAProfile extends SOAccountSetUp {

    /*
     * Delete an existing SOAB profile
     * */
    @Test
    @DisplayName("1.Incorporate an Ontario Business Corporation- Number")
    public void TC01_BCAR001_TestCasesForIncorportatDeleteAProfile() throws InterruptedException, IOException {
        osbAccountCatalogPage.selectRegistrationTypeAsIncorporateAnOntarioBusinessCorporation();
        oneKeyLogin.loginUsingOneKeyCredentials();
//        soAccountLandingPage.deleteProfiles();
        Assert.assertTrue(soAccountLandingPage.deleteAProfile());
    }
}