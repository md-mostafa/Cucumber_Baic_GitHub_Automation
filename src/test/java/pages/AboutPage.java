package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AboutPage {
    @FindBy(tagName = "h1")
    WebElement labelHeading;

    public AboutPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    public String getHeading(){
        return labelHeading.getText();

    }
}
