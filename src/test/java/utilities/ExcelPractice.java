package utilities;

import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class ExcelPractice {
    public static void main(String[] args) {
        // create utility for the users data
        String path = "./src/test/resources/features/test_data/light-side-test-data.xls";
        String userSheet = "light-side-users";

        ExcelUtil excelData = new ExcelUtil(path, userSheet);// we are caling constructer
       //I am checking wheather i can acsees to file or not

        System.out.println(new File(path).exists());



        System.out.println(excelData.columnCount());
        System.out.println(excelData.rowCount());
        System.out.println(excelData.getColumnsNames());
        System.out.println(excelData.getCellData(1,1));
        System.out.println("==================================");



        List<Map<String, String>> seedata=excelData.getDataList();
        System.out.println(seedata.size());
        System.out.println(seedata.get(2));
        System.out.println(seedata.get(2).get("password"));
        System.out.println("==================================");
        String [][] dataarray=excelData.getDataArray();
        System.out.println(dataarray.length);

        System.out.println(Arrays.deepToString(dataarray));

        System.out.println("==============huhuuu=================using 2d array");



        for(String [] arr:dataarray){
            for(String arr2:arr){
                System.out.println(arr2);
            }
        }

// use 2d array to see first columm
        System.out.println("==========================see first colum with 2d array==========================");
        System.out.println(dataarray[1][1]);
    }
}

