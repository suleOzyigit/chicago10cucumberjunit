package steps;

import cucumber.api.java.en.Then;
import io.cucumber.datatable.DataTable;
import org.junit.Assert;
import pages.MapPage;
import pages.MySelfPage;
import pages.Roompage;
import utilities.BrowserUtilities;
import utilities.Driver;

import java.util.List;
import java.util.Map;

public class MyDetailsPractice_steps {

    @Then("the user should see their information:")
    public void the_user_should_see_their_information(Map<String,String>userInfo) {
        System.out.println(userInfo);
        String name=userInfo.get("name");//===> it comes from map
        String role=userInfo.get("role");
        String team=userInfo.get("team");
        String batch=userInfo.get("batch");
        String campus=userInfo.get("campus");



        MySelfPage mySelfPage=new MySelfPage();
        String actualname=mySelfPage.name.getText();
        String actualrole=mySelfPage.role.getText();
        String actualteam=mySelfPage.team.getText();

        System.out.println(actualname);
        System.out.println(actualrole);

        System.out.println(actualteam);



        String actualbatch=mySelfPage.batch.getText();
        String actualcampus=mySelfPage.campus.getText();

        Assert.assertEquals(name,actualname);
        Assert.assertTrue(actualrole.contains(role));
        Assert.assertEquals(team,actualteam);
        Assert.assertEquals(batch,actualbatch);
        Assert.assertEquals(campus,actualcampus);



    }

    @Then("user should be able to quotos info fpr each room")
    public void user_should_be_able_to_quotos_info_fpr_each_room(Map<String,String> rooms) {
         // get the name of the room
        // clict the room
        //verify quoto
        System.out.println(rooms);
        MapPage mapPage=new MapPage();
        for(String room:rooms.keySet()){
            mapPage.room(room).click();// room inside of parantesis comes form for each loop
            Roompage roompage=new Roompage();
           // System.out.println(rooms.get(room)); map in icindeli degeri aliypor yani the more the better
Assert.assertEquals(rooms.get(room),roompage.capacityQuoto.getText());
            Driver.getDriver().navigate().back();// because when it clicks ping pon after verifiying it needs to go bak to map page
        }

    }
}
