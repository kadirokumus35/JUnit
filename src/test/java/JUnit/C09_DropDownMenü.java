package JUnit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class C09_DropDownMenü {
     /*
    amazona gidip
    dropdowndan books secenegini secip
    java aratalim
    ve arama sonuclarinin java icerdigini test edelim
     */
WebDriver driver;
@Before
    public void setUp(){
    WebDriverManager.chromedriver().setup();
    driver=new ChromeDriver();
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    driver.get("https://www.amazon.com");
}
@After
    public void tearDown(){
    driver.close();
}
@Test
    public void test(){
    // dropdowndan books secenegini secip
    WebElement ddm=driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));
    Select select=new Select(ddm);
    // value ile dropDownMenü
    select.selectByValue("search-alias=stripbooks-intl-ship");
    // java aratalim
    WebElement aramaKutusu=driver.findElement(By.id("twotabsearchtextbox"));
    aramaKutusu.sendKeys("Java"+ Keys.ENTER);
    //ve arama sonuclarinin java icerdigini test edelim
    WebElement aramaSonuclari=driver.findElement(By.xpath("(//div[@class='sg-col-inner'])[1]"));
    String expectedResult="Java";
    String actualResult=aramaSonuclari.getText();
    Assert.assertTrue(actualResult.contains(expectedResult));

}
}
