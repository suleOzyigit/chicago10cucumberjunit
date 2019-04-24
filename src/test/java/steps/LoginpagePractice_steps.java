package steps;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import pages.MapPage;
import pages.SingInPractive;

public class LoginpagePractice_steps {

    @When("user logs in using {string} and {string}")
    public void user_logs_in_using_and(String email, String password) {
        System.out.println("email="+email);
        System.out.println(password);
// I comment out it because I will use method from SignIn  page
//        SingInPractive singInPractive= new SingInPractive();
//        singInPractive.email.sendKeys(email);
//        singInPractive.password.sendKeys(password);
//        singInPractive.signIn.click();
       SingInPractive singInPractive=new SingInPractive();
       singInPractive.logIn(email, password);

    }
    @Then("the title should be {string}")
    public void the_title_should_be(String title) {
        System.out.println("title=" +title);

    }
    @Then("there should be {int} option")
    public void there_should_be_option(Integer count) {
        System.out.println("count"+count);

    }
    @Then("location should be {string}")// this method come from Location feature
    public void location_should_be(String expectedLocation) {
        MapPage mapPage=new MapPage();


       String actual= mapPage.location.getText();

        Assert.assertEquals(actual,expectedLocation);//=====>this location comes from location feature

    }

}
