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
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class Ddm_deneme {
    /*
    Bir class oluşturun: C3_DropDownAmazon ● https://www.amazon.com/ adresine gidin.
    - Test 1
    Arama kutusunun yanindaki kategori menusundeki kategori sayisinin 45 oldugunu test edin
    -Test 2
    1. Kategori menusunden Books secenegini secin
    2. Arama kutusuna Java yazin ve aratin
    3. Bulunan sonuc sayisini yazdirin
    4. Sonucun Java kelimesini icerdigini test edin
     */

    static WebDriver driver;

    @BeforeClass

    public static void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.amazon.com/");
    }
    @AfterClass
    public static void tearDown(){
        //driver.quit();
    }
    @Test
    public void test1(){
        // Arama kutusunun yanindaki kategori menusundeki kategori sayisinin 45 olmadigini test edin
        WebElement ddm = driver.findElement(By.xpath("(//*[@id='searchDropdownBox'])[1]"));
        Select options = new Select(ddm);
        List<WebElement> listem = options.getOptions();
        Assert.assertNotEquals(listem.size(),45);
    }
    @Test
    public void test2(){
        //1. Kategori menusunden Books secenegini secin
        WebElement ddm = driver.findElement(By.xpath("(//*[@id='searchDropdownBox'])[1]"));
        Select options = new Select(ddm);
        options.selectByVisibleText("Books");

        // 2. Arama kutusuna Java yazin ve aratin
       WebElement searchBox =  driver.findElement(By.id("twotabsearchtextbox"));
       searchBox.sendKeys("Java", Keys.ENTER);

        // 3. Bulunan sonuc sayisini yazdirin
        WebElement result =driver.findElement(By.xpath("(//*[@class='a-section a-spacing-small a-spacing-top-small'])[1]"));
        System.out.println(result.getText());
        //4. Sonucun Java kelimesini icerdigini test edin
    }





}
