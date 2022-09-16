package day07;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_Assertions {
   /* Bir Class olusturalim YanlisEmailTesti
    http://automationpractice.com/index.php sayfasina gidelim
    Sign in butonuna basalim
    Email kutusuna @isareti olmayan bir mail yazip enter’a
    bastigimizda “Invalid email address” uyarisi ciktigini test edelim
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
       // driver.quit();
    }
    @Test
    public void test1() throws InterruptedException {
        //http://automationpractice.com/index.php sayfasina gidelim
        driver.get("http://automationpractice.com/index.php");
        // Sign in butonuna basalim
        driver.findElement(By.xpath("(//*[@class='login'])[1]")).click();
        //Email kutusuna @isareti olmayan bir mail yazip enter’a
        WebElement emailBox = driver.findElement(By.id("email_create"));
        emailBox.sendKeys("sawonef", Keys.ENTER);
        Thread.sleep(3000);
        // Email kutusuna @isareti olmayan bir mail yazip enter’a
        //    bastigimizda “Invalid email address” uyarisi ciktigini test edelim
        WebElement accountError = driver.findElement(By.xpath("//ol/li[.='Invalid email address.']"));
        System.out.println("accountError.getText() = " + accountError.getText());
        Assert.assertTrue("Account Error Message",accountError.getText().contains("Invalid email address"));

    }
}
