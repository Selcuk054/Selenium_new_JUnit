package day14;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class C03_ReadExcel {
    @Test
    public void readExcelTest1() throws IOException {
        /*
        Belirtilen satirNo ve SutunNo degerlerini parametre olarak alip o cell deki datayi konsola yazdiralim
        sonucun  konsolda yazanla ayni oldugunu dogrulayin.
        */
        int satir = 12;
        int sutun = 2;
        String dosyaYolu = "src/resources/ulkeler.xlsx";
        FileInputStream fis = new FileInputStream(dosyaYolu);
        Workbook workbook= WorkbookFactory.create(fis);

        String actuelData = workbook.getSheet("Sayfa1")
                .getRow(satir-1)
                .getCell(sutun-1)
                .toString();
        //Index sifirdan basladigi icin bizden istenen satir ulasabilmek icin bir eksiginiz alir.

        System.out.println(actuelData); //Baku
        String expectedData = "Baku";
        Assert.assertEquals(expectedData,actuelData);



    }
}
