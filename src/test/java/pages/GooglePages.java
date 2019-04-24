package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class GooglePages {

    WebDriver driver;

    public GooglePages(){
        driver= Driver.getDriver();
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath ="//input[@class='gLFyf gsfi']")
    public WebElement searchBox;

    @FindBy(xpath = "(//input[@value='Google Search'])[1]")
    public WebElement googleSearch;


}
