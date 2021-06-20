package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.util.concurrent.TimeUnit;

public class Driver {

private Driver(){
    //EGER DEFAULT constrctri yazar ve acces modifieri private yaparsak
    //class disindan bu constrctra ulasilamaz ve dolayisiyla  bu clastan obje uretilemez
    //amacimiz driver clasinin ozelliklerinin baska yerlerden degistirilmesine engel olmak
    //buyuk projelerede guvenlik icin driver clasi singleton yapilir

    }

    //child claslar ulasabilsin diye onceden protected yapiyorduk
    //simdi ya obje olusturarark yada static yapariz boylece class ismiyle ulasiriz
    //satic: classs ismiyle ulasabilmem icin
    //private: baska clasdakiler degistiremesin diye

    static private WebDriver driver;

    public static WebDriver getDriver(){
        //singleton olusturulabilirmis
        //singleton:
        //sadece chrome calismak istemiyorsak firefox safari vb

        //tekrar tekrar driver olustrmaamasi icin if kosulu koyacaz
        if(driver==null) {
            //conf.prop dosyasindaki browser chorem sa olusturacagim ayarlari chorem olarak olustr
            //conf.prop dosyasindaki browser firefox sa olusturacagim ayarlari firefox.. olarak olustr
            switch (ConfigReader.getProperty("browser")){

                case "chrome" :

                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    break;

                    case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    break;
                case"opera":
                    WebDriverManager.operadriver().setup();
                    driver=new OperaDriver();
                    break;
                case"safari":
                    WebDriverManager.getInstance(SafariDriver.class);
                    driver=new SafariDriver();
                    break;
            }


        }


        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        return driver;
    }

    public static void closeDriver(){
        if (driver != null) {
            driver.close();
            driver=null;//driver null degilse kapat
        }

    }
}
