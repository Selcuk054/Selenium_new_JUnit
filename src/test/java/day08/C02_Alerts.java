package day08;

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

public class C02_Alerts {
    /*
bir web sitesine girdigimizde karsımıza bir uyarı mesajı yada bir buttona tıkladığımızda bir uyarı cıkabilir
eğer bu uyarıya incele(mause sağ-tik inspect) yapabiliyorsak bu tür alert lere html alert denir.
ve istedigimiz locate'i alabiliriz. Ama gelen uyarı kutusuna müdahale (sağ tik inspect ile) edemiyorsak
bu tür alertlere  js alert denir.
js alert'lere müdahale edebilmek icin

-- tamam ya da ok icin
driver.switchTo().alert().accept();

--iptal icin
driver.switchTo().alert().dismiss();

--alert icindeki mesajı almak icin
driver.switchTo().alert().getText();

--alert bizden bir metin istiyorsa
driver.switchTo().alert().sendKeys("");

methodları kullanilir!!

 */
    /*
   ● Bir class olusturun: Alerts
     https://the-internet.herokuapp.com/javascript_alerts adresine gidin.
     ● Bir metod olusturun:
     acceptAlert butona tıklayın, uyarıdaki OK butonuna tıklayın ve result mesajının “You successfully clicked an alert” oldugunu test edin.

   ● Bir metod olusturun: dismissAlert
   ○ 2. butona tıklayın, uyarıdaki Cancel butonuna tıklayın ve result mesajının
  “successfuly” icermedigini test edin.
  ● Bir metod olusturun: sendKeysAlert
   ○ 3. butona tıklayın, uyarıdaki metin kutusuna isminizi yazin, OK butonuna tıklayın ve result mesajında isminizin görüntülendiğini doğrulayın.
*/
    WebDriver driver;
    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
    }
    @After
    public void tearDown(){
        //driver.quit();
    }
    @Test
    public void test1() throws InterruptedException {
        // AcceptAlert butona tıklayın, uyarıdaki OK butonuna tıklayın ve result mesajının “You successfully clicked an alert” oldugunu test edin.
        WebElement alertButton = driver.findElement(By.xpath("//*[text()='Click for JS Alert']"));
        alertButton.click();
        Thread.sleep(3000);
        String msj =driver.switchTo().alert().getText();
        driver.switchTo().alert().accept();
        String exceptedMsj = "You successfully clicked an alert";
        Assert.assertNotEquals(msj,exceptedMsj);
    }
    @Test
    public void test2() throws InterruptedException {
        //2. butona tıklayın, uyarıdaki Cancel butonuna tıklayın ve result mesajının “successfuly” icermedigini test edin.
        WebElement alertButton2 = driver.findElement(By.xpath("//*[text()='Click for JS Confirm']"));
        alertButton2.click();
        Thread.sleep(3000);
        String alertMsj = driver.switchTo().alert().getText();
        String expectedMsj = "successfuly";
        driver.switchTo().alert().dismiss();
        Assert.assertNotEquals(alertMsj,expectedMsj);
    }
    @Test
    public void test3(){

    }
}
