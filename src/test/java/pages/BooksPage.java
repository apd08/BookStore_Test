package pages;

import aquality.selenium.browser.AqualityServices;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.stream.Collectors;


public class BooksPage {

    public List<String> getBookTitlesFromPage(){
        List<WebElement> elements= AqualityServices.getBrowser()
                .getDriver()
                .findElements(By.xpath("//span[@class='mr-2']/a"));
        return elements.stream()
                        .map(WebElement::getText)
                        .map(String::trim)
                        .collect(Collectors.toList());
    }
}
