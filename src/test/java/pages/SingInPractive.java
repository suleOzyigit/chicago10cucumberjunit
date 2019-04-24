package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.BrowserUtilities;
import utilities.ConfigurationReader;
import utilities.Driver;

public class SingInPractive {
    public SingInPractive(){
        PageFactory.initElements(Driver.getDriver(),this);

    }
    @FindBy(name = "email")
    public WebElement email;

    @FindBy(name = "password")
    public WebElement password;

    @FindBy(css = "button[type='submit']")
    public WebElement signIn;

    public static String currentUserEmail;


   public void logIn(String email,String password){

       currentUserEmail = email;
       WebDriverWait wait= new WebDriverWait(Driver.getDriver(),5);

       this.email.sendKeys(email);
       this.password.sendKeys(password);
       BrowserUtilities.wait(2);

       signIn.click();


       wait.until(ExpectedConditions.urlContains("map"));// I put that method here because code is to fast i makes problem that is why it needs to wait until next page opens

   }
}
