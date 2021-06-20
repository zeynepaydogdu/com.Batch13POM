package utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    //utilitiesin altinda olusturduk amaci
    //config.properties den verileri alip kullanmak
//    bu objenin projenin her yerinden Class ismi ile cagrilabilmesi icin static yapiyoruz
    //1.adim Properties objesi olusturmak
    //conf.propertiesi okumasi icin objesi olusturdk

    //static yaptik class ismi ile cagirmak icin
    //bu objenin projenin heryerinden class ismi ile cagirilabilmesi icin static yapiyoruz
    //bu objeye clas disindan mudahale olmamamsi icin private yapiyoruz opsinel

   static private Properties properties;
   //static blok olusturucaz dosyayi okumasi icin javadan fileinpput kullanacz
   //CONFIgration.properties i bu klasore pathini gostermem lazim
   //stattic blok herseyden once calisir
   static {
       String path="src/configuration.properties";
       try {
           FileInputStream fileInputStream=new FileInputStream(path);
           properties=new Properties();
           //bu class calistiginda static block calisacak ve tek bir islem yapacak
           //fileinputstream objesi calisacak ve
           //orda ki  okudugu bilgileri properties objesine yukleyecek
           properties.load(fileInputStream);

           fileInputStream.close();

       } catch (FileNotFoundException e) {
           e.printStackTrace();
       } catch (IOException e) {
           e.printStackTrace();
       }
   }
    //su ana kadar butun datayi propertiese yukledik
    //suan bunu icinden bana lazim olani yollamam lazim
    //keyy yollayip bana value donduren bir methot yazacaz
    //prob u kullanabilmme icin methodu static yapivm
    public static String getProperty(String key){
       String value=properties.getProperty(key);
       return value;
    }


}

//bu clas cagirildiginda ilk statik blok calisacak
//static blok
//test data nizi nasil dinamik yaparsiniz?
//configuration .prop dosyasi olustr
//onu nasil okutursun?
//tercuman kullanirim configreader dr adi
//file input stream kullanarak bilgileri properties objesine yuklerim
