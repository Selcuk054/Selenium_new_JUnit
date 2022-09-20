package day10;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBaseBeforeAfter;

public class C04_Actions extends TestBaseBeforeAfter {
    /*
1-Yeni bir class olusturalim: MouseActions1
2-https://the-internet.herokuapp.com/context_menu sitesine gidelim
3- Cizili alan uzerinde sag click yapalim
3-Alert'te cikan yazinin "You selected a context menu" oldugunu
4-test edelim.
5-Tamam diyerek alert'i kapatalim
6-Elemental Selenium linkine tiklayalim
7-Acilan sayfada h1 taginda "Elemental Selenium" yazdigini test edelim
  */

    @Test
    public void test1(){
       //2-https://the-internet.herokuapp.com/context_menu sitesine gidelim
       driver.get("https://the-internet.herokuapp.com/context_menu");
        //Cizili alan uzerinde sag click yapalim
        WebElement cizgiliAlan = driver.findElement(By.xpath("//*[@id='hot-spot']"));
        Actions actions = new Actions(driver);
        actions.contextClick(cizgiliAlan).perform();
        //Alert’te cikan yazinin “You selected a context menu” oldugunu test edelim.
        String expectedAlertYazisi = "You selected a context menu";
        String actualAlertYazisi = driver.switchTo().alert().getText();
        Assert.assertEquals(expectedAlertYazisi,actualAlertYazisi);
        //Assert.assertEquals("You selected a context menu",driver.switchTo().alert().getText());

        //Tamam diyerek alert’i kapatalim
        driver.switchTo().alert().accept();
        //Elemental Selenium linkine tiklayalim
        //Acilan sayfada h1 taginda “Elemental Selenium” yazdigini test edelim
    }
    }



}
