package JUnit;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBase;

import java.time.Duration;

public class C18_İmpicitly_ExplicitlyWait extends TestBase {

    // Iki tane metod olusturun : implicitWait() , explicitWait()
    // Iki metod icin de asagidaki adimlari test edin.

    @Test
    public void implicitlyWait(){
        //3. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
       driver.get("https://the-internet.herokuapp.com/dynamic_controls");

       //4. Remove butonuna basin.
        driver.findElement(By.xpath("//button[@onclick='swapCheckbox()']")).click();

        //5. “It’s gone!” mesajinin goruntulendigini dogrulayin.
        WebElement message=driver.findElement(By.xpath("//p[@id='message']"));
        Assert.assertTrue(message.isDisplayed());

        //6. Add buttonuna basin
        driver.findElement(By.xpath("//button[@onclick='swapCheckbox()']")).click();

        //7. It’s back mesajinin gorundugunu test edin
        System.out.println(driver.findElement(By.xpath("//p[@id='message']")));


    }

    @Test
    public void explicitlyWait (){
        //3. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        //4. Remove butonuna basin.
        driver.findElement(By.xpath("//button[@onclick='swapCheckbox()']")).click();

        //5. “It’s gone!” mesajinin goruntulendigini dogrulayin.,
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        WebElement itsGone= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@id='message']")));

        //6. Add buttonuna basin
        driver.findElement(By.xpath("(//button[@autocomplete='off'])[1]")).click();

        //7. It’s back mesajinin gorundugunu test edin
        System.out.println(driver.findElement(By.xpath("//p[@id='message']")).isDisplayed());
    }
}
