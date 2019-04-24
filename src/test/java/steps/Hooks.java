package steps;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utilities.DataBaseUtility;
import utilities.Driver;

import java.util.concurrent.TimeUnit;

public class Hooks {

    @Before (order = 2)
    public void setUp(){
        System.out.println("I am setting up the rest test from the Hooks class!");

        Driver.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Driver.getDriver().manage().window().maximize();
    }



    @After
    public void tearDown(Scenario scenario){//we write scenario here to connect scenario
    System.out.println("I am reporting the result");
    if(scenario.isFailed()){
        //this line takes screean shot
        final byte[] screenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
        // this line is adding the screenshot to the report
        scenario.embed(screenshot, "image/png");
        // takes screean shot is an interface from Selenium
    }
        System.out.println("Driver is closing");
      //  Driver.closeDriver();
}
    @Before(value = "@teacher", order = 11)
    public void setUpTeacher(){
        System.out.println("Set up teacher test");
    }
//=============================data base de calismak icin set up yaptik cunku herseferinde acip kapamamiza gerek kalmasin diye=======
    // sadece database test yaptigimda run yapacak ama tag correct pleasede olmali
  //in my framework, we have create connection method which i call before every cucumber scenario that does db testing.
    // to do this I jave a seond @before method in hooks class with @db tag. I also add this tag to my scenarios with DB. testing

    @Before(value = "@db")
    public void setUpDBConnection(){

        DataBaseUtility.createConnection();
    }

    @After(value = "@db")
    public void closeDBConnection(){
        DataBaseUtility.closeConnection();
    }

}
