package tests.day21_reusableMethods_HTMLReports;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BrcPage;
import utilities.ConfigReader;
import utilities.Driver;

public class C03_PositiveLoginTestiRaporlu {

    BrcPage brcPage = new BrcPage();
    @Test
    public void positiveLoginTest() {

        Driver.getDriver().get(ConfigReader.getProperty("brcUrl"));

        brcPage.ilkLoginButonu.click();

        brcPage.emailTextBox.sendKeys(ConfigReader.getProperty("brcValidEmail"));

        brcPage.passwordTextBox.sendKeys(ConfigReader.getProperty("brcValidPassword"));

        brcPage.ikinciLoginButonu.click();

        String actualUsername = brcPage.kullaniciProfilIsmi.getText();
        String expectedUsername = ConfigReader.getProperty("brcValidUsername");
        Assert.assertEquals(actualUsername, expectedUsername);

        Driver.closeDriver();
    }
}
