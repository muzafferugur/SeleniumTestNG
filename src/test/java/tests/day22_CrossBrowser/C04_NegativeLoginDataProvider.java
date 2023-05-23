package tests.day22_CrossBrowser;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.BrcPage;
import utilities.ConfigReader;
import utilities.Driver;

public class C04_NegativeLoginDataProvider {

    BrcPage brcPage = new BrcPage();

    @DataProvider
    public static Object[][] kullaniciListesi() {

        Object[][] kullaniciBilgileri ={{"firuze@senazlibircicek.com", "54678"},
                                                            {"murat@derdinekederalayina.com","65784"},
                                                            {"ilyas@merhabaaleyküm.com", "123456"}};
        return kullaniciBilgileri;
    }

    /*
    1.https://www.bluerentalcars.com/ adresine git
    2.Login butonuna bas
    3.user email : data providerdan alalım
        password : data providerdan alalım
        login butonuna tıklayın
       değerleri girildiğinde sayfaya başarılı bir şekilde girilemediğini test et
     */
    @Test(dataProvider = "kullaniciListesi")
    public void yanlisSifre(String userEmail, String password) throws InterruptedException {

        Driver.getDriver().get(ConfigReader.getProperties("brcUrl"));

        Thread.sleep(1500);

        brcPage.ilkLoginButonu.click();

        brcPage.emailTextBox.sendKeys(userEmail);

        brcPage.passwordTextBox.sendKeys(password);

        brcPage.ikinciLoginButonu.click();

        Assert.assertTrue(brcPage.ikinciLoginButonu.isDisplayed());
    }
}
