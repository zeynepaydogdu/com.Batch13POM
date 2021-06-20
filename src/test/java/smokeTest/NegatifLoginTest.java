package smokeTest;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.KoalaResortPage;
import utilities.ConfigReader;
import utilities.Driver;

public class NegatifLoginTest {
    /*
    Farkli test Methodunda 3 senaryoyu test et
- yanlisSifre
- yanlisKulllanici
- yanlisSifreKullanici
test data dogru username: manager , dogru password : Manager2!
2)http://qa-environment.koalaresorthotels.com adresine git
 adresine git
3) Login butonuna bas
4) Verilen senaryolar ile giris yapilamadigini test et
     */

    @Test
    public void negatifLoginTesti(){
        Driver.getDriver().get(ConfigReader.getProperty("kr_url"));
        KoalaResortPage koalaResortPage=new KoalaResortPage();

         koalaResortPage.ilkLoginLinki.click();
         koalaResortPage.passwordTexBox.sendKeys(ConfigReader.getProperty("kr_wrong_password"));
         koalaResortPage.kullaniciAdiTextBox.sendKeys(ConfigReader.getProperty("kr_wrong_username"));
         koalaResortPage.loginButonu.click();
        Assert.assertTrue(koalaResortPage.girisYapilamadiElementi.isDisplayed());

        Driver.closeDriver();
    }

}
