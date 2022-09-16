package day06;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Odev_MailDogrulama {
  /*
  1. Bir Class olusturalim YanlisEmailTesti
  2. http://amazon.com sayfasina gidelim
  3. Sign in butonuna basalim
  4. Email kutusuna @isareti olmayan bir mail yazip enter’a bastigimizda “Invalid email address” uyarisi ciktigini test edelim

*/
    static WebDriver driver;
    @BeforeClass
    public static void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }
    @AfterClass
    public static void tearDown(){
        driver.quit();
    }
    @Test
    public void test1(){
       // http://amazon.com sayfasina gidelim
        //Sign in butonuna basalim
        driver.get("http://amazon.com");
    }
    @Test
    public void test2(){
       // 3. Sign in butonuna basalim
        WebElement signIn = driver.findElement(By.xpath("(//*[@class='nav-line-2'])[3] "));
        signIn.click();

    }
    @Test
    public void test3() throws InterruptedException {
        //Email kutusuna @isareti olmayan bir mail yazip enter’a bastigimizda “There was a problem” uyarisi ciktigini test edelim
        WebElement signInBox = driver.findElement(By.xpath("(//*[@id='ap_email'])[1]"));

        signInBox.sendKeys("HoeIsHetMetJe?", Keys.ENTER);

        WebElement invalid = driver.findElement(By.xpath("(//*[@class='a-box-inner a-alert-container'])[1]"));
        Assert.assertTrue(invalid.isDisplayed());
    }
}
