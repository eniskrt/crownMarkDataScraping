package steps;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;
import java.util.List;

public class CrownMarkScraper extends TestBase {

    @Test
    public void bedroom() throws InterruptedException {
        Actions actions = new Actions(driver);

        WebElement bedroomCategoryTab = driver.findElement(By.xpath("(//div[@class='TitleAreaLink'])[1]"));
        actions.moveToElement(bedroomCategoryTab).perform();
        Thread.sleep(1000);

        WebElement allBedroomsLink = driver.findElement(By.xpath("(//div[@id='Bedrooms-Submenu']//div[@class='SubmenuLink'])[4]/a"));
        allBedroomsLink.click();

        //Pagination Information
        String lastPageCountAsString = driver.findElement(By.xpath("//*[@id='CatalogContentArea']/table/tbody/tr[2]/td/b/a[6]/u")).getText();
        int pageSize = Integer.parseInt(lastPageCountAsString);

        for (int k = 1; k <= pageSize; k++){

            List<WebElement> productList = driver.findElements(By.xpath("//div[@id='CatalogContentArea']/table/tbody/tr/td/a/img"));

            WebElement product;
            for (int i = 1; i <= productList.size(); i++){
                product = productList.get(i - 1);
                product.click();
                Thread.sleep(1000);
                driver.navigate().back();
            }

            if (k == pageSize){
                break;
            }

            WebElement nextPageBtn = driver.findElement(By.xpath("(//td[@align='right'])[2]//a//u[text()='Next']"));
            try {
                nextPageBtn.click();
            } catch (Exception e) {
                actions.click(nextPageBtn).perform();
            }
            Thread.sleep(1000); // Sayfanın yüklenmesi için bekleme süresi

        }
    }

    @Test
    public void dining() throws InterruptedException {
        Actions actions = new Actions(driver);

        WebElement diningCategoryTab = driver.findElement(By.xpath("(//div[@class='TitleAreaLink'])[2]"));
        actions.moveToElement(diningCategoryTab).perform();
        Thread.sleep(1000);

        WebElement allDiningLink = driver.findElement(By.xpath("(//div[@id='DiningRooms-Submenu']//div[@class='SubmenuLink'])[4]/a"));
        allDiningLink.click();
    }

    @Test
    public void livingRoom() {
        Actions actions = new Actions(driver);
    }

    @Test
    public void homeOffice() {
        Actions actions = new Actions(driver);
    }

    @Test
    public void accessories() {
        Actions actions = new Actions(driver);
    }
}
