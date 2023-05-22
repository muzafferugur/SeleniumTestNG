package tests.day21_reusableMethods_HTMLReports;

import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.io.IOException;

public class C02_ScreenShotReusableMethods {
    @Test
    public void test01() throws IOException {

        //amazon sayfasına gidip fotoğrafını çekelim
        Driver.getDriver().get(ConfigReader.getProperties("amazonUrl"));
        ReusableMethods.getScreenshot("amazon");
        Driver.closeDriver();

    }
}
