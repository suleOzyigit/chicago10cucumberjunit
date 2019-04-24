package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class MyTeamPage extends NavigationMenu{

    public MyTeamPage(){

        PageFactory.initElements(Driver.getDriver(),
                this);
    }

    @FindBy(xpath = "//p[.='name']/../p[1]")// expath bulurken name in expathini alisak unique yi buluyoruz sonra geriye donup parents in ilk cocugunu aliyor
    public List<WebElement> allNames;

//    @FindBy(xpath = "//h2[@class='subtitle']")
//    public WebElement teamName;
//
//

//    @FindBy(xpath = "//div[@class='hero-body']/div/h1/../h2")
//    public WebElement teamName;

    @FindBy(xpath = "//h1[.='team']/../h2")
    public WebElement teamName;
}
