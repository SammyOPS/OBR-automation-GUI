package com.onbis.TestCases;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

public class SOAccountAccountLandingTests extends SOAccountSetUp {
    @BeforeMethod
    void doInitialSetUp() throws IOException, InterruptedException {
        oneKeyLogin.loginUsingOneKeyCredentials();
    }

    @Test
    public void whenUserLoadsPage_ThePageElementsAreDisplayed() {
        Assert.assertTrue(soAccountLandingPage.pageElementsDisplayed());
    }
}
