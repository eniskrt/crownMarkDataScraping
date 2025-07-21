package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class TestBase {

    protected static WebDriver driver;

    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(11));

        // ChromeOptions ile tarayıcı ayarları
        /*ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless=new"); // Yeni headless modu (daha stabil)
        options.addArguments("--disable-popup-blocking"); // Pop-up engelleme devre dışı
        options.addArguments("--remote-allow-origins=*"); // Çapraz köken hatalarını önler

        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(11));*/

        driver.get(ConfigReader.getProperty("loginUrl"));

        WebElement cmiAcctInput = driver.findElement(By.xpath("(//p[@class='smallTitles']//input)[1]"));
        cmiAcctInput.sendKeys(ConfigReader.getProperty("cmiAcct"));

        WebElement emailInput = driver.findElement(By.xpath("(//p[@class='smallTitles']//input)[2]"));
        emailInput.sendKeys(ConfigReader.getProperty("email"));

        WebElement passwordInput = driver.findElement(By.xpath("(//p[@class='smallTitles']//input)[3]"));
        passwordInput.sendKeys(ConfigReader.getProperty("password"));

        WebElement divisionInput = driver.findElement(By.xpath("(//p[@class='smallTitles']//input)[4]"));
        divisionInput.sendKeys(ConfigReader.getProperty("division") + Keys.ENTER);

        //WebElement signInBtn = driver.findElement(By.xpath("//input[@class='btnSubmit']"));
        //signInBtn.click();

        WebElement catalogMenuLink = driver.findElement(By.id("menu_catalog"));
        catalogMenuLink.click();

    }

    @After
    public void teardown() {
        driver.quit();
    }
}
