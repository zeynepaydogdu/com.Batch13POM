package tests.day17;

import org.testng.annotations.Test;
import utilities.Driver;

public class C1_DriverIlkClass {

    @Test
    public void test01(){
        //driveri artik driver clasindan aliyorum static old icin clas ismi nokta
        // get driver nokta get ile gidiyorm aliyorm  !!Driver.getDriver().get!!
        Driver.getDriver().get("https://youtube.com");
        //ilk kullanimdan sonra tekrar tekrar driver olusturmammasi icin utulit deki driver a if
        //kosulu ilusturduk
        Driver.getDriver().get("https://facebook.com");
        Driver.getDriver().get("https://amazon.com");
        //if koymasaydik boyle olunca her seferinde bir sayfa acacak yani yeni bi drver uretiyr bu bir problem
        //kaparken tek amazonu kapayacak

        Driver.closeDriver();//after clas olmadigi icin artik bununla kapanis yapiyoruz
    }
}
