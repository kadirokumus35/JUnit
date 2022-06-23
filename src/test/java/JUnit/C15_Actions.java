package JUnit;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import java.util.Set;

public class C15_Actions extends TestBase {
     /*
        1- Yeni bir class olusturalim: MouseActions1
        2- https://the-internet.herokuapp.com/context_menu sitesine gidelim
        3- Cizili alan uzerinde sag click yapalim
        4- Alert’te cikan yazinin “You selected a context menu” oldugunu
            test edelim.
        5- Tamam diyerek alert’i kapatalim
        6- Elemental Selenium linkine tiklayalim
        7- Acilan sayfada h1 taginda “Elemental Selenium” yazdigini test edelim
     */

    @Test
    public void test01() {
        driver.get("https://the-internet.herokuapp.com/context_menu");

    // Cizili alan uzerinde sag click yapalim
        Actions actions = new Actions(driver);
        WebElement ciziliALan=driver.findElement(By.xpath("//div[@id='hot-spot']"));
        actions.contextClick(ciziliALan).perform();

        // Alert’te cikan yazinin “You selected a context menu” oldugunu test edelim.
        String actualAlert=driver.switchTo().alert().getText();
        String expectedAlert="You selected a context menu";
        Assert.assertEquals(actualAlert,expectedAlert);

        //Tamam diyerek alert’i kapatalim
        driver.switchTo().alert().accept();

        //Elemental Selenium linkine tiklayalim
        String ilkSayfaHandleDegeri=driver.getWindowHandle();
        driver.findElement(By.xpath("//a[.='Elemental Selenium']")).click();
        String ikinciSayfaHandleDegeri="";
        Set<String> handles= driver.getWindowHandles();
        for (String each:handles
             ) {
            ikinciSayfaHandleDegeri=each;
        }

        // Acilan sayfada h1 taginda “Elemental Selenium” yazdigini test edelim

        driver.switchTo().window(ikinciSayfaHandleDegeri);
        String expectedh1="Elemental Selenium";
        String actualh1=driver.getTitle();


    }
}
