package day10;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBaseBeforeAfter;

public class Practice extends TestBaseBeforeAfter {
    /*
    //1-https://amazon.com sayfasına gidin
    //2-Sağ üst bölümde bulunan "Account & Lists" menüsünün açılması için
    // mouse'u bu menünün üstüne getirelim
    //3-"Create a list" butonuna basalım
    //4-Açılan sayfada"Your Lists" yazısı olduğunu test edelim
    */
    @Test
    public void test1(){
        //1-https://amazon.com sayfasına gidin
        driver.get("https://amazon.com");
        //2-Sağ üst bölümde bulunan "Account & Lists" menüsünün açılması için mouse'u bu menünün üstüne getirelim
        WebElement account = driver.findElement(By.id("nav-link-accountList-nav-line-1"));
        action.moveToElement(account).perform();
        //3-"Create a list" butonuna basalım
        driver.findElement(By.xpath("//*[text()='Create a List']")).click();
        //4-Açılan sayfada"Your Lists" yazısı olduğunu test edelim
        String excepted = "Your Lists";
        String actuel = driver.findElement(By.xpath("//*[@role='heading']")).getText();
        Assert.assertEquals(excepted,actuel);


    }



}
