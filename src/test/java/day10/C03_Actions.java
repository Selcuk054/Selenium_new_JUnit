package day10;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBaseBeforeAfter;

import javax.swing.*;

public class C03_Actions extends TestBaseBeforeAfter {

    @Test
    public void test1() throws InterruptedException {
        // - Amazon sayfasina gidelim
        driver.get("https://amazon.com");
        // - Account menusunden create a list linkine tiklayalim
        WebElement accountList = driver.findElement(By.xpath("//*[text()='Hello, sign in']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(accountList).perform();
        /*
        Bir web sitesinde bir mouse ile acilan bir web elementine ulasmak istersek
        actions.moveToElement() methodunu kullanmamiz gerekir aksi takdirde html kodlari arasinda web elemti bulur ama
        ulasamadigi icin ElementNotInteractableException firlatir.
         */
        //Thread.sleep(2000);
        driver.findElement(By.xpath("//*[text()='Create a List']")).click();


    }
}
