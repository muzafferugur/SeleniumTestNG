package tests.day17_pom;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AmazonPage;
import utilities.Driver;

public class C02_PageClassKullanimi {
    @Test
    public void test01() {
        AmazonPage amazonPage = new AmazonPage();
        /*
        amazona gidelim ve nutella aratalım,
        sonuç yazısının nutella içerdiğini test edelim
         */

        Driver.getDriver().get("https://www.amazon.com");
        amazonPage.aramaKutusu.sendKeys("nutella" + Keys.ENTER);

        String actualSonuc = amazonPage.aramaSonucElementi.getText();
        String expectedKelime = "nutella";

        Assert.assertTrue(actualSonuc.contains(expectedKelime));

    }
}
