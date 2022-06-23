package JUnit;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C17_FileDownload extends TestBase {
    //1. Tests packagenin altina bir class oluşturalim
    //2. https://the-internet.herokuapp.com/download adresine gidelim.
    //3. dummy.txt dosyasını indirelim
    //4. dosyanın başarıyla indirilip indirilmediğini test edelim

    @Test
    public void test(){
        driver.get("https://the-internet.herokuapp.com/download");

        driver.findElement(By.xpath("//a[text()='dummy.txt']")).click();

        String farkliKisim = System.getProperty("user.home");
        String ayniKisim = "\\Downloads\\dummy.txt";
        String dosyaYolu=farkliKisim+ayniKisim;

        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));

    }

}
