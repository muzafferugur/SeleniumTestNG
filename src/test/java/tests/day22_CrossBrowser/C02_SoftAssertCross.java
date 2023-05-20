package tests.day22_CrossBrowser;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utilities.TestBase;

public class C02_SoftAssertCross extends TestBase {
    /*
    1-amazon anasayfaya gidin
    2-title in Amazon içerdigini test edin
    3-arama kutusnun erişilebilir oldugunu tets edin
    4-arama kutusuna Nutella yazıp aratın
    5-arama yapıldıgını test edin
    6-arama sonucunun Nutella içerdigini test edin
     */

    /*
        SoftAssert başlangıç ve bitiş satırları arasındaki tüm assertion'ları yapıp
        bitiş  satırına geldiğinde bize bulduğu tüm hataları rapor eder.

        Softassert başlangıcı obje oluşturmaktır.

         ***Soft Assert***(Verification)
        SoftAssert doğrulama (verification) olarak da bilinir. softAssertion kullandığımızda,assert FAILED olsa bile
        test methodunun istediğimiz kısmını durdurmaz ve yürümeye devam eder. if-else statementda olduğu gibi.

        Test methodunun istediğiimiz bölümde yapılan tüm testleri raporlar.
        Eğer assertionlardan FAILED olan varsa raporlama yapılan satırdan sonrasını çalıştırmaz.
        (assertAll() a kadar çalıştırır assertAll() dan sonrasını çalıştırmaz)
    */

    @Test
    public void test01() {

        SoftAssert softAssert = new SoftAssert();

        driver.get("https://www.amazon.com");

        String expectedTitle = "Amazon";
        String actualTitle = driver.getTitle();
        softAssert.assertTrue(actualTitle.contains(expectedTitle), "title amazon içermiyor");

        WebElement aramaKutusu = driver.findElement(By.id("twotabsearchtextbox"));
        softAssert.assertTrue(aramaKutusu.isEnabled(), "arama kutusuna erişilemiyor");

        aramaKutusu.sendKeys("Nutella" + Keys.ENTER);

        WebElement sonucYazisiElementi = driver.findElement(By.xpath("//h1[@class='a-size-base s-desktop-toolbar a-text-normal']"));
        softAssert.assertTrue(sonucYazisiElementi.isDisplayed(), "arama yapılamadı");

        softAssert.assertTrue(sonucYazisiElementi.getText().contains("Nutella"), "sonuç yazısı Kutella içermiyor");


        //Softassert'e bitiş satırını söylemek için assertAll() kullanılır. Failed olan olursa assertion yaptığımız metodun sonuna yazdığımız mesajı bize
        //konsolda verir. Bu satır yazılmazsa assertion görevi yapılmamış olur.
        softAssert.assertAll();

        System.out.println("assertion'lardan fail olan olursa,burası çalışmaz ");//tüm assertionlar çalışırsa bu yazıyı yazıdırır
    }
}
