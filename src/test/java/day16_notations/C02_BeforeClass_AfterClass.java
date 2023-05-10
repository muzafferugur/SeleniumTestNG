package day16_notations;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utilities.TestBase;

public class C02_BeforeClass_AfterClass extends TestBase {
/*
JUnitde @BeforeClass ve @AfterClass notasyonuna sahip methodlar static olmak ZORUNDAYDI.
TestNG bu zorunluluktan bizi kurtarıyor.

TestNG bize daha fazla before ve after notasyonları sunar.
Diğer before/after notasyonları tanımlayacağımız grup,test veya suit den önce ve sonra çalısırlar.
ileride xml dosyaları ile birlikte bunu göreceğiz.
 */

    @BeforeClass
    public void beforeClassMethod() {
        System.out.println("Before class");
    }

    @AfterClass
    public void afterClassMethod() {
        System.out.println("After class");

    }

    @Test
    public void amazonTesti() {
        driver.get("https://www.amazon.com");
    }

    @Test
    public void test02() {
        driver.get("https://www.bestbuy.com");
    }

    @Test
    public void techproedTesti() {
        driver.get("https://www.techproeducation.com");
    }
}
