package JUnitGiris;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C18_ExplicitlyWait extends TestBase {

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

    }
}
