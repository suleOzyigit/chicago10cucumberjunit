package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.Driver;

import java.util.List;

public class MySelfPage extends NavigationMenu {
   // public MySelfPage(){PageFactory.initElements(Driver.getDriver(),this);}
// super class ta oldugu icin ihtitac yok
    @FindBy(xpath = "(//*[@class='title is-6'])[1]")
    public WebElement name;

    @FindBy(xpath = "(//*[@class='title is-6'])[2]")
    public WebElement role;

   // @FindBy(xpath = "(//*[@class='title is-6'])[3]")
    @FindBy(xpath = "(//*[.='team'])[2]/../p[1]")
    public WebElement team;


    @FindBy(xpath = "(//*[@class='title is-6'])[4]")
    public WebElement batch;

    @FindBy(xpath = "(//*[@class='title is-6'])[5]")
    public WebElement campus;

}
