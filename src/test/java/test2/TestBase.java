package test2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;


    public abstract class TestBase {
        protected WebDriver driver;
        /*
        public:herkes ulasir
        protected:ayni paket ve child class
        default:ayni paket(package private)
        private:ayni class
         */
        @BeforeMethod
        public void setup(){
            WebDriverManager.chromedriver().setup();
            driver=new ChromeDriver();
            driver.manage().window().maximize();
            //   driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        }
        @AfterMethod
        public void tearDown(){
            //driver.close();
        }
}
