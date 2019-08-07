package steps;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class StudentApi_steps {
    @When("user hits single student API with {string}")
    public void user_hits_single_student_API_with(String uri) {

        Response response=  RestAssured.get(uri);
    }

    @Then("user test for required attribitues")
    public void user_test_for_required_attribitues() {

    }
}
