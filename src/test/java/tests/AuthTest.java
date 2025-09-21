package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AfterLoginPage;
import pages.AuthPage;
import pages.StartPage;

public class AuthTest extends BaseTest{
    private StartPage startPage = new StartPage();
    private AuthPage authPage = new AuthPage();
    private AfterLoginPage afterLoginPage = new AfterLoginPage();

    @Test
    public void FormAuthenticationTest() {
        Assert.assertTrue(authPage.state().isDisplayed(), "Login Page isn't open");
        startPage.clickLogin();
        authPage.sendData("Anna", "Qwer_1234*");
        authPage.clickLogin();
        Assert.assertTrue(afterLoginPage.isLogOutBtnDisplayed(), "AfterLogin Page isn't open");
    }
}
