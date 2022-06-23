package JUnit;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBase;

import java.time.Duration;

public class C19_ExplicitlyWait extends TestBase {

    //1. Bir class olusturun : EnableTest
    //2. Bir metod olusturun : isEnabled()
    //3. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
    //4. Textbox’in etkin olmadigini(enabled) dogrulayın
    //5. Enable butonuna tıklayın ve textbox etkin oluncaya kadar bekleyin
    //6. “It’s enabled!” mesajinin goruntulendigini dogrulayın.
    //7. Textbox’in etkin oldugunu(enabled) dogrulayın.

    @Test
    public void test(){
        //3. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        //4. Textbox’in etkin olmadigini(enabled) dogrulayın
        WebElement enabledKutusu=driver.findElement(By.xpath("//input[@type='text']"));
        Assert.assertFalse(enabledKutusu.isEnabled());

        //5. Enable butonuna tıklayın ve textbox etkin oluncaya kadar bekleyin
        driver.findElement(By.xpath("//button[@onclick='swapInput()']")).click();
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.elementToBeClickable(enabledKutusu));

        //6. “It’s enabled!” mesajinin goruntulendigini dogrulayın.
        WebElement itsEnabled=driver.findElement(By.xpath("//p[@id='message']"));
        Assert.assertTrue(itsEnabled.isDisplayed());

        //7. Textbox’in etkin oldugunu(enabled) dogrulayın.
        Assert.assertTrue(itsEnabled.isEnabled());

    }
}
