package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class SearchResultPage {
    @FindBy(xpath = "//h3[contains(text(), 'repository results')]")
    WebElement labelRepoResults;

    @FindBy(xpath = "//ul[@class='repo-list']//li")
    List<WebElement> repoLists;

    public SearchResultPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }
    public String getSearchCountLabel(){
        return labelRepoResults.getText();
    }

    public String getFirstResultLinkTxt(){
        return repoLists.get(0).findElement(By.xpath("//a[@class='v-align-middle']")).getText();
    }
}
