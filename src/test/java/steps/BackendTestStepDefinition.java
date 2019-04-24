package steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import pages.MySelfPage;
import pages.MyTeamPage;
import pages.SingInPractive;
import utilities.BrowserUtilities;
import utilities.DataBaseUtility;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class BackendTestStepDefinition {

// get the expected data from data base
    // we need the qery whiich select people with the same team as our user
    // get the accepted data from UI

    //compare them

    @Then("team information should match database records")
    public void team_information_should_match_database_records() {
        MyTeamPage myTeamPage = new MyTeamPage();

        //BrowserUtilities.waitForPageToLoad(3);
        BrowserUtilities.waitForVisibility(myTeamPage.teamName, 3);
        BrowserUtilities.wait(3);
        String teamName = myTeamPage.teamName.getText();
        System.out.println(teamName);
        // BrowserUtilities.wait(5);
        System.out.println(teamName + "=team name");
// we build sql based on team name
//        String sql = "select u.firstname " +
//                " from users u join team t on t.id = " +
//                "u.team_id and t.name = '" + teamName + "';";
//
//        DataBaseUtility.getColumnData(sql,"firstname");
//        //get the columdata returns aslist
//        List<Object> names=DataBaseUtility.getColumnData(sql,"fullname");// our utility returs everything object
//        System.out.println(names);
//        // get the actual name fro UI
//       List<String> actualNames=BrowserUtilities.getElementsText(myTeamPage.allNames);
//       // we need to compare tow list but one of them is object that is why we need to use for each loop
//        for(Object name:names){
//            Assert.assertTrue(actualNames.contains(name.toString()));// we need to convert to string
//        }


        String sql = "select u.firstname " +
                " from users u join team t on t.id = " +
                "u.team_id and t.name = '" + teamName + "';";
        // getColumnData returns data of a single column
        List<Object> names = DataBaseUtility.getColumnData(sql, "firstname");

        System.out.println(names);
        // get the actual name
        List<String> actualNames = BrowserUtilities.getElementsText(myTeamPage.allNames);

        Assert.assertEquals(names.size(), actualNames.size());
        // make sure all names appear in the expected list
        for (Object name : names) {
            Assert.assertTrue(actualNames.contains(name.toString()));
        }


    }
    List<Object> clusterTable;

    @Given("there is a list of clusters in the clusters table")
    public void there_is_a_list_of_clusters_in_the_clusters_table() {
        //get the cluster of id from cluster table

       String sql="Select * from cluster;";

clusterTable=DataBaseUtility.getColumnData(sql,"id");
        System.out.println("=====================");
        System.out.println(clusterTable);
    }
List<Object> roomTable;
    @Given("all rooms have a clusters id in room table")
    public void all_rooms_have_a_clusters_id_in_room_table() {
        //get the cluster of id from room table
        String sql="Select * from room;";

        roomTable=DataBaseUtility.getColumnData(sql,"cluster_id");


        System.out.println(roomTable);

    }

    @Then("all the clusters ids must be from the clusters table")
    public void all_the_clusters_ids_must_be_from_the_clusters_table() {
        //compare them
        for(Object o:roomTable){
            Assert.assertTrue(clusterTable.contains(o));
        }
    }
    @Then("correct user information should be displayed for {string}")
    public void correct_user_information_should_be_displayed_for(String email) {


        String sql = "SELECT firstname, lastname, t.name " +
                "FROM users u " +
                "JOIN team t " +
                "ON t.id =u.team_id " +
                "WHERE email = '"+email+"';";

Map<String, Object> userInfo=DataBaseUtility.getRowMap(sql);
        System.out.println(userInfo);

        String nameData=userInfo.get("firstname").toString()+" "+ userInfo.get("lastname").toString();
        MySelfPage mySelfPage=new MySelfPage();
        Assert.assertEquals(mySelfPage.name.getText(),nameData);
        String teamName=userInfo.get("name").toString();

        Assert.assertEquals(mySelfPage.team.getText(),teamName);
    }

    @When("user logs in any user")
    public void user_logs_in_any_user() {
        String sql ="SELECT email,firstname,lastname FROM users ORDER BY RANDOM()" +
                "LIMIT 1;";
        Map<String,Object> randomInfo=DataBaseUtility.getRowMap(sql);
        System.out.println(randomInfo);
        String email=randomInfo.get("email").toString();
        System.out.println(email);
        String firstName=randomInfo.get("firstname").toString();
        System.out.println(firstName);
        String lastname=randomInfo.get("lastname").toString();
        System.out.println(lastname);
        String password=firstName.toLowerCase()+lastname.toLowerCase();
        SingInPractive singInPractive=new SingInPractive();
        singInPractive.logIn(email,password);

    }
}
