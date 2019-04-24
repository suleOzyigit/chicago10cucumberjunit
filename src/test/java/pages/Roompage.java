package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class Roompage extends NavigationMenu {

    public Roompage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "(//p[@class='subtitle is-7'])[1]")
    public WebElement capacityQuoto;

    @FindBy(className = "room-info-icon")
    public WebElement capacityImg;

    @FindBy(xpath = "(//p[@class='title is-6'])[2]")
    public WebElement equipment;
}
