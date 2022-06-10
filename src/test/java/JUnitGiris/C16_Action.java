package JUnitGiris;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C16_Action extends TestBase {

    @Test
    public void test(){
       // https://html.com/tags/iframe/ sayfasina gidelim
        driver.get("https://html.com/tags/iframe/");

        // video’yu gorecek kadar asagi inin
        Actions action = new Actions(driver);
        action.sendKeys(Keys.PAGE_DOWN)
                .perform();

        // videoyu izlemek icin Play tusuna basin
        WebElement iframe=driver.findElement(By.xpath("(//iframe[@frameborder='0'])[1]"));
        driver.switchTo().frame(iframe);
        driver.findElement(By.xpath("//button[@class='ytp-large-play-button ytp-button']")).click();

        //videoyu calistirdiginizi test edin
        WebElement video=driver.findElement(By.xpath("//button[@aria-label='Oynat']"));
        Assert.assertTrue(video.isDisplayed());


    }

}
