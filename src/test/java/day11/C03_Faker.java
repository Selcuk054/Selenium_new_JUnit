package day11;

import com.github.javafaker.Faker;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBaseBeforeAfter;

public class C03_Faker extends TestBaseBeforeAfter {
    @Test
    public void test1() {
       // "https://facebook.com"  Adresine gidin
        driver.get("https://facebook.com");
       //“create new account”  butonuna basin
        driver.findElement(By.xpath("//*[@class='_42ft _4jy0 _9xo6 _4jy3 _4jy1 selected _51sy']")).click();
        driver.findElement(By.xpath("//*[@class='_42ft _4jy0 _6lti _4jy6 _4jy2 selected _51sy']")).click();
        //“firstName” giris kutusuna bir isim yazin
        Faker faker = new Faker();
        WebElement naam = driver.findElement(By.xpath("(//*[@class='inputtext _58mg _5dba _2ph-'])[1]"));
       String email = faker.internet().emailAddress();
        action.click(naam).sendKeys(faker.name().firstName()).sendKeys(Keys.TAB)
                .sendKeys(faker.name().lastName()).sendKeys(Keys.TAB)
                .sendKeys(email).
        //“surname” giris kutusuna bir soyisim yazin
         //“email” giris kutusuna bir email yazin
        //“email” onay kutusuna emaili tekrar yazin
        //Bir sifre girin
        //Tarih icin gun secin
       // Tarih icin ay secin
       // Tarih icin yil secin
       // Cinsiyeti secin
       // Kaydol butonuna basın
       // Sayfayi kapatin

    }
}
