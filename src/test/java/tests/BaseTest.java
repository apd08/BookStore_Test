package tests;

import aquality.selenium.browser.AqualityServices;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
//import pages.MainPage;
import utils.SettingsTestData;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import static aquality.selenium.browser.AqualityServices.getBrowser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class BaseTest {
    private static final Logger logger = LoggerFactory.getLogger(BaseTest.class);
//    protected final MainPage mainPage = new MainPage();

    @BeforeMethod
    public void setup() {
        logger.info("Open the browser");
        logger.info("Maximize the browser window");
        getBrowser().maximize();
        logger.info("Go to start URL");
        getBrowser().goTo(SettingsTestData.getEnvData().getHost());
    }

    @AfterMethod
    public void teardown() {
        logger.info("Quiting the browser..");
        if (AqualityServices.isBrowserStarted()) {
            getBrowser().quit();
        }
    }
}
