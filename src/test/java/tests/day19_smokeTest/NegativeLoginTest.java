package tests.day19_smokeTest;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BrcPage;
import utilities.ConfigReader;
import utilities.Driver;

public class NegativeLoginTest {
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

        Driver.getDriver().get(ConfigReader.getProperties("brcUrl"));

        Thread.sleep(1500);

        brcPage.ilkLoginButonu.click();

        brcPage.emailTextBox.sendKeys(ConfigReader.getProperties("brcValidEmail"));

        brcPage.passwordTextBox.sendKeys(ConfigReader.getProperties("brcWrongPassword"));

        brcPage.ikinciLoginButonu.click();

        Assert.assertTrue(brcPage.ikinciLoginButonu.isDisplayed());
    }

}
