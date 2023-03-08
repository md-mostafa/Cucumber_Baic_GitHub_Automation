package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HeaderPage {
    @FindBy(xpath = "//input[contains(@class, 'js-site-search-focus')]")
    WebElement searchInp;

    public HeaderPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    public void enterInputs(String searchTerm){
        searchInp.sendKeys(searchTerm);
    }

    public void pressEnter(){
        searchInp.sendKeys(Keys.ENTER);
    }
}
