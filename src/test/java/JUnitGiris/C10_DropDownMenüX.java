package JUnitGiris;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class C10_DropDownMenüX {
/*
        Amazon anasayfaya gidip
        dropdown menuden books'u secelim
        sonra sectigimiz option'i yazdiralim

        dropdown'daki opsiyonlarin toplam sayisinin
        23 oldugunu test edin
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
        //   dropdown menuden books'u secelim
        WebElement ddm=driver.findElement(By.xpath("//select[@data-nav-selected='0']"));
        Select select=new Select(ddm);
        select.selectByVisibleText("Books");

        // //bir dropdown ile calisiyorken son secilen optiona ulasmak isterseniz
        System.out.println(select.getFirstSelectedOption().getText());

        // sonra sectigimiz option'i yazdiralim
        List<WebElement> optionList=select.getOptions();
        System.out.println(optionList.size());
        int actualOptionList=optionList.size();
        int expectedOption=28;

        Assert.assertEquals(actualOptionList,expectedOption);
    }

}
