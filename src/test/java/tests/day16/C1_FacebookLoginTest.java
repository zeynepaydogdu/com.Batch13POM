package tests.day16;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import pages.FacebookLoginPage;
import utilities.TestBase;

public class C1_FacebookLoginTest extends TestBase {
    @Test(groups = "mini_regression ,smoke")
    public void gelenekselTest(){
        driver.get("https://facebook.com");
        WebElement emailTextBox=driver.findElement(By.id("email"));
        emailTextBox.sendKeys("mehmet@gmail.com");

        WebElement passwordKutusu=driver.findElement(By.id("pass"));
        passwordKutusu.sendKeys("12345");

        driver.findElement(By.xpath("//button[@name='login']")).click();
    }

    @Test(groups = "mini_regression")
    public void pageIleTest(){
        //facebook loginpage den obje olusturarak o sayfadakileri kullanmak istiyorm
        //FACloGINpAGE DRIVERI GOTURMEK ICINparametre icinde driveri yazmamiz gerekir
        //ama hala hat veriyor sebebi farkli pakette olmalari o yuzden
        // page sayfasini public
        //yapiyoruz protected olmazmis ayni paket ce childlar ulasabilir biz ikiside degiliz


        driver.get("https://facebook.com");
        FacebookLoginPage facebookLoginPage=new FacebookLoginPage(driver);
        facebookLoginPage.emailTexBox.sendKeys("mehmet@gmail.com");
        facebookLoginPage.passwordTexBox.sendKeys("12345");
        facebookLoginPage.loginButonu.click();


    }


}
