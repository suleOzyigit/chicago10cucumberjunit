package steps;


import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import pages.HuntPage;
import pages.MyScadeulePage;
import pages.SingInPractive;
import utilities.*;

import java.util.Map;

public class UserRolesStepDefinitions {
    MyScadeulePage myScadeulePage=new MyScadeulePage();

    @Given("the user logs in as a light-side  {string}")
    public void the_user_logs_in_as_a_light_side(String user) {
    Driver.getDriver().get(ConfigurationReader.getProperty("url"));

    SingInPractive singInPractive=new SingInPractive();
        Map <String ,String> userCredentialsedantiol;
        switch (user){
           case "team member":
                userCredentialsedantiol=UserUtilities.getUserCredentials(AplicationConstants.STUDENT_TEAM_MEMBER,AplicationConstants.LIGHT_SIDE);
                singInPractive.logIn(userCredentialsedantiol.get("email"),userCredentialsedantiol.get("password"));
                System.out.println(userCredentialsedantiol.get("email"));
                System.out.println("***************************************************STUDENT_TEAM_MEMBER");

               return;

            case "team lead":
                 userCredentialsedantiol=UserUtilities.getUserCredentials(AplicationConstants.STUDENT_TEAM_LEADER,AplicationConstants.LIGHT_SIDE);
                singInPractive.logIn(userCredentialsedantiol.get("email"),userCredentialsedantiol.get("password"));
                System.out.println("***************************************************STUDENT_TEAM_LEADER");
                System.out.println(userCredentialsedantiol.get("email"));
               return;

            case "teacher ":
                userCredentialsedantiol=UserUtilities.getUserCredentials(AplicationConstants.TEACHER,AplicationConstants.LIGHT_SIDE);
                singInPractive.logIn(userCredentialsedantiol.get("email"),userCredentialsedantiol.get("password"));
                System.out.println("***************************************************TEACHER");
              return;
        }

    }
    @Given("there are available spots for scheduling")
    public void there_are_available_spots_for_scheduling() {
       // MyScadeulePage myScadeulePage=new MyScadeulePage();
        myScadeulePage.goToScedule();
        System.out.println(myScadeulePage.isCellBlockAvaiable("7:00",1));
        System.out.println("==========================================================");

    }

    @When("the user hunts for a spot")
    public void the_user_hunts_for_a_spot() {

        HuntPage huntPage=new HuntPage();
       huntPage.hunt.click();


        String today=DateUtility.todaysDate();
        huntPage.date.sendKeys(today);
        BrowserUtilities.waitForPageToLoad(5);

        huntPage.selectFrom("9:30pm");

        BrowserUtilities.wait(2);
        huntPage.selectTo("10:00pm");

        huntPage.search.click();


    }

    @Then("book button should not be displayed")
    public void book_button_should_not_be_displayed() {
BrowserUtilities.verifyElementNotDisplayed(By.tagName("button"));
        System.out.println("==============****************+++++++++++++++++");


    }

    @Then("book button should be displayed")
    public void book_button_should_be_displayed() {
        BrowserUtilities.verifyElementDisplayed(By.tagName("button"));
        System.out.println("==============****************+++++++++++++++++");

    }
}
