package day15;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utilities.TestBaseBeforeAfter;

import java.io.File;
import java.io.IOException;

public class Q01_ScreenShut extends TestBaseBeforeAfter {

    @Test
    public void test1() throws IOException {
        //Amazon sayfasina gidin
        driver.get("https://amazon.com");
        TakesScreenshot Gs = (TakesScreenshot) driver;
        File ekranG = Gs.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(ekranG,new File("target/ScreenShot'm/"+driver.getTitle()+" "+tarih+".jpeg"));


    }
}
