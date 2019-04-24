package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class MapPage extends NavigationMenu{
    // we extends from navigationMenu because when I at the map page I will click somthing from there but when I click it opnes new page
    // I should be able to click and use those webElemnts


    public MapPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }// super calss ta constructer oldugu icin ihtiyac yok


    @FindBy(tagName = "h1")
    public WebElement header;

    @FindBy(linkText = "map")
    public WebElement map;

    @FindBy(xpath = "//div[@class='container']/h2")
    public WebElement location;

    @FindBy(css = "a>span.room-name")
    public List<WebElement> roomRooms;

    public WebElement room(String roomName)
    {
        return Driver.getDriver().findElement(By.linkText(roomName));
    }
}
