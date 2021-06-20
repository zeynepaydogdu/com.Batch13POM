package smokeTest;

import org.testng.annotations.Test;
import pages.E2ERoomPage;
import utilities.ConfigReader;
import utilities.Driver;

public class Room2 {
    /*
    4. Username textbox ve password metin kutularını locate edin ve aşağıdaki
verileri girin.
a. Username : manager b. Password : Manager2!
5. Login butonuna tıklayın.
6. Hotel Management menusunden Add Hotelroom butonuna tıklayın.
7. Açılan sayfadaki tüm metin kutularına istediğiniz verileri girin.
8. Save butonuna basin.
9. “HotelRoom was inserted successfully” textinin göründüğünü test edin.
10. OK butonuna tıklayın.
11. Hotel rooms linkine tıklayın.
12. "LIST OF HOTELROOMS" textinin göründüğünü doğrulayın..
     */
    @Test
    public void room2(){
        Driver.getDriver().get(ConfigReader.getProperty("kr_url"));

        E2ERoomPage e2ERoomPage=new E2ERoomPage();
        e2ERoomPage.ilkLogin.click();
        e2ERoomPage.userName.sendKeys(ConfigReader.getProperty("kr_valid_username"));
        e2ERoomPage.password.sendKeys(ConfigReader.getProperty("kr_valid_password"));
        e2ERoomPage.loginButon.click();
        e2ERoomPage.hotelManagement.click();



    }
}
