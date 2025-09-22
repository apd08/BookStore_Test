package tests;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AfterLoginPage;
import pages.AuthPage;
import pages.StartPage;

public class AuthTest extends BaseTest{
    private static final Logger logger = LoggerFactory.getLogger(AuthTest.class);
    private StartPage startPage = new StartPage();
    private AuthPage authPage = new AuthPage();
    private AfterLoginPage afterLoginPage = new AfterLoginPage();

    @Test
    public void FormAuthenticationTest() {
        logger.info("Check that Login page is displayed");
        Assert.assertTrue(authPage.state().isDisplayed(), "Login Page isn't open");
        startPage.clickLogin();
        logger.info("Insert credentials");
        authPage.sendData("Anna", "Qwer_1234*");
        logger.info("Submit login form");
        authPage.clickLogin();
        logger.info("Verify that user is logged in");
        Assert.assertTrue(afterLoginPage.isLogOutBtnDisplayed(), "AfterLogin Page isn't open");
    }
}
