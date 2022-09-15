package day05;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_BeforeClassAfterClass {
    /*
    BeforeClass ve Afterclass notasyonlari kullaniyorsak olusturacagimiz methodu static yapmamiz gerekiyor
     */
    static WebDriver driver;
    @BeforeClass
    public  static void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    @AfterClass
    public static void tearDown(){
        driver.quit();
    }
    @Test
    @Ignore //Test olmasini istemedigimiz methoda bunu yaziyoruz ve calismiyor
    public void method1(){
        driver.get("https://amazon.com");
    }
    @Test

    public void method2(){
        driver.get("https://ebay.nl");
    }
    @Test

    public void method3(){
        driver.get("https://www.bol.com/nl/nl/");
    }
}
