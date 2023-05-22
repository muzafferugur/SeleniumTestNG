package tests.day22_CrossBrowser;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.AmazonPage;
import utilities.ConfigReader;
import utilities.Driver;

public class C03_DataProvider {


    @Test
    public void test01() {
        AmazonPage amazonPage = new AmazonPage();
        /*
        amazon sayfasına gidelim
        nutella için arama yapalım
        sonuçların nutella içerdiğini test edelim
         */

        Driver.getDriver().get(ConfigReader.getProperties("amazonUrl"));

        amazonPage.aramaKutusu.sendKeys("Nutella" + Keys.ENTER);

        String expectedKelime = "Nutella";
        String actualSonucYazisi = amazonPage.aramaSonucElementi.getText();
        Assert.assertTrue(actualSonucYazisi.contains(expectedKelime));

        Driver.closeDriver();

    }

    @DataProvider
    public static Object[][] AranacakKelimeler() {
        Object[][] arananKelimeArrayi = {{"Nutella"}, {"Java"}, {"çiğdem"}, {"Netherlands"}};
        return arananKelimeArrayi;
    }

    @Test(dataProvider = "AranacakKelimeler")
    /*
    Arayacağımız kelimeleri bir liste gibi tutup bana yollayacak bir veri sağlayıcısı oluşturacağız.
     */
    public void dataProviderTest(String arananKelime) {
        AmazonPage amazonPage = new AmazonPage();
        Driver.getDriver().get(ConfigReader.getProperties("amazonUrl"));

        /*
        Nutella, Java, çiğdem ve Netherlands için arama yapalım
        sonuçların aradığımız kelime içerdiğini test edelim.
        sayfayı kapatalım
         */
        amazonPage.aramaKutusu.sendKeys(arananKelime + Keys.ENTER);

        String expectedKelime = arananKelime;
        String actualSonucYazisi = amazonPage.aramaSonucElementi.getText();
        Assert.assertTrue(actualSonucYazisi.contains(expectedKelime));

        Driver.closeDriver();

    }
}
