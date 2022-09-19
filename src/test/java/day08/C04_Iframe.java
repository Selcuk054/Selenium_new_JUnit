package day08;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class C04_Iframe {
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
        //Bu adrese gidiniz
        //Youtube videosunu calistiriniz
        driver.get("https://html.com/tags/iframe/");
        /*
        Bir web sitesinde bir video varsa <Iframe > tag i icerisindeyse bu videoyu direkt locate edip
        calistirmak dinamik olmaz cunku link degisebilir ve locate imiz calismaz.
        Bunun icin butun frame leri bir array liste atip index ile framei secip sonrasida play
        tusunu locate edip calistirabiliriz.
         */
        List<WebElement> iframeList= new ArrayList<>(driver.findElements(By.xpath("//iframe)")));
        driver.switchTo().frame(iframeList.get(0));
        driver.findElement(By.xpath("(//*[@aria-label='Afspelen'])")).click();


    }
}