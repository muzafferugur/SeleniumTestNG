package tests.day19_smokeTest;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BrcPage;
import utilities.ConfigReader;
import utilities.Driver;

public class NegativeLoginTest {
    /*
    Smoke Test: Kullandigimiz uygulamanin onemli/temel fonksiyonlarini test etmek icin yapilir.
Genellikle sabah ilk ise baslama gorevimizdir. Login,logout,sepete ekle,odeme yap.. gibi temel
islevleri test ederiz. Eger smoke test FAILED olursa zaman gecirmeksizin tum ekibi haberdar ederiz
     */
    BrcPage brcPage = new BrcPage();

    /*
    1.https://www.bluerentalcars.com/ adresine git
    2.Login butonuna bas
    3.user email : customer@bluerentalcars.com
        password : 54321
        login butonuna tıklayın
       değerleri girildiğinde sayfaya başarılı bir şekilde girilemediğini test et
     */
    @Test
    public void yanlisSifre() throws InterruptedException {

        Driver.getDriver().get(ConfigReader.getProperty("brcUrl"));

        Thread.sleep(1500);

        brcPage.ilkLoginButonu.click();

        brcPage.emailTextBox.sendKeys(ConfigReader.getProperty("brcValidEmail"));

        brcPage.passwordTextBox.sendKeys(ConfigReader.getProperty("brcWrongPassword"));

        brcPage.ikinciLoginButonu.click();

        Assert.assertTrue(brcPage.ikinciLoginButonu.isDisplayed());
    }

}
