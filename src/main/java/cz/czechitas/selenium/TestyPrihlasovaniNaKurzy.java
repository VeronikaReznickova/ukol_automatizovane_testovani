package cz.czechitas.selenium;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class TestyPrihlasovaniNaKurzy {

    WebDriver prohlizec;

    @BeforeEach
    public void setUp() {
//      System.setProperty("webdriver.gecko.driver", System.getProperty("user.home") + "/Java-Training/Selenium/geckodriver");
        System.setProperty("webdriver.gecko.driver", "C:\\Java-Training\\Selenium\\geckodriver.exe");
        prohlizec = new FirefoxDriver();
        prohlizec.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    @Test
    public void rodicSUctemSeMuzePrihlasitDoAplikace () {
        prohlizec.navigate().to("https://cz-test-jedna.herokuapp.com/");
        WebElement prihlaseni = prohlizec.findElement(By.xpath("/html/body/div/header/nav/div/div[2]/a"));
        prihlaseni.click();

        vseobecnePrihlaseniDoUctu();

        WebDriverWait cekani = new WebDriverWait(prohlizec, 10);
        cekani.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//th[contains(@class,btn-sm)]")));
    }


    @Test
    public void rodicVybereKurzPrihlasiSePrihlasiSvojeDite () {
        prohlizec.navigate().to("https://cz-test-jedna.herokuapp.com/");

        WebElement vyberKurzu = prohlizec.findElement(By.xpath("(//div[@class = 'card'] )[2]//a[text()='Více informací']"));
        vyberKurzu.click();

        WebElement vytvoritPrihlasku = prohlizec.findElement(By.xpath("/html/body/div/div/div/div/div[2]/div/div/div[2]/a"));
        vytvoritPrihlasku.click();

        vseobecnePrihlaseniDoUctu();

        vseobecnyVyberTerminu();

        WebElement prihlaskyKontrola = prohlizec.findElement(By.xpath("/html/body/div/header/nav/div/div[1]/a[2]"));
        prihlaskyKontrola.click();

        WebDriverWait cekani = new WebDriverWait(prohlizec, 10);
        cekani.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//td[contains(@class,dtr-control)]")));
    }

    @Test
    public void rodicSePrihlasiVybereKurzuPrihlasiDite() {
        prohlizec.navigate().to("https://cz-test-jedna.herokuapp.com/");
        WebElement prihlaseni = prohlizec.findElement(By.xpath("/html/body/div/header/nav/div/div[2]/a"));
        prihlaseni.click();

        vseobecnePrihlaseniDoUctu();

        WebElement novaPrihlaska = prohlizec.findElement(By.xpath("/html/body/div/div/div/div/div/div[1]/a"));
        novaPrihlaska.click();
        WebElement vyberKurzu = prohlizec.findElement(By.xpath("(//div[@class = 'card'] )[2]//a[text()='Více informací']"));
        vyberKurzu.click();
        WebElement vytvoritPrihlasku = prohlizec.findElement(By.xpath("/html/body/div/div/div/div/div[2]/div/div/div[2]/a"));
        vytvoritPrihlasku.click();

        vseobecnyVyberTerminu();

        WebElement prihlaskyKontrola = prohlizec.findElement(By.xpath("/html/body/div/header/nav/div/div[1]/a[2]"));
        prihlaskyKontrola.click();

        WebDriverWait cekani = new WebDriverWait(prohlizec, 10);
        cekani.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//td[contains(@class,dtr-control)]")));
    }

    @Test
    public void uciteleObjednavkyPrimestskyTabor() {
        prohlizec.navigate().to("https://cz-test-jedna.herokuapp.com/");
        WebElement ucitele = prohlizec.findElement(By.xpath("/html/body/div/header/nav/div/div[1]/div[2]/a"));
        ucitele.click();
        WebElement objednavkaProMS = prohlizec.findElement(By.xpath("/html/body/div/header/nav/div/div[1]/div[2]/div/a[2]"));
        objednavkaProMS.click();
        WebElement ico = prohlizec.findElement(By.id("ico"));
        ico.sendKeys("22834958");
        WebElement zastoupena = prohlizec.findElement(By.id("substitute"));
        zastoupena.sendKeys("Reditelka skoly");
        WebElement jmeno = prohlizec.findElement(By.id("contact_name"));
        jmeno.sendKeys("Czechitas");
        WebElement telefon = prohlizec.findElement(By.id("contact_tel"));
        telefon.sendKeys("737011011");
        WebElement mail = prohlizec.findElement(By.id("contact_mail"));
        mail.sendKeys("liskapodsitaczechitas@seznam.cz");
        WebElement zacatek = prohlizec.findElement(By.id("start_date_1"));
        zacatek.sendKeys("1.12.2021");
        WebElement konec = prohlizec.findElement(By.id("end_date_1"));
        konec.sendKeys("12.12.2021");

        WebElement primestskyTabor = prohlizec.findElement(By.id("nav-home-tab"));
        primestskyTabor.click();
        WebElement pocetDeti = prohlizec.findElement(By.id("camp-students"));
        pocetDeti.sendKeys("26");
        WebElement detiVeVeku = prohlizec.findElement(By.id("camp-age"));
        detiVeVeku.sendKeys("7-12");
        WebElement pedagogickyDoprovod = prohlizec.findElement(By.id("camp-adults"));
        pedagogickyDoprovod.sendKeys("3");
        WebElement ulozitObjednavku = prohlizec.findElement(By.xpath("/html/body/div[1]/div/div/div/div/div/form/div[5]/div[1]/div[2]/input"));
        ulozitObjednavku.click();


        WebDriverWait cekani = new WebDriverWait(prohlizec, 10);
        cekani.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h3[text()='Děkujeme za objednávku']")));

    }

    public void vseobecnePrihlaseniDoUctu() {
        WebElement email = prohlizec.findElement(By.id("email"));
        email.sendKeys("liskapodsita@czechitas.cz");
        WebElement heslo = prohlizec.findElement(By.id("password"));
        heslo.sendKeys("Hesloliska1");
        WebElement tlacitkoPrihlasit = prohlizec.findElement(By.xpath("/html/body/div/div/div/div/div/div/form/div[3]/div/button"));
        tlacitkoPrihlasit.click();
    }

    public void vseobecnyVyberTerminu() {
        WebElement termin = prohlizec.findElement(By.xpath("/html/body/div/div/div/div/div/form/table/tbody/tr[2]/td[2]/div/button/div/div/div"));
        termin.click();
        WebElement presnyTermin = prohlizec.findElement(By.id("bs-select-1-0"));
        presnyTermin.click();
        WebElement forename = prohlizec.findElement(By.id("forename"));
        forename.sendKeys("Mala");
        WebElement surname = prohlizec.findElement(By.id("surname"));
        surname.sendKeys("Liska");
        WebElement datumNarozeni = prohlizec.findElement(By.id("birthday"));
        datumNarozeni.sendKeys("20.2.2015");
        WebElement platba = prohlizec.findElement(By.xpath("//label[contains(@class,custom-control-label)]"));
        platba.click();
        WebElement souhlas = prohlizec.findElement(By.xpath("/html/body/div/div/div/div/div/form/table/tbody/tr[11]/td[2]/span/label"));
        souhlas.click();
        WebElement vytvorit = prohlizec.findElement(By.xpath("/html/body/div/div/div/div/div/form/table/tbody/tr[11]/td[2]/input"));
        vytvorit.click();
    }

    @AfterEach
    public void tearDown() {
        prohlizec.quit();
    }
}
