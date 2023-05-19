package tests.day16_notations;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class C04_DependsOnMethods {
    /*
    DependsOnMethods testt methodlarının çalışma sıralamasına karışmaz
    Sadece bağlı olan test, bağlandığı testin sonucuna bakar. Bağlandığı tset PASSED
    olmazsa bağlanan test hiç çalışmaz(ignore)
     */
    WebDriver driver;

    @BeforeClass
    public void Setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }

    @AfterClass
    public void tearDown() {
        driver.close();
    }

    @Test
    public void test01() {
        driver.get("https://www.amazon.com");
    }

    @Test(dependsOnMethods = "test01")
    public void test02() {
        WebElement aramaKutusu = driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("Nutella" + Keys.ENTER);

    }

    @Test(dependsOnMethods = "test02")
    public void test03() {
        WebElement sonucYazisiElementi = driver.findElement(By.xpath("//h1[@class='a-size-base s-desktop-toolbar a-text-normal']"));
        Assert.assertTrue(sonucYazisiElementi.getText().contains("Nutella"));

    }

    @Test(groups = {"grup1", "grup2"})
    public void test04() {
        System.out.println("bak bu calıştı");
    }
}
