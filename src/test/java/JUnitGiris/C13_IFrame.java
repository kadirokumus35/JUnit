package JUnitGiris;

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

public class C13_IFrame {
     /*

    ● https://the-internet.herokuapp.com/iframe adresine gidin.
  ○ “An IFrame containing….” textinin erisilebilir oldugunu test edin ve  konsolda    yazdirin.
  ○ Text Box’a “Merhaba Dunya!” yazin.
  ○ TextBox’in altinda bulunan “Elemental Selenium” linkini textinin gorunur oldugunu     dogrulayin ve  konsolda yazdirin.

     */

    WebDriver driver;
    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @After
    public void tearDown(){
         driver.close();
    }

    @Test
    public void test01() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/iframe");

      //  ○ “An IFrame containing….” textinin erisilebilir oldugunu test edin ve  konsolda    yazdirin.
       WebElement text= driver.findElement(By.xpath("//h3"));
        Assert.assertTrue(text.isEnabled());
        System.out.println(text.getText());

        //  ○ Text Box’a “Merhaba Dunya!” yazin.
        WebElement IFrame=driver.findElement(By.xpath("//iframe[@id='mce_0_ifr']"));
        driver.switchTo().frame(IFrame);

        WebElement textBox=driver.findElement(By.xpath("//body[@id='tinymce']"));
        textBox.clear();
        Thread.sleep(3000);
        textBox.sendKeys("Merhaba Dunya!");
        Thread.sleep(3000);

        //○ TextBox’in altinda bulunan “Elemental Selenium” link textinin gorunur oldugunu dogrulayin ve konsolda yazdirin.
       //driver.switchTo().defaultContent();
        driver.switchTo().defaultContent();
        WebElement linkText=driver.findElement(By.xpath("//*[.='Elemental Selenium']"));
        Assert.assertTrue(linkText.isDisplayed());
        System.out.println(linkText.getText());

    }


}
