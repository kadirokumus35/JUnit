package JUnit;

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
import java.util.Set;

public class C14_WindowHandles {

      /*

        ● https://the-internet.herokuapp.com/windows adresine gidin.
        ● Sayfadaki textin “Opening a new window” olduğunu doğrulayın.
        ● Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.
        ● Click Here butonuna basın.
        ● Acilan yeni pencerenin sayfa başlığının (title) “New Window” oldugunu dogrulayin.
        ● Sayfadaki textin “New Window” olduğunu doğrulayın.
        ● Bir önceki pencereye geri döndükten sonra sayfa başlığının “The Internet” olduğunu doğrulayın.
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
       // driver.close();
    }

    @Test
    public void test(){
        //● https://the-internet.herokuapp.com/windows adresine gidin.
        driver.get("https://the-internet.herokuapp.com/windows");

        //        ● Sayfadaki textin “Opening a new window” olduğunu doğrulayın.
        WebElement text=driver.findElement(By.xpath("//h3"));
        String actualText=text.getText();
        String expectedText="Opening a new window";
        Assert.assertEquals(expectedText,actualText);


        //        ● Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.
        String actualTitle=driver.getTitle();
        String expectedTitle="The Internet";
        Assert.assertTrue(actualTitle.contains(expectedTitle));

        //        ● Click Here butonuna basın.
        driver.findElement(By.xpath("//*[.='Click Here']")).click();

        //        ● Acilan yeni pencerenin sayfa başlığının (title) “New Window” oldugunu dogrulayin.
       /*
        eger kontrolsuz acilan bir tab veya window varsa
        o zaman sayfalarin window handle degerlerini elde etmem gerekir.
        oncelikle 2.sayfa acilmadan once
        ilk sayfanin window handle degerini bir String'e atayalim
         */
        String ilkSayfaHandleDegeri=driver.getWindowHandle();
        String ikinciSayfaHandleDegeri="";


        Set<String> handles=driver.getWindowHandles();
        for (String each:handles
             ) {
            if (!each.equals(ilkSayfaHandleDegeri)){
                ikinciSayfaHandleDegeri=each;
            }
        }

        /*
         artik ikinci sayfanin window handle degerini biliyoruz
         rahatlikla sayfalar arasii gecis yapabiliriz
         */

        driver.switchTo().window(ikinciSayfaHandleDegeri);



        //        ● Sayfadaki textin “New Window” olduğunu doğrulayın.
        WebElement newText=driver.findElement(By.xpath("//h3"));
        String newActualText=newText.getText();
        String newExpectedText="New Window";
        Assert.assertEquals(newActualText,newExpectedText);

        //        ● Bir önceki pencereye geri döndükten sonra sayfa başlığının “The Internet” olduğunu doğrulayın.
        driver.switchTo().window(ilkSayfaHandleDegeri);
        String backActualTitle=driver.getTitle();
        String backExpectedTitle="The Internet";
        Assert.assertTrue(backActualTitle.contains(backExpectedTitle));

    }
}
