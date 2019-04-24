package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public abstract class NavigationMenu {

    Actions actions=new Actions(Driver.getDriver());

    public NavigationMenu() {
        PageFactory.initElements(Driver.getDriver(),
                this);
    }

    @FindBy(linkText = "map")
    public WebElement map;

    @FindBy(linkText = "schedule")
    public WebElement schedule;

    @FindBy(linkText = "hunt")
    public WebElement hunt;

    @FindBy(linkText = "my")
    public WebElement my;

    @FindBy(linkText = "self")
    public WebElement self;

    @FindBy(linkText = "team")
    public WebElement team;

    @FindBy(linkText = "sign out")
    public WebElement signOut;

    @FindBy(linkText = "general")
    public WebElement general;

    public void goToSelf(){

        //Actions actions=new Actions(Driver.getDriver());
        actions.moveToElement(my).perform();
        self.click();
    }
    public void goToTeam(){
        actions.moveToElement(my).perform();
        team.click();

    }
    public void singOut(){
        actions.moveToElement(my).perform();
        signOut.click();
    }
    //To Do: check those methods again
    public void goToScedule(){
        actions.moveToElement(schedule).perform();
        my.click();
    }
    public void goToGeneral(){
        actions.moveToElement(schedule).perform();
        general.click();
    }
}
