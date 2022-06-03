package JUnitGiris;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C07_Assertion {
          /*
    amazon ana sayfaya gidin
    3 farkli test methodu olusturarak oasagidaki görevleri yapin
    1- url in amazon icerdigini test edin
    2- title in facebook icermedigini test edin
    3- sol ust kosede amazon logosunun gorundugunu test edin
     */

    static WebDriver driver;
    @BeforeClass
    public static void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @AfterClass
    public static void tearDown() {
        driver.close();
    }

    // 1- url in amazon icerdigini test edin
    @Test
    public void test01(){
        driver.get("https://www.amazon.com");
        String expectedUrl="amazon";
        String actualUrl=driver.getCurrentUrl();

        Assert.assertTrue(actualUrl.contains(expectedUrl));
    }

    // 2- title in facebook icermedigini test edin
    @Test
    public void test02() {
        driver.get("https://www.facebook.com");
        String expectedTitle="facebook";
        String actualTitle=driver.getTitle();

        Assert.assertTrue(actualTitle.contains(expectedTitle));
    }

    // 3- sol ust kosede amazon logosunun gorundugunu test edin
    @Test
    public void test03(){
        driver.get("https://www.amazon.com");
        WebElement logo=driver.findElement(By.xpath(""));

        Assert.assertTrue(logo.isDisplayed());
    }
}
