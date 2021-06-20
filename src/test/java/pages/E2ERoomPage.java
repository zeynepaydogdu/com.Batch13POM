package pages;

import org.jsoup.helper.W3CDom;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class E2ERoomPage {
    public E2ERoomPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(linkText = "Log in")
    public WebElement ilkLogin;

    @FindBy(id = "UserName")
    public WebElement userName;

    @FindBy(id = "Password")
    public WebElement password;

    @FindBy(id = "btnSubmit")
    public WebElement loginButon;

    @FindBy(id = "menuHotels")
    public WebElement hotelManagement;


}
