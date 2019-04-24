package steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import pages.GooglePages;
import utilities.Driver;

public class GoogleParam_steps {

    @Given("user shold be on google page")
    public void user_shold_be_on_google_page() {
        Driver.getDriver().get("https://www.google.com");

    }

    @When("user enters {string} in the search")
    public void user_enters_in_the_search(String string) {
        GooglePages gOG=new GooglePages();
        gOG.searchBox.sendKeys(string, Keys.ENTER);

    }

    @Then("user shoyld see {string} on the page")
    public void user_shoyld_see_on_the_page(String string) {
String expected=string+ " - Google Search";
String actual=Driver.getDriver().getTitle();
        Assert.assertEquals(actual,expected);
    }
}
