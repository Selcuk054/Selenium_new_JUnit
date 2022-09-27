package practice04;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBaseBeforeAfter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P01 extends TestBaseBeforeAfter {
    // go to the URL https://www.jqueryscript.net/demo/Easy-iFrame-based-Twitter-Emoji-Picker-Plugin-jQuery-Emoojis/
    // ikinci emojiye tıklayın (hayvan emojisini seçin)
   // tüm hayvan emojilerine tıklayın
   // formu doldurun (dilediğinizi yazabilirsiniz)
   // apply butonuna tıklayın

    @Test
    public void test1() {
        driver.get("https://www.jqueryscript.net/demo/Easy-iFrame-based-Twitter-Emoji-Picker-Plugin-jQuery-Emoojis/");
        // ikinci emojiye tıklayın (hayvan emojisini seçin)

        WebElement iframe = driver.findElement(By.xpath("//iframe[@id='emoojis']"));
        driver.switchTo().frame(iframe);
        driver.findElement(By.xpath("(//span[@class='mdl-tabs__ripple-container mdl-js-ripple-effect'])[2]")).click();
        // tüm hayvan emojilerine tıklayın
        List<WebElement> animals =driver.findElements(By.xpath("//div[@class='mdl-tabs__panel is-active']/div/img"));

        animals.forEach(t->t.click()); //lambda ile
        driver.switchTo().defaultContent();

        // formu doldurun (dilediğinizi yazabilirsiniz)
        List<WebElement> boxes = driver.findElements(By.xpath("(//input[@class='mdl-textfield__input'])"));

        //Bu list i kullanarak her bir web elementi kolayca boxes listinde bulunanweb elementlerimize gonderebilecegiz
        List<String> text = new ArrayList<>(Arrays.asList("Bu","list","kullanarak","her","web","elementi","kolayca","boxes","listinde","bulunan","web","elementlerimize"));
        for (int i = 0; i < boxes.size(); i++) {
            boxes.get(i).sendKeys(text.get(i));
        }

        // apply butonuna tıklayın
        driver.findElement(By.xpath("//*[@id='send']")).click();





    }
}
