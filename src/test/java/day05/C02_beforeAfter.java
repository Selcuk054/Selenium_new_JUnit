package day05;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_beforeAfter {
    WebDriver driver;
     // Before, After yada Test in siralamasi onemli degildir.
     @Before //Before notasyonu her testten once calisir
     //Before notasyonu her testen once calisir
     public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    @After // After notasyonu her testten sonra calisir
    public void tearDown(){
         driver.quit();

    }
    @Test
    public void method1(){
         //1 defa before methodu calisir
         driver.get("https://amazon.com");
         //1 defa after methodu calisir
    }
    @Test
    public void method2() {
        //1 defa before methodu calisir
        driver.get("https://www.bol.com/nl/nl/");
        //1 defa after methodu calisir
    }
    @Test
    public void method3() {
        //1 defa before methodu calisir
        driver.get("https://www.ebay.nl/");
        //1 defa after methodu calisir
    }
}
