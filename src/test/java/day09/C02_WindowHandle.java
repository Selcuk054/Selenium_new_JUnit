package day09;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_WindowHandle {
    //1- Amazon Sayfasina girelim
    //2- Url'nin amazon içerdiğini test edelim
    //3- Yeni bir pencere açıp bestbuy anasayfasına gidelim.(https://www.bestbuy.com)
   //4- title'in BestBuy içerdiğini test edelim
    //5- İlk sayfaya dönüp sayfada java aratalım
    //6- Arama sonuclarının java içerdiğini test edelim
    //7- Yeniden bestbuy sayfasına gidelim
    //8- Logonun görünürlüğünü test edelim
    //9- Sayfaları Kapatalım

    WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    @After
    public void tearDown() {
        //driver.quit();
    }
    @Test
    public void test1(){
        /*
       Eğer bize verilen task'te sayfalar arası geçiş varsa her driver.get() methodundan sonra
       driver'ın window handle değerini string bir değişkene atarız
       Sonrasında farklı bir sayfaya ya da sekmeye gittikten sonra tekrar ilk sayfaya dönmemiz istenirse
      String değişkene atadığımız window handle değerleriyle sayfalar arası geçiş yapabiliriz */

        //1- Amazon Sayfasina girelim
        driver.get("https://amazon.com");
        //2- Url'nin amazon içerdiğini test edelim
        String actuelUrl = driver.getCurrentUrl();
        String exceptedUrl = "amazon";
        Assert.assertTrue(actuelUrl.contains(exceptedUrl));
        String amazonHandle = driver.getWindowHandle();

        //3- Yeni bir pencere açıp bestbuy anasayfasına gidelim.(https://www.bestbuy.com)
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://www.bestbuy.com");
        String bestBuyWindowHandle = driver.getWindowHandle();
        //4- title'in BestBuy içerdiğini test edelim
        String expectedTitle = "Best Buy";
        String actuelTitle = driver.getTitle();
        Assert.assertTrue(actuelTitle.contains(expectedTitle));
        //5- İlk sayfaya dönüp sayfada java aratalım
        driver.switchTo().window(amazonHandle);
        WebElement searcbox=driver.findElement(By.id("twotabsearchtextbox"));
        searcbox.sendKeys("java", Keys.ENTER);
        //6- Arama sonuclarının java içerdiğini test edelim
        WebElement aramaSonucu =driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
        String arananKelime = "java";
        String actuelSonuc = aramaSonucu.getText();
        Assert.assertTrue(actuelSonuc.contains(arananKelime));
        //7- Yeniden bestbuy sayfasına gidelim
        driver.switchTo().window(bestBuyWindowHandle);
        //8- Logonun görünürlüğünü test edelim
       // WebElement logo=driver.findElement(By.xpath("//img[@alt='Best Buy Logo'"));
        driver.findElement(By.xpath("(//*[@class='logo'])[1]")).isDisplayed();


        //9- Sayfaları Kapatalım




    }
}
