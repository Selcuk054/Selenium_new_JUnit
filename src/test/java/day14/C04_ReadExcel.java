package day14;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;

public class C04_ReadExcel {
    //Turkce Baskentler sutunun yazdiralim
    @Test
    public void readExcelTest1() throws IOException {
        String dosyaYolu = "src/resources/ulkeler.xlsx";
        FileInputStream fis = new FileInputStream(dosyaYolu);
        Workbook workbook= WorkbookFactory.create(fis);
        //Turkce Baskentler sutunun yazdiralim
        int sonSatir = workbook.getSheet("Sayfa1").getLastRowNum();
        //getLastRowNum() methodu bize excel sayfasindaki tum satir numarasini verir
        System.out.println(sonSatir); //190
        String turkceBaskentler = "";
        for (int i = 1; i <= sonSatir; i++) {
            turkceBaskentler = workbook.getSheet("Sayfa1").getRow(i).getCell(3).toString();
            System.out.println(turkceBaskentler);
        }



    }
}
