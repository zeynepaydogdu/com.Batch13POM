package smokeTest;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.KoalaResortPage;
import utilities.ConfigReader;
import utilities.Driver;

public class E2EHotel2 {
    /*
    2. Bir metod olusturun: createHotel
3.http://qa-environment.koalaresorthotels.com adresine git.
4. Username textbox ve password metin kutularını locate edin ve asagidaki verileri
girin.
a. Username : manager
b. Password : Manager2!
5. Login butonuna tıklayın.
6. Hotel Management/Hotel List menusunden ADD HOTEL butonuna tiklayin
7. Açılan sayfadaki tüm metin kutularına istediğiniz verileri girin.
8. Save butonuna tıklayın.
9. “Hotel was inserted successfully” textinin göründüğünü test edin.
10. OK butonuna tıklayın
     */
    @Test
    public void E2EHotel2() throws InterruptedException {
        Driver.getDriver().get(ConfigReader.getProperty("kr_url"));

        KoalaResortPage koalaResortPage=new KoalaResortPage();
        koalaResortPage.ilkLoginLinki.click();
        koalaResortPage.kullaniciAdiTextBox.sendKeys(ConfigReader.getProperty("kr_valid_username"));
        koalaResortPage.passwordTexBox.sendKeys(ConfigReader.getProperty("kr_valid_password"));
        koalaResortPage.loginButonu.click();
        koalaResortPage.hotelManagement.click();
        koalaResortPage.hotelList.click();
        koalaResortPage.addHotel.click();

        Actions actions=new Actions(Driver.getDriver());
       actions.click(koalaResortPage.codeTextBox).sendKeys(ConfigReader.getProperty("kr_code"))
               .sendKeys(Keys.TAB).sendKeys(ConfigReader.getProperty("kr_customer_name"))
               .sendKeys(Keys.TAB).sendKeys(ConfigReader.getProperty("kr_customer_adress"))
               .sendKeys(Keys.TAB).sendKeys(ConfigReader.getProperty("kr_customer_phone"))
               .sendKeys(Keys.PAGE_DOWN)
               .sendKeys(Keys.TAB)
               .sendKeys(ConfigReader.getProperty("kr_customer_email"))
               .perform();

        Select select=new Select(koalaResortPage.acilirMenu);
        select.selectByVisibleText(ConfigReader.getProperty("kr_dropdown_value"));

        Thread.sleep(2000);
        koalaResortPage.saveButonu.click();

        Thread.sleep(2000);
        Assert.assertEquals(koalaResortPage.sonucYazisiElementi.getText(),ConfigReader.getProperty("kr_otel_olusturuldu_yazisi"));

        koalaResortPage.sonOKButonu.click();
        Driver.closeDriver();
    }

}
