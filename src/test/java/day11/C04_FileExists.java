package day11;

import org.junit.Assert;
import org.junit.Test;

import java.nio.file.Files;
import java.nio.file.Paths;


public class C04_FileExists {
    @Test
    public void test1() {
        System.out.println(System.getProperty("user.dir"));///Users/selcukkardes/IdeaProjects/Selenium_new_JUnit
        //Suanki icinde bulundugu yolu gosterir
        System.out.println(System.getProperty("user.home"));///Users/selcukkardes
        //Gecerli kullanicinin ana dizinini verir.

        String farkliBolum = System.getProperty("user.home");
        ///Users/selcukkardes/Desktop/text.txt  --> masaustundeki dosayanin yolu
/*

        String ortakBolum = "\\OneDrive\\Masaüstü\\tex.txt";
        String masaUstuDosyaYolu = farkliBolum+ortakBolum; // Masaüstündeki dosya yolunu gösterir
        System.out.println(masaUstuDosyaYolu); //C:\Users\Lenovo\OneDrive\Masaüstü\text.txt
        System.out.println(Files.exists(Paths.get(dosyaYolu)));
        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));
 */
        String dosyaYolu = "/Users/selcukkardes/Desktop/text.txt";
        //System.out.println(Files.exists(Paths.get(dosyaYolu)));
        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));
        /*
        Bir web sitesinden indirdiğimiz yada windows içinde oluşturduğumuz dosyanın indiğini yada orda olduğunu
        test edebilmem için o dosyanın üzerine shift tuşuna basılı olarak sağ klik yapıp dosyanın yolunu kopyalayıp
        bir string değişkene atarız ve dosyayı doğrulamak için
        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu))); bu methodu kullanırız
         */
    }
}
