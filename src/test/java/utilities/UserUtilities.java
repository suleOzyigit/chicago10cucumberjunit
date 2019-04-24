package utilities;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserUtilities {

    // we need method to take user name and pasword from excel
    //read correct excel file dependson corroct location and get data
    public static Map<String, String> getUserCredentials(String role, String location){

      String file=null;

      switch(location){
          case AplicationConstants.IL:
              file= "./src/test/resources/newTest_data/il-users.xls";
              break;
          case AplicationConstants.Dark_SIDE:
              file="./src/test/resources/newTest_data/dark-side-users.xls";
              break;
          case AplicationConstants.LIGHT_SIDE:
              file="./src/test/resources/newTest_data/light-side-users.xls";
              break;
      }

//read the files and get the data from there and breaks to com to make list of details

        List<Map<String, String>> userData = new ExcelUtil(file, "Sheet1").getDataList();

        for (Map<String, String> user : userData) {
            if (role.contains(user.get("role"))) {
                Map<String, String> map = new HashMap<>();
                map.put("email", user.get("email"));
                map.put("password", user.get("first_name").toLowerCase() + user.get("last_name").toLowerCase());
                return map;
            }
        }
        return null;
    }

    public static void main(String[] args) {
       // System.out.println(getUserCredentials( "teacher","light_side"));
        //better version
        System.out.println(getUserCredentials( AplicationConstants.TEACHER, AplicationConstants.LIGHT_SIDE));
    }
}
