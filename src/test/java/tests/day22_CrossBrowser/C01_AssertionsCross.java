package tests.day22_CrossBrowser;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

public class C01_AssertionsCross extends TestBase {
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

        driver.get("https://www.amazon.com");

        String expectedTitle = "Amazon";
        String actualTitle = driver.getTitle();
        Assert.assertTrue(actualTitle.contains(expectedTitle));

        WebElement aramaKutusu = driver.findElement(By.id("twotabsearchtextbox"));
        Assert.assertTrue(aramaKutusu.isEnabled());

        aramaKutusu.sendKeys("Nutella" + Keys.ENTER);

        WebElement sonucYazisiElementi = driver.findElement(By.xpath("//h1[@class='a-size-base s-desktop-toolbar a-text-normal']"));
        Assert.assertTrue(sonucYazisiElementi.isDisplayed());

        Assert.assertTrue(sonucYazisiElementi.getText().contains("Nutella"));


    }
}
