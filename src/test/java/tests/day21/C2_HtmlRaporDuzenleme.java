package tests.day21;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.KoalaResortPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;
public class C2_HtmlRaporDuzenleme extends TestBaseRapor {
    @Test
    public void pozitifLoginTesi(){
        // 1- Test class’ini extends ile TestBaseRapor Class’ina child yapalim
        // 2- extentTest=extentReports.createTest(“Test ismi”, “Tanim”);  rapor olusturalim
        extentTest=extentReports.createTest("Smoke","Gecerli bilgilerle giris yapma");
        // 3- Gerekli/istedigimiz satirlara extentTest.info(“Aciklama”) ekleyelim
        // 4- Assert olan satirda aciklamayi extentTest.pass ile yapabiliriz
        Driver.getDriver().get(ConfigReader.getProperty("kr_url"));
        extentTest.info("Koala resort hotels sayfasina gidildi");

        KoalaResortPage koalaResortPage=new KoalaResortPage();
        koalaResortPage.ilkLoginLinki.click();
        extentTest.info("Login linkine basildi");
        koalaResortPage.kullaniciAdiTextBox.sendKeys(ConfigReader.getProperty("kr_valid_username"));
        extentTest.info("Gecerli kullanici adi yazildi");

        koalaResortPage.passwordTexBox.sendKeys(ConfigReader.getProperty("kr_valid_password"));
        extentTest.info("Gecerli sifre yazildi");
        koalaResortPage.loginButonu.click();
        extentTest.info("Login butonuna basildi");
        Assert.assertEquals(Driver.getDriver().getCurrentUrl(),ConfigReader.getProperty("kr_basarili_giris_url"));
        extentTest.info("Basarili giris yapildigi test edildi");
    }
}