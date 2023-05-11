package tests.day16_notations;

import org.testng.annotations.Test;
import utilities.TestBase;

public class C03_Priority extends TestBase {
    /*
    TestNG test methodlarını isim sıralamasına göre çalıştırır. eğer isim sıralamasının dışında bir sıralama ile
    çalışmasını isterseniz o zaman test methodlarına öncelik (priority) tanımlayabiliriz.

    Priority küçükten büyüğe doğru çalışır. Eğer bir teset methoduna priority değeri atanmamışsa
    default olarak priorty=0 kabul edilir.

    priority ne kadar küçükse önce o çalışır. aynıysa isim sıralaması
     */

    @Test(priority = -5)
    public void amazonTesti() {
        driver.get("https://www.amazon.com");
    }

    @Test(priority = -2)
    public void test02() {
        driver.get("https://www.bestbuy.com");
    }

    @Test
    public void techproedTesti() {
        driver.get("https://www.techproeducation.com");
    }
}
