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
        //faker class in i kullanma amacimiz form doldurmamiz gereken web sitelerde defalarca kendi uretecegimiz
       // veriler yerine bizim için random veriler üretir ve işimizi kolaylaştırır.
        // faker class'i kullanmak icin mvn repository.com adresinden java faker kütüphanesinin aratir
        // ve en cok kullanilani pom.xml dosyamiza ekleriz
        // ve faker class'indan bir obje olusturup email icin faker.internet methodunu kullanarak
        // emailAdress() methodunu seceriz
        // password icinde ayni internet methodunu kullaniriz
        // isim ve soyisimler icin faker.name() methodu ile firstname() ve lastname() methodunu kullaniriz


       // "https://facebook.com"  Adresine gidin
        driver.get("https://facebook.com");
       //“create new account”  butonuna basin
        driver.findElement(By.xpath("//*[@class='_42ft _4jy0 _9xo6 _4jy3 _4jy1 selected _51sy']")).click();
        driver.findElement(By.xpath("//*[@class='_42ft _4jy0 _6lti _4jy6 _4jy2 selected _51sy']")).click();
        //“firstName” giris kutusuna bir isim yazin
        Faker faker = new Faker();
        WebElement naam = driver.findElement(By.xpath("(//*[@class='inputtext _58mg _5dba _2ph-'])[1]"));
       String email = faker.internet().emailAddress(); //Ayni mail adresini girmesi icin string bir dergiskene atama yaptik
        action.click(naam).sendKeys(faker.name().firstName()).sendKeys(Keys.TAB)
                .sendKeys(faker.name().lastName()).sendKeys(Keys.TAB)
                .sendKeys(email).sendKeys(Keys.TAB).sendKeys(faker.internet().password()).sendKeys(Keys.TAB).sendKeys(Keys.TAB).
                sendKeys("5").sendKeys(Keys.TAB).sendKeys("Oct").
                sendKeys(Keys.TAB).sendKeys("1985").sendKeys(Keys.TAB).sendKeys(Keys.TAB)
                .sendKeys(Keys.RIGHT).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).
                sendKeys(Keys.TAB).sendKeys(Keys.ENTER).perform();
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
