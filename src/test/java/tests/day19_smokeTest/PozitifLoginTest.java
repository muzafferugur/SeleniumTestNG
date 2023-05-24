package tests.day19_smokeTest;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BrcPage;
import utilities.ConfigReader;
import utilities.Driver;

public class PozitifLoginTest {
    /*
    End to End Test(E2E): Bir uygulamanin tum adimlarini bastan sona kadar test etmek demektir.
Ornegin biz yonetici bir oda olusturabilir mi diye test yaptigimizda sisteme giristen oda olusturuldu
yazisi gorulunceye kadar tum adimlari test etmis oluruz, dolayisiyla E2E testi yapmis oluruz. Bu
testin diger adi da Sistem Testi’dir.
     */

    BrcPage brcPage = new BrcPage();

    /*
    1.https://www.bluerentalcars.com/ adresine git
    2.Login butonuna bas
    3.user email : customer@bluerentalcars.com
        password : 12345
        login butonuna tıklayın
       değerleri girildiğinde sayfaya başarılı bir şekilde giriş yap
     */
    @Test
    public void positiveLoginTest() {

        Driver.getDriver().get(ConfigReader.getProperty("brcUrl"));

        brcPage.ilkLoginButonu.click();

        brcPage.emailTextBox.sendKeys(ConfigReader.getProperty("brcValidEmail"));

        brcPage.passwordTextBox.sendKeys(ConfigReader.getProperty("brcValidPassword"));

        brcPage.ikinciLoginButonu.click();

        String actualUsername=brcPage.kullaniciProfilIsmi.getText();
        String expectedUsername=ConfigReader.getProperty("brcValidUsername");
        Assert.assertEquals(actualUsername, expectedUsername);

        Driver.closeDriver();

    }
}
