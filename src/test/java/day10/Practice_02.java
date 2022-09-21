package day10;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBaseBeforeAfter;

public class Practice_02 extends TestBaseBeforeAfter {
    //1-Amazon sayfasına gidelim
    //2-All menüsünden Electronics linkine tıklayalım
    //3-Television & Video 'ya tıklayın
    //4-ve sonucu yazdırın
    @Test
    public void test1() throws InterruptedException {
        //1-Amazon sayfasına gidelim
        driver.get("https://amazon.com");
        //2-All menüsünden Electronics linkine tıklayalım
        WebElement allMenu = driver.findElement(By.xpath("//*[@class='hm-icon nav-sprite']"));
        Thread.sleep(2000);
        action.moveToElement(allMenu).click().perform();
        WebElement electronic = driver.findElement(By.xpath("(//*[text()='Electronics'])[3]"));
        Thread.sleep(2000);
        action.moveToElement(electronic).click().perform();
        //3-Television & Video 'ya tıklayın
        WebElement televizyon = driver.findElement(By.xpath("//*[text()='Television & Video']"));
        Thread.sleep(2000);
        action.moveToElement(televizyon).click().perform();
        //Sonucu yazdirin
        System.out.println(driver.findElement(By.xpath("//*[text()='1-24 of over 30,000 results']")).getText());
    }
}
