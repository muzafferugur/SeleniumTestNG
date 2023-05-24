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
