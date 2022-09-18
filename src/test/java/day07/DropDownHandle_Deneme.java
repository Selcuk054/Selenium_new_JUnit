package day07;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class DropDownHandle_Deneme {
   /* Bir class oluşturun: DropDown
● https://the-internet.herokuapp.com/dropdown adresine gidin.
    1.Index kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
    2.Value kullanarak Seçenek 2'yi (Option 2) seçin ve yazdırın
    3.Visible Text(Görünen metin) kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın 4.Tüm dropdown değerleri(value) yazdırın
    5. Dropdown’un boyutunu bulun, Dropdown’da 4 öğe varsa konsolda True , degilse False yazdırın.*/


    static WebDriver driver;

    @BeforeClass
    public static void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://the-internet.herokuapp.com/dropdown");
    }
    @AfterClass
    public static void tearDown(){
        driver.quit();
    }
    @Test
    public void test1(){
        // 1.Index kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
        WebElement ddm = driver.findElement(By.xpath("//select[@id='dropdown']"));
        Select options=new Select(ddm);
        options.selectByIndex(1);
        System.out.println(options.getFirstSelectedOption().getText()); //Secenegi yazdirmak icin.
        //2.Value kullanarak Seçenek 2'yi (Option 2) seçin ve yazdırın
        options.selectByValue("2");
        System.out.println(options.getFirstSelectedOption().getText());
        System.out.println("=================");
        //3.Visible Text(Görünen metin) kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
        options.selectByVisibleText("Option 1");
        System.out.println(options.getFirstSelectedOption().getText());
        options.selectByVisibleText("Option 2");
        System.out.println(options.getFirstSelectedOption().getText());
        System.out.println("=================");
        // 4.Tüm dropdown değerleri(value) yazdırın
        List<WebElement> tumDdm =options.getOptions();
        tumDdm.forEach(t-> System.out.println(t.getText()));
        System.out.println("================");
        //5. Dropdown’un boyutunu bulun, Dropdown’da 4 öğe varsa konsolda True , degilse False yazdırın.
        System.out.println("DropDown un Boyutu :"+ tumDdm.size());
        if (tumDdm.size()==4){
            System.out.println("True");
        }else System.out.println("False");


    }
}