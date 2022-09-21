package day11;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBaseBeforeAfter;

public class C01_Actions extends TestBaseBeforeAfter {
    @Test
    public void test1() {
        /*
        Bir Class olusturalim KeyboardActions1
        https://www.amazon.com sayfasina gidelim
         Arama kutusuna actions method’larine kullanarak  samsung A71 yazdirin ve Enter’a basarak arama  yaptirin
         aramanin gerceklestigini test edin
         */
        driver.get("https://www.amazon.com");
        //Arama kutusuna actions method’larine kullanarak  samsung A71 yazdirin ve Enter’a basarak arama  yaptirin
        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        action.click(searchBox).sendKeys("s").
                sendKeys("a").
                sendKeys("m").
                sendKeys("s").
                sendKeys("u").
                sendKeys("n").
                sendKeys("g").
                sendKeys(" ").
                keyDown(Keys.SHIFT).sendKeys("a").keyUp(Keys.SHIFT).//Shift e basip birakmasini sagliyoruz.
                sendKeys("7").sendKeys("1").sendKeys(Keys.ENTER).perform();
        WebElement aramaSonucu = driver.findElement(By.xpath("(//*[@class='a-section a-spacing-small a-spacing-top-small'])[1]"));
        Assert.assertTrue(aramaSonucu.isDisplayed());

    }
}
