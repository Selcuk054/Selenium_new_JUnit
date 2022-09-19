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

public class C05_Hw1 {
    WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    @After
    public void tearDown() {
        //driver.quit();
    }
    @Test
    public void test1() {
/*
● Bir class olusturun: IframeTest
● https://the-internet.herokuapp.com/iframe adresine gidin.
● Bir metod olusturun: iframeTest
○“AnIFramecontaining....”textinin erisilebilir oldugunu test edin ve konsolda yazdirin
○Text Box’a “Merhaba Dunya!” yazin.
○TextBox’in altinda bulunan “Elemental Selenium” linkini textinin gorunur oldugunu dogrulayinve konsoldayazdirin.
 */
        driver.get("https://the-internet.herokuapp.com/iframe");
        //○“An IFrame containing....”textinin erisilebilir oldugunu test edin ve konsolda yazdirin
        WebElement anIframe = driver.findElement(By.xpath("//h3"));

        if (anIframe.isDisplayed()){
            System.out.println("An IFrame containing is Displayed");
        }else System.out.println("An IFrame containing is not Displayed");
        //Text box a Hello Wereld yazdir

        WebElement IframeBox =driver.findElement(By.xpath("//*[@title='Rich Text Area']"));
        driver.switchTo().frame(IframeBox);
        WebElement box = driver.findElement(By.xpath("//*[@id='tinymce']"));
        box.sendKeys("Hallo Wereld");

        //TextBox’in altinda bulunan “Elemental Selenium” linkini textinin gorunur oldugunu dogrulayinve konsoldayazdirin.
        WebElement elemental = driver.findElement(By.xpath("//*[text()='Elemental Selenium']"));
        Assert.assertTrue(elemental.isDisplayed());
        System.out.println(elemental.getText());


    }

}
