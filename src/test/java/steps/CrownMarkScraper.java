package steps;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CrownMarkScraper extends TestBase {

    private static List<String[]> allProductsInformation = new ArrayList<>(); // Ortak veri listesi
    @Test
    public void bedroom() throws InterruptedException {
        Actions actions = new Actions(driver);

        WebElement bedroomCategoryTab = driver.findElement(By.xpath("(//div[@class='TitleAreaLink'])[1]"));
        bedroomCategoryTab.click();

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

                String productSKUNo;
                String productDescription;
                String productStockLevel;
                String productBasePrice;
                String productSpecialPrice;
                String productSpecialStatus;

                List<WebElement> tableRowCountList = driver.findElements(By.xpath("//span[@style='font-face:Park Avenue BT;font-size:11px']//table//tbody//tr"));
                int tableRowCount = tableRowCountList.size();

                for (int j = 2; j < tableRowCount; j+=2) {
                    String cellListXPath = "(//span[@style='font-face:Park Avenue BT;font-size:11px']//table//tbody//tr)[" + j + "]//td";
                    List<WebElement> cellList = driver.findElements(By.xpath(cellListXPath));
                    if (cellList.get(1).getText().equals("Total CFT")){
                        break;
                    }
                    try {
                        productSKUNo = cellList.get(0).getText();
                        productDescription = cellList.get(1).getText();
                        productStockLevel = cellList.get(2).getText();
                        productBasePrice = cellList.get(3).getText();
                        productSpecialPrice = cellList.get(4).getText().isBlank() ? "-" : cellList.get(4).getText();
                        productSpecialStatus = cellList.get(5).getText().isBlank() ? "-" : cellList.get(5).getText();
                        String[] productInfo = {productSKUNo, productDescription, productStockLevel, productBasePrice, productSpecialPrice, productSpecialStatus};
                        allProductsInformation.add(productInfo);
                    } catch (Exception e) {
                        System.out.println("Trivial information dosen't included.");
                    }
                }
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
        diningCategoryTab.click();

        String lastPageCountAsString = driver.findElement(By.xpath("//*[@id='CatalogContentArea']/table/tbody/tr[2]/td/b/a[6]/u")).getText();
        int pageSize = Integer.parseInt(lastPageCountAsString);

        for (int k = 1; k <= pageSize; k++){

            List<WebElement> productList = driver.findElements(By.xpath("//div[@id='CatalogContentArea']/table/tbody/tr/td/a/img"));

            WebElement product;
            for (int i = 1; i <= productList.size(); i++){
                product = productList.get(i - 1);
                product.click();
                Thread.sleep(1000);

                String productSKUNo;
                String productDescription;
                String productStockLevel;
                String productBasePrice;
                String productSpecialPrice;
                String productSpecialStatus;

                List<WebElement> tableRowCountList = driver.findElements(By.xpath("//span[@style='font-face:Park Avenue BT;font-size:11px']//table//tbody//tr"));
                int tableRowCount = tableRowCountList.size();

                for (int j = 2; j < tableRowCount; j+=2) {
                    String cellListXPath = "(//span[@style='font-face:Park Avenue BT;font-size:11px']//table//tbody//tr)[" + j + "]//td";
                    List<WebElement> cellList = driver.findElements(By.xpath(cellListXPath));
                    if (cellList.get(1).getText().equals("Total CFT")){
                        break;
                    }
                    try {
                        productSKUNo = cellList.get(0).getText();
                        productDescription = cellList.get(1).getText();
                        productStockLevel = cellList.get(2).getText();
                        productBasePrice = cellList.get(3).getText();
                        productSpecialPrice = cellList.get(4).getText().isBlank() ? "-" : cellList.get(4).getText();
                        productSpecialStatus = cellList.get(5).getText().isBlank() ? "-" : cellList.get(5).getText();
                        String[] productInfo = {productSKUNo, productDescription, productStockLevel, productBasePrice, productSpecialPrice, productSpecialStatus};
                        allProductsInformation.add(productInfo);
                    } catch (Exception e) {
                        System.out.println("Trivial information dosen't included.");
                    }
                }
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
    public void livingRoom() throws InterruptedException {
        Actions actions = new Actions(driver);

        WebElement livingRoomCategoryTab = driver.findElement(By.xpath("(//div[@class='TitleAreaLink'])[3]"));
        livingRoomCategoryTab.click();

        String lastPageCountAsString = driver.findElement(By.xpath("//*[@id='CatalogContentArea']/table[2]/tbody/tr[2]/td/b/a[5]/u")).getText();
        int pageSize = Integer.parseInt(lastPageCountAsString);

        for (int k = 1; k <= pageSize; k++){

            List<WebElement> productList = driver.findElements(By.xpath("//div[@id='CatalogContentArea']/table/tbody/tr/td/a/img"));

            WebElement product;
            for (int i = 1; i <= productList.size(); i++){
                product = productList.get(i - 1);
                product.click();
                Thread.sleep(1000);

                String productSKUNo;
                String productDescription;
                String productStockLevel;
                String productBasePrice;
                String productSpecialPrice;
                String productSpecialStatus;

                List<WebElement> tableRowCountList = driver.findElements(By.xpath("//span[@style='font-face:Park Avenue BT;font-size:11px']//table//tbody//tr"));
                int tableRowCount = tableRowCountList.size();

                for (int j = 2; j < tableRowCount; j+=2) {
                    String cellListXPath = "(//span[@style='font-face:Park Avenue BT;font-size:11px']//table//tbody//tr)[" + j + "]//td";
                    List<WebElement> cellList = driver.findElements(By.xpath(cellListXPath));
                    if (cellList.get(1).getText().equals("Total CFT")){
                        break;
                    }
                    try {
                        productSKUNo = cellList.get(0).getText();
                        productDescription = cellList.get(1).getText();
                        productStockLevel = cellList.get(2).getText();
                        productBasePrice = cellList.get(3).getText();
                        productSpecialPrice = cellList.get(4).getText().isBlank() ? "-" : cellList.get(4).getText();
                        productSpecialStatus = cellList.get(5).getText().isBlank() ? "-" : cellList.get(5).getText();
                        String[] productInfo = {productSKUNo, productDescription, productStockLevel, productBasePrice, productSpecialPrice, productSpecialStatus};
                        allProductsInformation.add(productInfo);
                    } catch (Exception e) {
                        System.out.println("Trivial information dosen't included.");
                    }
                }
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
    public void homeOffice() throws InterruptedException {
        Actions actions = new Actions(driver);

        WebElement homeOfficeCategoryTab = driver.findElement(By.xpath("(//div[@class='TitleAreaLink'])[4]"));
        homeOfficeCategoryTab.click();

        //There is no product in this category now. Control is only for no product.
        String expectedContent = "No Items have been found.";
        WebElement noContentElement = driver.findElement(By.xpath("//*[@id='CatalogContentArea']/table[2]/tbody/tr[3]/td/b"));
        String noContentText = noContentElement.getText();
        Assert.assertEquals(expectedContent,noContentText);
    }

    @Test
    public void accessories() throws InterruptedException {
        Actions actions = new Actions(driver);

        WebElement accessoriesCategoryTab = driver.findElement(By.xpath("(//div[@class='TitleAreaLink'])[5]"));
        accessoriesCategoryTab.click();

        String lastPageCountAsString = driver.findElement(By.xpath("//*[@id='CatalogContentArea']/table[2]/tbody/tr[2]/td/b/a[4]/u")).getText();
        int pageSize = Integer.parseInt(lastPageCountAsString);

        for (int k = 1; k <= pageSize; k++){

            List<WebElement> productList = driver.findElements(By.xpath("//div[@id='CatalogContentArea']/table/tbody/tr/td/a/img"));

            WebElement product;
            for (int i = 1; i <= productList.size(); i++){
                product = productList.get(i - 1);
                product.click();
                Thread.sleep(1000);

                String productSKUNo;
                String productDescription;
                String productStockLevel;
                String productBasePrice;
                String productSpecialPrice;
                String productSpecialStatus;

                List<WebElement> tableRowCountList = driver.findElements(By.xpath("//span[@style='font-face:Park Avenue BT;font-size:11px']//table//tbody//tr"));
                int tableRowCount = tableRowCountList.size();

                for (int j = 2; j < tableRowCount; j+=2) {
                    String cellListXPath = "(//span[@style='font-face:Park Avenue BT;font-size:11px']//table//tbody//tr)[" + j + "]//td";
                    List<WebElement> cellList = driver.findElements(By.xpath(cellListXPath));
                    if (cellList.get(1).getText().equals("Total CFT")){
                        break;
                    }
                    try {
                        productSKUNo = cellList.get(0).getText();
                        productDescription = cellList.get(1).getText();
                        productStockLevel = cellList.get(2).getText();
                        productBasePrice = cellList.get(3).getText();
                        productSpecialPrice = cellList.get(4).getText().isBlank() ? "-" : cellList.get(4).getText();
                        productSpecialStatus = cellList.get(5).getText().isBlank() ? "-" : cellList.get(5).getText();
                        String[] productInfo = {productSKUNo, productDescription, productStockLevel, productBasePrice, productSpecialPrice, productSpecialStatus};
                        allProductsInformation.add(productInfo);
                    } catch (Exception e) {
                        System.out.println("Trivial information dosen't included.");
                    }
                }
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

    @AfterClass
    public static void writeDataToExcel() throws IOException {
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Product List");

        // Başlık stili
        CellStyle headerStyle = workbook.createCellStyle();
        headerStyle.setFillForegroundColor(IndexedColors.LIGHT_BLUE.getIndex()); // Arka plan rengi
        headerStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND); // Dolgu tipi
        Font headerFont = workbook.createFont();
        headerFont.setBold(true); // Kalın yazı
        headerStyle.setFont(headerFont);

        // Başlıklar
        String[] headers = {"SKU NUMBER", "DESCRIPTION", "STOCK LEVEL", "BASE PRICE", "SPECIAL PRICE", "STATUS"};
        Row headerRow = sheet.createRow(0);
        for (int i = 0; i < headers.length; i++) {
            Cell headerCell = headerRow.createCell(i);
            headerCell.setCellValue(headers[i]);
            headerCell.setCellStyle(headerStyle); // Stili uygula
        }

        // Verileri ekle
        int rowCount = 1;
        for (String[] rowData : allProductsInformation) {
            Row row = sheet.createRow(rowCount++);
            for (int i = 0; i < rowData.length; i++) {
                row.createCell(i).setCellValue(rowData[i]);
            }
        }

        // Sütun genişliklerini otomatik ayarla
        for (int i = 0; i < headers.length; i++) {
            sheet.autoSizeColumn(i);
        }

        // Excel dosyasını kaydet
        String currentDate = new SimpleDateFormat("ddMMyyyy").format(new Date());
        String currentTime = new SimpleDateFormat("HHmm").format(new Date()); // Saati HHmm formatında al
        String fileName = "CrownMarkPriceList_" + currentDate + "_" + currentTime + ".xlsx";

        try (FileOutputStream outputStream = new FileOutputStream(fileName)) {
            workbook.write(outputStream);
        }
        workbook.close();
        System.out.println("Excel dosyası başarıyla kaydedildi!");
    }
}
