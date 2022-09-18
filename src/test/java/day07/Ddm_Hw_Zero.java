package day07;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Ddm_Hw_Zero {
    /*
     1. http://zero.webappsecurity.com/ Adresine gidin
     2. Sign in butonuna basin
     3. Login kutusuna “username” yazin
     4. Password kutusuna “password.” yazin
     5. Sign in tusuna basin
     6. Pay Bills sayfasina gidin
     7. “Purchase Foreign Currency” tusuna basin
     8. “Currency” drop down menusunden Eurozone’u secin
     9. “amount” kutusuna bir sayi girin
     10. “US Dollars” in secilmedigini test edin
     11. “Selected currency” butonunu secin
     12. “Calculate Costs” butonuna basin sonra “purchase” butonuna basin
     13. “Foreign currency cash was successfully purchased.” yazisinin ciktigini kontrol edin.
     */
    WebDriver driver;
    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("http://zero.webappsecurity.com/");
    }
    @After
    public void tearDown(){
        driver.quit();
    }

}
