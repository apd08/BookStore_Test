package pages;

import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.elements.interfaces.IElement;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;

public class AfterLoginPage extends Form {
    private static final String NAME = "LogOut";
    private final IButton logoutBtn = getElementFactory().getButton(By.xpath("//button[@id='submit']"), "Logout button");

    public AfterLoginPage(){
        super(By.xpath(String.format("//button[@id='submit' and contains(text(), 'Log Out')]")), NAME);
    }

        public boolean isLogOutBtnDisplayed(){
            logoutBtn.state().waitForDisplayed();
            return logoutBtn.state().isDisplayed();
        }
    }
