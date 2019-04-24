package steps;



import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.MapPage;
import pages.SingInPractive;
import utilities.BrowserUtilities;
import utilities.ConfigurationReader;
import utilities.Driver;


public  class HomePagePractice_steps {

    @When("user logs in as a team lead")
    public void user_logs_in_as_a_team_lead() {
        System.out.println("I am log in");
        System.out.println("email: " + ConfigurationReader.getProperty("leader_email"));
        System.out.println("password: " + ConfigurationReader.getProperty("leader_password"));

        SingInPractive singInPractive=new SingInPractive();

        singInPractive.email.sendKeys(ConfigurationReader.getProperty("leader_email"));
        singInPractive.password.sendKeys(ConfigurationReader.getProperty("leader_password"));


        singInPractive.signIn.click();


    }
    @Given("user on the log in page")
    public void user_on_the_log_in_page() {
        System.out.println("I am opening to login page");
       Driver.getDriver().get(ConfigurationReader.getProperty("url"));
       //open the login page  of application
        //url is inthe properties file
    }


    @Then("Home page should be display")
    public void home_page_should_be_display() {
      System.out.println("I can see home page right now");
//        //verify that "map" header is disp[lay not the title
     MapPage mapPage=new MapPage();
//// those are all different way to solve the problem
//        //BrowserUtilities.wait(2);
//       // BrowserUtilities.waitForPageToLoad(5);
//        // this Excplicity wait
//       // BrowserUtilities.waitForVisibility(mapPage.map,2);// mapin cikmasini bekliyor
//       // this implicity wait
//        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 5);
//         wait.until(ExpectedConditions.textToBePresentInElement(mapPage.header, "map"));
////
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 5);
        //wait.until(ExpectedConditions.textToBePresentInElement(mapPage.header, "map"));
//
       wait.until(ExpectedConditions.urlContains("map"));
       Assert.assertEquals(mapPage.header.getText(),"map");

    }

    @Then("title should be correct")
    public void title_should_be_correct() {
        System.out.println("I can see the home page now");
    }


    @When("user logs in as a team member")
    public void user_logs_in_as_a_team_member() {
        System.out.println("I am loging as team memeber");


        SingInPractive singInPractive=new SingInPractive();

        singInPractive.email.sendKeys(ConfigurationReader.getProperty("member_email"));
        singInPractive.password.sendKeys(ConfigurationReader.getProperty("member_password"));
        singInPractive.signIn.click();




    }

    @When("user logs in as a teacher")
    public void user_logs_in_as_a_teacher() {

        System.out.println("I amliging as a teacher");




        SingInPractive singInPractive=new SingInPractive();

        singInPractive.email.sendKeys(ConfigurationReader.getProperty("teacher_email"));
        singInPractive.password.sendKeys(ConfigurationReader.getProperty("teacher_password"));
        singInPractive.signIn.click();

    }

}
