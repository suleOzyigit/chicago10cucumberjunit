package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utilities.BrowserUtilities;
import utilities.Driver;

public class HuntPage extends NavigationMenu {
    @FindBy(tagName = "input")
    public WebElement date;

    @FindBy(css = "#mat-select-0 .mat-select-arrow")
    public WebElement from;

    @FindBy(css = "#mat-select-1 .mat-select-arrow")
    public WebElement to;


//    @FindBy(xpath="(//div[@class='mat-select-arrow-wrapper'])[1]")
//    public WebElement from;
//
//    @FindBy(linkText = "(//div[@class='mat-select-arrow-wrapper'])[2]")
//    public WebElement to;


    @FindBy(css = ".mat-icon.material-icons")
      public WebElement search;


    public void selectFrom(String startTime) {
        from.click();
        String xpath = "//span[contains(.,'" + startTime + "')]";
        BrowserUtilities.wait(1);
        Driver.getDriver().findElement(By.xpath(xpath)).click();
    }

    public void selectTo(String endTime) {
        to.click();
        String xpath = "//span[contains(.,'" + endTime + "')]";
        BrowserUtilities.wait(1);
        Driver.getDriver().findElement(By.xpath(xpath)).click();
    }
}
