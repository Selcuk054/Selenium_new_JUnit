package day07;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

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
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("http://zero.webappsecurity.com/");
    }
    @After
    public void tearDown(){
        driver.quit();
    }
    @Test
    public void test1() throws InterruptedException {
        // 2. Sign in butonuna basin
        WebElement signIn = driver.findElement(By.xpath("//*[@id='signin_button']"));
        signIn.click();
        // 3. Login kutusuna “username” yazin
        WebElement login = driver.findElement(By.xpath("//*[@id='user_login']"));
        login.sendKeys("username");
        // 4. Password kutusuna “password” yazin
        WebElement password = driver.findElement(By.xpath("//*[@id='user_password']"));
        password.sendKeys("password");
        //5. Sign in tusuna basin
        WebElement signIn2 = driver.findElement(By.xpath("//*[@class='btn btn-primary']"));
        signIn2.click();
        // 6. Pay Bills sayfasina gidin
        driver.navigate().back(); //Burada geri gelip
        driver.findElement(By.xpath("(//*[text()='Online Banking'])[1]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("(//*[@id='pay_bills_link'])[1]")).click();
        Thread.sleep(3000);
        // 7. “Purchase Foreign Currency” tusuna basin.
        driver.findElement(By.xpath("(//*[text()='Purchase Foreign Currency'])[1]")).click();
        //8. “Currency” drop down menusunden Eurozone’u secin
        WebElement currency = driver.findElement(By.xpath("(//*[@id='pc_currency'])[1]"));
        Select menu = new Select(currency);
        menu.selectByVisibleText("Eurozone (euro)");
        Thread.sleep(2000);
        //9. “amount” kutusuna bir sayi girin
       WebElement amountBox = driver.findElement(By.xpath("(//*[@id='pc_amount'])[1]"));
       amountBox.sendKeys("300");
       Thread.sleep(2000);
       //10. “US Dollars” in secilmedigini test edin
       WebElement dollarButton = driver.findElement(By.id("pc_inDollars_true"));
       if (!dollarButton.isSelected()){
           System.out.println("Dollar Button is not Selected");
       }
       // 11. “Selected currency” butonunu secin
        driver.findElement(By.id("pc_inDollars_false")).click();

       //12. “Calculate Costs” butonuna basin sonra “purchase” butonuna basin
        driver.findElement(By.id("pc_calculate_costs")).click();
        Thread.sleep(2000);
        driver.findElement(By.id("purchase_cash")).click();
        Thread.sleep(2000);
        //13. “Foreign currency cash was successfully purchased.” yazisinin ciktigini kontrol edin.
        WebElement alert = driver.findElement(By.xpath("(//*[@id='alert_content'])[1]"));
        Assert.assertTrue(alert.isDisplayed());



    }

}
