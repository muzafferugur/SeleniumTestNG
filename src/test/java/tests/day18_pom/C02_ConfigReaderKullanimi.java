package tests.day18_pom;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.FacebookPage;
import utilities.ConfigReader;
import utilities.Driver;

public class C02_ConfigReaderKullanimi {
    @Test
    public void test01() {
         /*
        1.Facebook anasayfaya gidin
        2.Kullanıcı mail kutusuna yanlış kullanıcı ismi yazdırın
        3.Kullanıcı şifre kutusuna yanlış bir password yazdırın
        4.Login butonuna basın
        5.Giriş yapılamadığını test edin
        6.Sayfayı kapatın
         */

        FacebookPage facebookPage = new FacebookPage();

        Driver.getDriver().get(ConfigReader.getProperties("facebookUrl"));

        facebookPage.mailKutusu.sendKeys(ConfigReader.getProperties("fbWrongUsername"));

        facebookPage.sifreKutusu.sendKeys(ConfigReader.getProperties("fbWrongPassword"));

        facebookPage.loginTusu.click();

        Assert.assertTrue(facebookPage.girilmediYaziElementi.isDisplayed());

        Driver.closeDriver();

    }
}
