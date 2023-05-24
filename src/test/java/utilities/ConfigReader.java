package utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    /*
    ConfigurationReader class test method’larimiz ile Configuration.properties arasinda iletisimi saglar.
Bu class’da test class’larindan kolayca ulasmak icin static method bulunur. Method static oldugundan method
icerisinden cagiracagimiz variable da static olmalidir. Kullanacagimiz static variable’a ilk degeri atamak icin(instantiate) de static block
kullaniriz.
     */

    public static Properties properties;//->obje oluşturduk

    static {
        String dosyaYolu = "configuration.properties";

        //her seferinde class isminin yanına throws atmak yerine try-cathch kullanıyoruz.

        try {
            FileInputStream fis = new FileInputStream(dosyaYolu);
            //fis dosya yolunu tanımladığımız configuration.properties dosyasını okudu
            properties = new Properties();//değer atadık
            properties.load(fis);// FileInputStream in okuduğu değerleri propertiese yükledim

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getProperty(String key) {

        /*
        test methodundan yolladığımız string key değerini alıp Properties classından getProperty() methodunu
        kullanarak bu key'e ait value'yu bize getirdi.
         */

        return properties.getProperty(key);
    }
}
