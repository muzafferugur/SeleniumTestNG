package tests.day17_pom;

import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.FacebookPage;
import utilities.Driver;

public class C03_PageClassKullanimi {
    @Test
    public void test01() {
        /*
        1.Facebook anasayfaya gidin
        2.Kullanıcı mail kutusuna rastgele isim yazdırın
        3.Kullanıcı şifre kutusuna rastgele bir password yazdırın
        4.Login butonuna basın
        5.Giriş yapılamadığını test edin
         */
        FacebookPage facebookPage = new FacebookPage();

        Driver.getDriver().get("https://www.facebook.com");

        Faker faker = new Faker();
        facebookPage.mailKutusu.sendKeys(faker.internet().emailAddress());

        facebookPage.sifreKutusu.sendKeys(faker.internet().password());

        facebookPage.loginTusu.click();

        Assert.assertTrue(facebookPage.girilmediYaziElementi.isDisplayed());

        Driver.closeDriver();


    }
}
