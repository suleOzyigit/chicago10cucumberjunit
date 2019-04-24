package steps;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import pages.MapPage;
import pages.MySelfPage;
import pages.Roompage;
import pages.SingInPractive;
import utilities.ExcelUtil;

import java.io.File;
import java.util.Map;

public class RoomDetailsStepDefinitions {

    @Then("correct room information should be displayed for light side")
    public void correct_room_information_should_be_displayed_for_light_side() {
        String file = "./src/test/resources/features/test_data/light-side-test-data.xls";
        String sheet = "light-side-rooms";


        ExcelUtil roomData = new ExcelUtil(file, sheet);
       System.out.println(new File(file).exists());
        System.out.println(roomData.getColumnsNames());
        for(Map<String,String> room:roomData.getDataList()){

            System.out.println(room.get("name"));

            // click to each room
            // based on information from excel verify UI

            MapPage mapPage=new MapPage();
            String Roomname=room.get("name");
            mapPage.room(Roomname).click(); // What we did here is we call method from mapapge it takes rook name and click it

             // see the room capasity for each room
            Roompage roompage=new Roompage();

            // verify capacity

          String capacity = room.get("capacity");// it comes frim excel file


            System.out.println(capacity);

            String actualAttribute=roompage.capacityImg.getAttribute("src");// inside of the lication <img class="room-info-icon" src="assets/images/six.svg">

            // After print we get-----> at the console 6.0
            //https://cybertek-reservation-qa.herokuapp.com/assets/images/six.svg

            System.out.println(actualAttribute);


            if (capacity.startsWith("6")) {
                Assert.assertTrue(actualAttribute.endsWith("six.svg"));
            } else {
                Assert.assertTrue(actualAttribute.endsWith("four.svg"));
            }

            // based on the room information from excel verify UI

            // VERIFY EQUIPMENT
            // room.get("equipment")  expected value from excel
            // roomPage.equipment.getText()  --> actual value from UI

            Assert.assertEquals(room.get("equipment"), roompage.equipment.getText());
// based on the room information from excel verify UI

            // VERIFY EQUIPMENT
            // room.get("equipment")  expected value from excel
            // roomPage.equipment.getText()  --> actual value from UI

            Assert.assertEquals(room.get("equipment"), roompage.equipment.getText());
            roompage.map.click();// every time when we click to room name we need to go bact to roompage and clikc back. You can also use nagivate back
        }

    }

    @When("my self page should display personal information for that user")
    public void my_self_page_should_display_personal_information_for_that_user() {
        // open the myselfpage
        // get the excel data
        // get the spesific user information based on email that excel file
        // get information real UI
        // compare to info
        new MySelfPage().goToSelf();// bu myself page goturuyor metodu cagirdim



        System.out.println("=============================");
        String file = "./src/test/resources/features/test_data/light-side-test-data.xls";
        String sheet = "light-side-users";
        ExcelUtil userdata=new ExcelUtil(file,sheet);
// we need to make connection so we are going to get email and look at rhe excel to have whole infi so we did
       // public static String currentUserEmail; at the sing in page

        SingInPractive singInPractive=new SingInPractive();
        System.out.println(singInPractive.currentUserEmail);


        System.out.println(new File(file).exists());// excele baglanti saglandi mi kontrol et
         for(Map<String,String> user:userdata.getDataList()){// get dteails is a method comes from util class
             //System.out.println(user);
             // we need to fing that email at excel file

             if(singInPractive.currentUserEmail.equals(user.get("email"))){
                 System.out.println(user);


                 MySelfPage mySelfPage=new MySelfPage();
                 String expectedName=user.get("name");
                 String actualName=mySelfPage.name.getText();
                 Assert.assertEquals(expectedName, actualName);



                 String expectedRole = user.get("role");
                 String actualRole = mySelfPage.role.getText();
                 Assert.assertTrue(actualRole.contains(expectedRole.trim()));
//                verify team
                 String expectedTeam = user.get("team");
                 String actualTeam = mySelfPage.team.getText();
                 Assert.assertEquals(expectedTeam.replace(" ",""), actualTeam);
//                verify campus
                 String expectedCampus = user.get("campus");
                 String actualCampus = mySelfPage.campus.getText();
                 Assert.assertEquals(expectedCampus, actualCampus);
//                verify batch
                 String expectedBatch= user.get("batch");
                 String actualBatch = mySelfPage.batch.getText();
                 Assert.assertEquals(expectedBatch, actualBatch);


                 return;
             }
         }










         // it is only execute when we can not find email
Assert.fail(singInPractive.currentUserEmail+ " email could not found");
    }
        }




