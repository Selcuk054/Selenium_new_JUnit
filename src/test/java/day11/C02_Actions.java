package day11;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBaseBeforeAfter;

public class C02_Actions extends TestBaseBeforeAfter {
    @Test
    public void test1() throws InterruptedException {
        // 1- https://www.facebook.com adresine gidelim
        // 2- Yeni hesap olustur butonuna basalim
        // 3- Ad, soyad, mail ve sifre kutularina deger yazalim ve kaydol tusuna basalim

        driver.get("https://www.facebook.com");
        // 2- Yeni hesap olustur butonuna basalim
        driver.findElement(By.xpath("//*[@class='_42ft _4jy0 _9xo6 _4jy3 _4jy1 selected _51sy']")).click();
        driver.findElement(By.xpath("//*[@class='_42ft _4jy0 _6lti _4jy6 _4jy2 selected _51sy']")).click();
        // 3- Ad, soyad, mail ve sifre kutularina deger yazalim ve kaydol tusuna basalim
        WebElement naam = driver.findElement(By.xpath("(//*[@class='inputtext _58mg _5dba _2ph-'])[1]"));
        naam.sendKeys("Selcuk");
        Thread.sleep(2000);
        action.sendKeys(Keys.TAB).sendKeys("Kardes").
                sendKeys(Keys.TAB).sendKeys("784659134@gmail.com")
                .sendKeys(Keys.TAB).sendKeys("UfukNasilsin").
                sendKeys(Keys.TAB).sendKeys("UfukNasilsin").
                sendKeys(Keys.TAB). sendKeys(Keys.TAB).
                sendKeys("5").sendKeys(Keys.TAB).
                sendKeys("Okt").sendKeys(Keys.TAB).
                sendKeys("2000").sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.RIGHT).click().sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.ENTER).
                perform();
        driver.findElement(By.xpath("//*[@class='_6j mvm _6wk _6wl _58mi _3ma _6o _6v']"));



    }
}
