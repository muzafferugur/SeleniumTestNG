package tests.day21_reusableMethods_HTMLReports;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BrcPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

public class C03_PositiveLoginTestiRaporlu extends TestBaseRapor {

    BrcPage brcPage = new BrcPage();
    @Test
    public void positiveLoginTest() {

        extentTest=extentReports.createTest("Pozitif Login", "Gecerli username ve sifre ile giris yapabilmeli");

        Driver.getDriver().get(ConfigReader.getProperty("brcUrl"));
        extentTest.info("Brc anasayfaya gidildi");

        brcPage.ilkLoginButonu.click();
        extentTest.info("Login butonuna tıklandı")

        brcPage.emailTextBox.sendKeys(ConfigReader.getProperty("brcValidEmail"));
        extentTest.info("Geçerli email yazıldı")

        brcPage.passwordTextBox.sendKeys(ConfigReader.getProperty("brcValidPassword"));
        extentTest.info("Geçerli sifre yazıldı");

        brcPage.ikinciLoginButonu.click();
        extentTest.info("İkinci Login butonuna tıklandı");

        String actualUsername = brcPage.kullaniciProfilIsmi.getText();
        String expectedUsername = ConfigReader.getProperty("brcValidUsername");
        Assert.assertEquals(actualUsername, expectedUsername);
        extentTest.pass("kullanıcı basarılı sekilde giris yaptı")

        Driver.closeDriver();
    }
}
