package day06;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Odev_YoutubeAssertion {
 /*   1) Bir class oluşturun: YoutubeAssertions
      2) https://www.youtube.com adresine gidin
      3) Aşağıdaki adları kullanarak 3 test metodu oluşturun ve gerekli testleri yapin
         ○ titleTest => Sayfa başlığının “YouTube” oldugunu test edin
         ○ imageTest => YouTube resminin görüntülendiğini (isDisplayed()) test edin
         ○ Search Box 'in erisilebilir oldugunu test edin (isEnabled())
         ○ wrongTitleTest => Sayfa basliginin “youtube” olmadigini dogrulayin
  */
    WebDriver driver;
    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver =new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        //2) https://www.youtube.com adresine gidin
        driver.get("https://www.youtube.com");
    }
    @After
    public void tearDown(){
        driver.quit();
    }
    @Test
    public void titleTest(){
        //Sayfa başlığının “YouTube” oldugunu test edin
        //Varsa cokies reddet
        driver.findElement(By.xpath("(//*[@class='style-scope ytd-button-renderer style-primary size-default'])[1]")).click();
        String expectedTitle = "YouTube";
        String actuelTitle = driver.getTitle();

        Assert.assertEquals(actuelTitle, expectedTitle);
    }
    @Test
    public void imageTest(){
        //○ imageTest => YouTube resminin görüntülendiğini (isDisplayed()) test edin
       WebElement image = driver.findElement(By.xpath("(//*[@class='style-scope ytd-logo'])[1]"));
       Assert.assertTrue(image.isDisplayed());
    }
    @Test
    public void wrongTitleTest(){
        // ○ wrongTitleTest => Sayfa basliginin “youtube” olmadigini dogrulayin
        String expectedTitle = "youtube";
        String actuelTitle = driver.getTitle();
        Assert.assertNotEquals(expectedTitle,actuelTitle);
    }
}
