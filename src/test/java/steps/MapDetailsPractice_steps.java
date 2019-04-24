package steps;

import cucumber.api.PendingException;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.cucumber.datatable.DataTable;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.MapPage;
import pages.MyTeamPage;
import utilities.BrowserUtilities;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class MapDetailsPractice_steps {

    MapPage mapPage = new MapPage();

    @Then("I should be able to see {string} room")
    public void i_should_be_able_to_see_room(String rooms) {

// get all rooms name

       // MapPage mapPage = new MapPage();
//        List<WebElement> roomRooms = mapPage.roomRooms;// buradaki list i MapPage in aynisi ile tanimladik
//        for (int i = 0; i < roomRooms.size(); i++) {
////
//            if (mapPage.roomRooms.get(i).getText().equals(rooms)) {
//                System.out.println(mapPage.roomRooms.get(i).getText());
//
//                Assert.assertTrue(mapPage.roomRooms.get(i).getText().contains(rooms));
//                System.out.println("aaaa");
//                break;
//            }
//
//        }

///there is also another aproach we can call method from Browser utilities class

        List<String> myRoom= BrowserUtilities.getElementsText(mapPage.roomRooms);
        Assert.assertTrue(myRoom.contains(rooms));
    }

    @Then("the user should be able to see following conferance rooms")
    public void the_user_should_be_able_to_see_following_conferance_rooms(List<String> rooms) {
        System.out.println(rooms);
        System.out.println(rooms.size());

        List<String> myRoom= BrowserUtilities.getElementsText(mapPage.roomRooms);
        System.out.println(myRoom);
        Assert.assertTrue(myRoom.equals(rooms));
        System.out.println("roms name are equal with data table and list from mapPage");

    }

    @When("the user goes to the {string} page")
    public void the_user_goes_to_the_page(String page) {

        switch (page){
            case "map":
                mapPage.map.click();
                break;
            case "hunt":
                mapPage.hunt.click();
            case "my self":
                mapPage.goToSelf();
                break;
            case "my team":
                mapPage.goToTeam();
                break;
            case "my schedule":// under the scedule
                mapPage.goToScedule();
                break;
            case "schedule general":
                mapPage.goToGeneral();
                break;

        }



    }

    @Then("following team members should be displayed:")
    public void following_team_members_should_be_displayed(List<String> members) {

// get the list of all memebers and verify or compare all the list at the url
        MyTeamPage myTeamPage=new MyTeamPage();
        List<String> actualMembers=BrowserUtilities.getElementsText(myTeamPage.allNames);// bu method web elementleri string yapiyor fakat store etmeyi unutma baska bir list in icine
        System.out.println(actualMembers);
//        Collections.sort(members);
//        Collections.sort(members); it did not work
        Assert.assertEquals(members.size(),actualMembers.size());

        Assert.assertTrue(actualMembers.containsAll(members));



    }

}
