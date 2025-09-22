package pages;

import aquality.selenium.browser.AqualityServices;
import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.elements.interfaces.IElement;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

public class AuthPage extends Form {
    private static final String NAME = "Login";
    private final IButton loginBtn = getElementFactory().getButton(By.xpath("//button[@id='login']"), "Login button");
    private final IElement userName = getElementFactory().getLabel(By.xpath(" //input[@id='userName']"), "Username field");
    private final IElement userPassword = getElementFactory().getLabel(By.xpath("//input[@id='password']"), "Password field");

    public AuthPage(){
        super(By.xpath(" //*[contains(text(), 'Login')]"), NAME);
    }

    public void sendData(String login, String password){
        userName.sendKeys(login);
        userPassword.sendKeys(password);
    }

    public void clickLogin() {
        ((JavascriptExecutor) AqualityServices.getBrowser().getDriver())
                .executeScript("arguments[0].scrollIntoView(true);", loginBtn.getElement());
        loginBtn.click();
    }
}
