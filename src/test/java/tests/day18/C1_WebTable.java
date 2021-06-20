package tests.day18;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import pages.KoalaResortPage;
import utilities.Driver;

public class C1_WebTable {
    /*
    ● login() metodun oluşturun ve oturum açın.
● http://qa-environment.koalaresorthotels.com /admin/HotelRoomAdmin adresine gidin
 ○ Username : manager
 ○ Password : Manager1!
● table() metodu oluşturun
 ○ Tüm table body’sinin boyutunu(sutun sayisi) bulun. /tbody
 ○ Table’daki tum body’I ve başlıkları(headers) konsolda yazdırın.
● printRows() metodu oluşturun //tr
 ○ table body’sinde bulunan toplam satir(row) sayısını bulun.
 ○ Table body’sinde bulunan satirlari(rows) konsolda yazdırın.
 ○ 4.satirdaki(row) elementleri konsolda yazdırın.
     */

    @Test(groups = "mini_regression")
    public void table(){
        KoalaResortPage koalaResortPage=new KoalaResortPage();
        koalaResortPage.koalaResortLogin();

        //○ Tüm table body’sinin boyutunu(sutun sayisi) bulun. /tbody
        // "//tbody//tr[1]//td"bu body deki 1. satirdaki data (hucre) sayisini veriyor
        //bu locator le bana 9 webelementi dondugu icin
        System.out.println("tablodaki sutun sayisi:"+koalaResortPage.birinciSatirDatalar.size());

       // System.out.println(koalaResortPage.sutunBasliklari.);bu sekilde listemiz web elementlerden
        //olustugu icin direk yazdiramayiz bu yuzden foreach loop ile herbir vebelementi
        //alip ustundeki text i yazdirmammiz gerekir

        for (WebElement each:koalaResortPage.sutunBasliklari
             ) {
            System.out.println(each.getText());
        }

       //               System.out.println(koalaResortPage.tbodyWebelement.getText());

        //bu sekilde body i yazdirmak istersek herseyi yazdirir karisik olur
        //eger tum bodyi tek bir webelement olarak locate eder ve yazdirirsabiz
        //tum bodyi gorebilirsiniz ancak bu cok kullanilmaz cunku bu durumdda satir sutun
        //ve datalari ayirma sansimiz yoktur
        //tum body tek bir element olarak yazdirilabilir ama islem yapmak zordur

    //BODY NIN ICInde bulunan td sayisini bulmak icin //tbody//td locateni kullaniriz

        System.out.println("tablo bodysinde bulunan cell sayisi :"+koalaResortPage.bodydekiTumDataListesi.size());
        Driver.closeDriver();

    }

    @Test(groups = "smoke")
    public void getRows(){
        /*
        ● printRows() metodu oluşturun //tr
 ○ table body’sinde bulunan toplam satir(row) sayısını bulun.
 ○ Table body’sinde bulunan satirlari(rows) konsolda yazdırın.
 ○ 4.satirdaki(row) elementleri konsolda yazdırın.
         */

        KoalaResortPage koalaResortPage=new KoalaResortPage();
        koalaResortPage.koalaResortLogin();
        //----------//tbody//tr bana satirlari verir
        System.out.println("tablodaki satir sayisi:"+koalaResortPage.satirlarListesi.size());


        //○ Table body’sinde bulunan satirlari(rows) konsolda yazdırın.
        for (WebElement each: koalaResortPage.satirlarListesi
             ) {
            System.out.println(each.getText());
        }

        // ○ 4.satirdaki(row) elementleri konsolda yazdırın.
        System.out.println(koalaResortPage.satirlarListesi.get(3).getText());


        //4.satir deseydi locate buydu //tbody//tr[3] olurdu
        //ama dinamik olarak bu sekilde olmaz o yuzden locate ona gore ayarlamaliyiz

        // bir liste olusturmadan, parametre olarak satir numarasi kabul edip
        // girilen numaradaki satiri yazdiran bir method yaziniz

        // ornek 5.satir desem locate //tbody//tr[4]

        // 7. satiri yazdiralim
        System.out.println("=================");
        koalaResortPage.istenenSatiriYazdir(7);

    }
}
