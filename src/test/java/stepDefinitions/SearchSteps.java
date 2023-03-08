package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.HeaderPage;
import pages.SearchResultPage;
import setup.Setup;

public class SearchSteps extends Setup {
    private HeaderPage headerPage;
    private SearchResultPage srchResultPage;

    @Given("user visits the portal")
    public void user_visits_the_portal() {
        driver.get("https://github.com");
    }

    @When("user inputs searchTerm: {string} in the search field")
    public void user_inputs_searchTerm_in_the_search_field(String searchTerm){
        headerPage = new HeaderPage(driver);
        headerPage.enterInputs(searchTerm);
    }
    @And("user presses enter")
    public void user_presses_enter(){
        headerPage = new HeaderPage(driver);
        headerPage.pressEnter();
    }

    @Then("user sees a count of matching results")
    public void user_sees_a_count_of_matching_results(){
        srchResultPage = new SearchResultPage(driver);
        String searchCountLabel_actual = srchResultPage.getSearchCountLabel();
        Assert.assertTrue(searchCountLabel_actual.contains("repository results"));
    }

    @And("expected searchResult: {string} as the first result")
    public void expected_searchResult_as_the_first_result(String expectedResult){
        srchResultPage = new SearchResultPage(driver);
        String firstResult = srchResultPage.getFirstResultLinkTxt();
        Assert.assertTrue(firstResult.contains(expectedResult));
    }

    @After
    public void tearDown(){
        driver.quit();
    }
}
