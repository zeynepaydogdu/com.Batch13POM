package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class FacebookLoginPage {

    WebDriver driver;                                  //ilk once driver olustur

    public FacebookLoginPage(WebDriver driver) {       //constractr olusturduk

        this.driver = driver;//paramtreli const public yaptigimiz icin this kullanildi
        PageFactory.initElements(driver, this);
        //her page sayfasina bunu kullanacagiz
        //pagefactort :class ismi
        // init element methodu :driver a ilk deger atamasini sagliyor
    }

    @FindBy(id="email")
    public WebElement emailTexBox;

    @FindBy(id="pass")
    public WebElement passwordTexBox;

    @FindBy(xpath = "//button[@name='login']")
    public WebElement loginButonu;
}

