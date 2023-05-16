package tests.day19_smokeTest;

import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.Driver;

public class PozitifLoginTest {

    @Test
    public void test01() {

        Driver obj = new Driver();
        obj.getDriver().get(ConfigReader.getProperty("amazonUrl"));
    }
}
