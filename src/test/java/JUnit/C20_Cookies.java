package JUnit;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Cookie;
import utilities.TestBase;

import java.util.Set;

public class C20_Cookies extends TestBase {

    @Test
    public void cookie(){
        // 1- Amazon anasayfaya gidin
        driver.get("https://www.amazon.com");

        //2- tum cookie’leri listeleyin
       Set<Cookie> cookii= driver.manage().getCookies();
       int sayac=1;
        for (Cookie each:cookii) {
            System.out.println(sayac+ ". cookie : "+ each);
            System.out.println("name "+ each.getName());
            System.out.println( " value "+ each.getValue());
            sayac++;
        }

        //3- Sayfadaki cookies sayisinin 5’den buyuk oldugunu test edin
            int cookieSayisi=cookii.size();
        Assert.assertTrue(cookieSayisi>5);

        //4- ismi i18n-prefs olan cookie degerinin USD oldugunu test edin
        for (Cookie each:cookii) {
            if(each.getName().equals("i18n-prefs")){
                Assert.assertEquals("USD",each.getValue());
            }

            //5- ismi “en sevdigim cookie” ve degeri “cikolatali” olan
            // bir cookie olusturun ve sayfaya ekleyin
            Cookie cokie=new Cookie("en sevdigim cookie","cikolatali");
            driver.manage().addCookie(cokie);
            Set<Cookie> ekliCookie=driver.manage().getCookies();

            int say=1;
            for (Cookie w:ekliCookie) {
                System.out.println(say+". cookie : "+w);
                say++;
            }

            //6- tum cookie’leri silin ve silindigini test edin
            driver.manage().deleteAllCookies();
            cookii=driver.manage().getCookies();
            Assert.assertTrue(cookii.isEmpty());
        }
    }
}
