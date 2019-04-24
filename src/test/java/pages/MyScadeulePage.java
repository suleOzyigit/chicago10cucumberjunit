package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Driver;

import java.util.List;

public class MyScadeulePage extends NavigationMenu {
    //there is a constructer at the nagavation menu that is why we do not need constructer


    // ---->element contains 7.00     //th[contains(.,'7.00')]
// ----->/.. parents then td child   //th[contains(.,'7:00am')]/../td[1]....Ogren
    // this may another way (//tbody/tr[1])/td[1]

    // it returns cell cell block depends on time and day.Day start from zero today is zero tomarrow is 1
    // expath teki rakalmari metoddaki rakamlarla switch ettik


   public  WebElement getCell(String startTime,int addDay){

String xpath= "//th[contains(.,'"+startTime+"')]/../td["+(addDay+1)+"]";
return Driver.getDriver().findElement(By.xpath(xpath));
   }
    /**
     * returns all the cell blocks for required day
     * days start from today upto next 7 days
     * 0 means today, 1 means tomorrow, 2 means day after tomorrow etc
     *
     * @param addDays
     * @return
     */
    public List<WebElement> getCellsForDay(int addDays){

        return Driver.getDriver().findElements(By.xpath("//tr/td[" + (addDays + 1) + "]"));

    }

    /**
     * tells if a single cell block is available based on time and days count starting from today up to 7 days.
     * 0 means today, 1 means tomorrow, 2 means day after tomorrow etc
     *
     * @param startTime
     * @param addDay
     * @return
     */

    public boolean isCellBlockAvaiable(String startTime,int addDay){
        return !getCell(startTime,addDay).getAttribute("class").contains("conferance");//----->if the time is not avaiable shows conferance

    }

    /**
     * tells if there is any available block for that day based days count starting from today up to 7 days.
     * 0 means today, 1 means tomorrow, 2 means day after tomorrow etc
     * @param addDays
     * @return
     */
    public boolean isDayAvaiable(int addDays){
        for(WebElement cell:getCellsForDay(addDays)){
            if(!cell.getAttribute("class").contains("conferance")){
                return true;
            }

        }
        return false;

    }
}
