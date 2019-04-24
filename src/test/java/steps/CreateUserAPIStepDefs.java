package steps;

import com.github.javafaker.Faker;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Assert;
import utilities.BookITRestUtility;
import utilities.DataBaseUtility;

import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;


public class CreateUserAPIStepDefs {
    String token;
    Response postResponse;
    String firstName, lastName, email, password;

    @Given("the user has access token as a student")
    public void the_user_has_access_token_as_a_student() {
        token = BookITRestUtility.getStudentToken();
        System.out.println("token = " + token);
    }

    @When("the user creates a new student")
    public void the_user_creates_a_new_student() {
        Faker faker = new Faker();
        firstName = faker.name().firstName();
        lastName = faker.name().lastName();
        email = firstName.toLowerCase() + lastName.toLowerCase() + "@" + faker.internet().domainName();
        password = firstName.toLowerCase() + lastName.toLowerCase();
        String role = "student-team-member";
        int batch = 8;
        String teamName = "CodeHunters";
        String campus = "VA";


        postResponse = given().
                header("Authorization", token).
                queryParam("first-name", firstName).
                queryParam("last-name", lastName).
                queryParam("email", email).
                queryParam("password", password).
                queryParam("role", role).
                queryParam("campus-location", campus).
                queryParam("batch-number", batch).
                queryParam("team-name", teamName).
                when().
                post("/api/students/student");

    }

    @Then("the new student should not be created")
    public void the_new_student_should_not_be_created() {
        postResponse.then().log().all();
        postResponse.then().assertThat().statusCode(403).
                body(containsString("only teacher allowed to modify database."));

    }

    @Given("the user has access token as a teacher")
    public void the_user_has_access_token_as_a_teacher() {
        token = BookITRestUtility.getTeacherToken();
    }

    @Then("the new student should be created")
    public void the_new_student_should_be_created() {
        postResponse.then().log().all();
        postResponse.then().assertThat().statusCode(201).
                body(containsString("has been added to database"));

    }
    @Then("the new student information should be in the database")
    public void the_new_student_information_should_be_in_the_database() {


        Map<String,Object> dbUser=getdbaseUser( email);
        System.out.println("=====================");
        System.out.println(dbUser);
        System.out.println(dbUser.get("firstname"));
        System.out.println(firstName);
        System.out.println("=====================");

        Assert.assertEquals(dbUser.get("firstname"),firstName);
       assertThat(dbUser.get("firstname"), is(firstName));
        assertThat(dbUser.get("lastname"),is(lastName));
       assertThat(dbUser.get("email"),is(email));
        // verify that id is not empty
        assertThat(dbUser.get("id"), is(notNullValue()));
    }

    @Then("the user should be able to login with the new student info")
    public void the_user_should_be_able_to_login_with_the_new_student_info() {

    }






    public static Map<String,Object> getdbaseUser(String email){
        DataBaseUtility.createConnection();
        String sql="select firstname,lastname,id,email from users where email='"+ email +"';";
    Map<String ,Object> userInfo=DataBaseUtility.getRowMap(sql);
        DataBaseUtility.closeConnection();
    return userInfo;
    }

}
