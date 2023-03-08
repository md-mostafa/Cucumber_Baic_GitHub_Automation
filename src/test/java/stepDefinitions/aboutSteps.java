package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.AboutPage;
import pages.FooterPage;
import setup.Setup;
import utils.Utils;

import java.time.Duration;

public class aboutSteps  extends Setup{
    private FooterPage footerPage;
    private AboutPage aboutPage;

    @Given("user visits the site")
    public void user_visits_the_site() {
        driver.get("https://github.com");
    }

    @When("user scrolls down to the page")
    public void user_scrolls_down_to_the_page(){
        Utils.scrollToTheEnd(driver);
    }

    @And("click on About button")
    public void click_on_about_button(){
        footerPage = new FooterPage(driver);
        footerPage.clickOnAboutBtn();
    }

    @Then("about page is opened")
    public void about_page_is_opened(){
        aboutPage = new AboutPage(driver);
        String heading_actual = aboutPage.getHeading();
        String heading_expected = "build from here";
        Assert.assertTrue(heading_actual.contains(heading_expected));
    }

    @After
    public void tearDown(){
        driver.quit();
    }

}
