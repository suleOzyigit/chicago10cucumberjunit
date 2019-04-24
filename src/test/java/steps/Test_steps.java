package steps;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import utilities.Driver;

public class Test_steps {
    @When("user goes to google application")
    public void user_goes_to_google_application() {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("user goes googleaplication");
    }

    @Then("user search for apple")
    public void user_search_for_apple() {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("user searc apple");

        Driver.getDriver().get("https://www.amazon.com");
    }

    @Then("user should see apple realted result")
    public void user_should_see_apple_realted_result() {
        // Write code here that turns the phrase above into concrete actions

    }

    @Then("user tests somthing")
    public void user_tests_somthing() {
        // Write code here that turns the phrase above into concrete actions

    }

}
