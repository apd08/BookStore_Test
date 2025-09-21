package pages;

import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;


public class StartPage extends Form {
    private static final String NAME = "BookStore";
    private final IButton loginBtn = getElementFactory().getButton(By.xpath("//button[@id='login']"), "Login button");

    public StartPage(){
        super(By.xpath(" //*[contains(text(), 'Book Store')]]"), NAME);
    }

    public void clickLogin(){
        loginBtn.click();
    }
}
