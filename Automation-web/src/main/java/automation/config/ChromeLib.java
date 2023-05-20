package automation.config;



import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDate;
import java.util.List;


import static java.lang.Integer.parseInt;
import static java.lang.String.valueOf;

public class ChromeLib {
    public static Duration waitObject = Duration.ofMillis(35000);
    static ChromeOptions co = new ChromeOptions();
    static WebDriver driver = new ChromeDriver(co.addArguments("--remote-allow-origins=*"));
    public static WebDriver webDrivers(){

        return driver;
    }
    public static boolean openBrowser(String url)  {

        driver.get(url);
        return true;
    }
    public static void openChrome(String url){
        openBrowser(url);
        maximize();
    }

    public static boolean closeChrome(){
        WebDriver driver = webDrivers();
        driver.quit();
        return true;
    }

    public static boolean clickByIdWeb(String id) {

        WebDriverWait wait = new WebDriverWait(driver, waitObject);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(id)));
        driver.findElement(By.id(id)).click();
        return true;
    }

    public static boolean clickByNameWeb(String name){

        WebDriverWait wait = new WebDriverWait(driver, waitObject);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name(name)));
        driver.findElement(By.name(name)).click();
        return true;
    }

    public  static boolean clickByXpathWeb(String xpath){

        WebDriverWait wait = new WebDriverWait(driver, waitObject);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
        driver.findElement(By.xpath(xpath)).click();
        return true;
    }

    public  static boolean clickByClassNameWeb(String className){

        WebDriverWait wait = new WebDriverWait(driver, waitObject);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className(className)));
        driver.findElement(By.className(className)).click();
        return true;
    }
    public static boolean inputByIdWeb(String id, String value){

        WebDriverWait wait = new WebDriverWait(driver, waitObject);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(id)));
        driver.findElement(By.id(id)).clear();
        driver.findElement(By.id(id)).sendKeys(value);
        return true;
    }

    public static boolean selectDropdown(String xpath, String value){

        WebDriverWait wait = new WebDriverWait(driver, waitObject);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
        WebElement div0 = driver.findElement(By.xpath(xpath));
        WebElement inputSelect = div0.findElement(By.tagName("input"));
        inputSelect.sendKeys(value);
        return true;
    }
    public static boolean clickByXpathTagName(String xpath, String type){

        WebDriverWait wait = new WebDriverWait(driver, waitObject);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
        WebElement div0 = driver.findElement(By.xpath(xpath));
        List<WebElement> buttons = div0.findElements(By.tagName("button"));
        if(type.equalsIgnoreCase("YES")){
            buttons.get(1).click();
        }else{
            buttons.get(0).click();
        }
        return true;
    }

    public static boolean inputByNameWeb(String name, String value){

        WebDriverWait wait = new WebDriverWait(driver, waitObject);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name(name)));
        driver.findElement(By.name(name)).clear();
        driver.findElement(By.name(name)).sendKeys(value);
        return true;
    }

    public static boolean inputByXpathWeb(String xpath, String value){

        WebDriverWait wait = new WebDriverWait(driver, waitObject);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
        driver.findElement(By.xpath(xpath)).clear();
        driver.findElement(By.xpath(xpath)).sendKeys(value);
        return true;
    }
    public static String getTextByIdWeb(String id){

        WebDriverWait wait = new WebDriverWait(driver, waitObject);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(id)));
        return driver.findElement(By.id(id)).getText();
    }

    public static String getTextByClassName(String className){
        WebDriverWait wait = new WebDriverWait(driver, waitObject);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className(className)));
        return driver.findElement(By.className(className)).getText();
    }

    public static String getTextByNameWeb(String name){

        WebDriverWait wait = new WebDriverWait(driver, waitObject);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name(name)));
        return driver.findElement(By.name(name)).getText();
    }

    public static String getTextByXpathWeb(String xpath){

        WebDriverWait wait = new WebDriverWait(driver, waitObject);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
        return driver.findElement(By.xpath(xpath)).getText();
    }
    public static String getHTMLXpathWeb(String xpath){

        WebDriverWait wait = new WebDriverWait(driver, waitObject);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(xpath)));
        return driver.findElement(By.id(xpath)).getAttribute("outerHTML");
    }

    public static boolean maximize(){

        driver.manage().window().maximize();
        return true;
    }

    public static boolean quit() throws InterruptedException {
        Thread.sleep(1200);
        driver.quit();
        return true;
    }
    public static boolean close() throws InterruptedException {
        Thread.sleep(1200);
        driver.close();
        return true;
    }

    public static boolean clickTableAction(String xpath,String type, String value){

        String[] arrOfStr = type.split("-");

        int idRow = parseInt(arrOfStr[0]);
        int idAction = parseInt(arrOfStr[1]);
        String actionRow = arrOfStr[2];
        int actionType = 0;
        if(actionRow.equalsIgnoreCase("EDIT")){
            actionType = 0;
        }else {
            actionType = 1;
        }

        WebDriverWait wait = new WebDriverWait(driver, waitObject);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
        WebElement tbl = driver.findElement(By.xpath(xpath));
        WebElement colums = tbl.findElement(By.tagName("tbody"));
        List<WebElement> list = colums.findElements(By.tagName("tr"));
        int listNumber = list.size();
        System.out.println(listNumber);
        int indx = 0;
        while (indx < listNumber){

            List<WebElement> td = list.get(indx).findElements(By.tagName("td"));
            WebElement div = td.get(idRow).findElement(By.tagName("div"));
            System.out.println("ID = "+ div.getText());

            if(div.getText().equalsIgnoreCase(value)){

                WebElement divs = td.get(idAction).findElement(By.tagName("div"));
                List<WebElement> divAction = divs.findElements(By.tagName("div"));

                //System.out.println(divAction.get(0).getLocation());
                divAction.get(actionType).click();
                break;
            }
            indx++;
        }
        return true;
    }


    public static boolean chooseValDropdownByIdWeb(String id, String value){

        WebDriverWait wait = new WebDriverWait(driver, waitObject);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(id)));
        WebElement dropDown = driver.findElement(By.id(id));
        List<WebElement> list = dropDown.findElements(By.tagName("option"));
        int len = list.size();
        int indx = 0;
        while (indx < len){
            if(list.get(indx).getText().equalsIgnoreCase(value)){
                list.get(indx).click();
                break;
            }
            indx++;
        }
        return true;
    }

    public static String chooseValDropdownByIdReturnValWeb(String id, String value){

        WebDriverWait wait = new WebDriverWait(driver, waitObject);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(id)));
        WebElement dropDown = driver.findElement(By.id(id));
        List<WebElement> list = dropDown.findElements(By.tagName("option"));
        int len = list.size();
        int indx = 0;
        String val = null;
        while (indx < len){
            if(list.get(indx).getText().equalsIgnoreCase(value)){
                val = list.get(indx).getText();
                list.get(indx).click();
                break;
            }
            indx++;
        }
        return val;
    }

    public static boolean chooseValDropdownByXpathWeb(String xpath, String value){

        WebDriverWait wait = new WebDriverWait(driver, waitObject);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
        WebElement dropDown = driver.findElement(By.xpath(xpath));
        List<WebElement> list = dropDown.findElements(By.tagName("option"));
        int len = list.size();
        int indx = 0;
        while (indx < len){
            if(list.get(indx).getText().equalsIgnoreCase(value)){
                list.get(indx).click();
                break;
            }
            indx++;
        }
        return true;
    }

    public static String chooseValDropdownByXpathReturnValWeb(String xpath, String value){

        WebDriverWait wait = new WebDriverWait(driver, waitObject);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
        WebElement dropDown = driver.findElement(By.xpath(xpath));
        List<WebElement> list = dropDown.findElements(By.tagName("option"));
        int len = list.size();
        int indx = 0;
        String val = null;
        while (indx < len){
            if(list.get(indx).getText().equalsIgnoreCase(value)){
                val = list.get(indx).getText();
                list.get(indx).click();
                break;
            }
            indx++;
        }
        return val;
    }

    public static boolean chooseValDropdownByNameWeb(String name, String value){

        WebDriverWait wait = new WebDriverWait(driver, waitObject);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name(name)));
        WebElement dropDown = driver.findElement(By.name(name));
        List<WebElement> list = dropDown.findElements(By.tagName("option"));
        int len = list.size();
        int indx = 0;
        while (indx < len){
            if(list.get(indx).getText().equalsIgnoreCase(value)){
                list.get(indx).click();
                break;
            }
            indx++;
        }
        return true;
    }

    public static String chooseValDropdownByNameReturnValWeb(String name, String value){

        WebDriverWait wait = new WebDriverWait(driver, waitObject);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name(name)));
        WebElement dropDown = driver.findElement(By.name(name));
        List<WebElement> list = dropDown.findElements(By.tagName("option"));
        int len = list.size();
        int indx = 0;
        String val = null;
        while (indx < len){
            if(list.get(indx).getText().equalsIgnoreCase(value)){
                val = list.get(indx).getText();
                list.get(indx).click();
                break;
            }
            indx++;
        }
        return val;
    }

    public static boolean tableVerifyDataWeb(String id, String nameColumn, String valueVerify){

        WebDriverWait wait = new WebDriverWait(driver, waitObject);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(id)));
        WebElement table = driver.findElement(By.id(id));
        //get index column
        WebElement thead = table.findElement(By.tagName("thead"));
        WebElement tr = thead.findElement(By.tagName("tr"));
        List<WebElement> th = tr.findElements(By.tagName("th"));
        int row = th.size();
        int indx = 0;
        int indxColumn = 0;
        while (indx < row){
            if(th.get(indx).getText().equalsIgnoreCase(nameColumn)){
                //set index column
                indxColumn = indx;
                break;
            }
            indx++;
        }
        //System.out.println(indxColumn);
        WebElement tbody = table.findElement(By.tagName("tbody"));
        List<WebElement> trbody = tbody.findElements(By.tagName("tr"));
        int trbodyIndx = trbody.size();
        int i = 0;
        System.out.println("void checkData " +trbodyIndx);
        while (i < trbodyIndx){
            List<WebElement> td = trbody.get(i).findElements(By.tagName("td"));
            if(td.get(indxColumn).getText().equalsIgnoreCase(valueVerify)){
                System.out.println("value : " +td.get(indxColumn).getText() +" ; index column : "+ indxColumn);
                //td.get(indxColumn).click();
                break;
            }else{
                if(i+1 == trbodyIndx){
                    return false;
                }
            }
            i++;
        }
        return true;
    }

    public static boolean moveIframeByIdWeb(String id){

        WebDriverWait wait = new WebDriverWait(driver, waitObject);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(id)));
        WebElement element = driver.findElement(By.id(id));
        driver.switchTo().frame(element);
        return true;
    }
    public static boolean moveIframeByNameWeb(String name){

        WebDriverWait wait = new WebDriverWait(driver, waitObject);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name(name)));
        WebElement element = driver.findElement(By.name(name));
        driver.switchTo().frame(element);
        return true;
    }
    public static boolean moveIframeByXpathWeb(String xpath){

        WebDriverWait wait = new WebDriverWait(driver, waitObject);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
        WebElement element = driver.findElement(By.xpath(xpath));
        driver.switchTo().frame(element);
        return true;
    }
    public static boolean inputDatePickerByIdWeb(String id, LocalDate date){

        int days = date.getDayOfMonth();
        int moonDate = date.getMonthValue();
        int tahun = date.getYear();
        String dayDate = valueOf(days);
        WebDriverWait wait = new WebDriverWait(driver, waitObject);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(id)));
        WebElement filed = driver.findElement(By.id(id));

        List<WebElement> div1 = filed.findElements(By.tagName("div"));
        List<WebElement> div2 = div1.get(0).findElements(By.tagName("div"));
        List<WebElement> span = div2.get(0).findElements(By.tagName("span"));
        String moonText = span.get(0).getText();
        int moonVal = convertMoonToInt(moonText);

        if(moonDate > moonVal){
            int countClick = moonDate - moonVal;
            while (countClick > 0){
                clickByXpathWeb("//*[@id=\"ui-datepicker-div\"]/div/a[2]/span");
                countClick--;
            }
        }else if(moonDate < moonVal){
            int countClick = moonVal - moonDate;
            while (countClick > 0){
                clickByXpathWeb("//*[@id=\"ui-datepicker-div\"]/div/a[1]/span");
                countClick--;
            }
        }
        WebElement table = filed.findElement(By.tagName("table"));

        WebElement tbody = table.findElement(By.tagName("tbody"));
        List<WebElement> rowDay = tbody.findElements(By.tagName("tr"));
        int countRowDay = rowDay.size();
        System.out.println("countRowDay :"+countRowDay);

        for(int i= 0; i < countRowDay; i++){
            List<WebElement> row = rowDay.get(i).findElements(By.tagName("td"));

            int countRow = row.size();
            for(int j =0; j <countRow; j++){
                if(row.get(j).getText().equalsIgnoreCase(dayDate)){
                    row.get(j).click();
                }
            }
        }
        return true;
    }


    public static boolean searchingTableByValue(String xpath, String value){

        WebDriverWait wait = new WebDriverWait(driver, waitObject);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
        WebElement element = driver.findElement(By.xpath(xpath));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("tr")));
        List<WebElement> tr = element.findElements(By.tagName("tr"));
        System.out.println(tr.size());
        for(int i=0; i<tr.size(); i++){

            List<WebElement> td = tr.get(i).findElements(By.tagName("td"));
            if(td.get(1).getText().equalsIgnoreCase(value)){
                System.out.println(td.get(1).getText());
                WebElement a = td.get(1).findElement(By.tagName("a"));
                a.click();
                break;
            }
        }
        return true;
    }

    public static boolean jsScrollDown(int scroll) throws InterruptedException {

        JavascriptExecutor js = (JavascriptExecutor) driver;
        for(int i = 0; i< scroll; i++){
            //Thread.sleep(1000);
            js.executeScript("javascript:window.scrollBy(250,350)");
        }

        return true;
    }

    public static byte[] screenshot() throws InterruptedException {
        Thread.sleep(2000);
        byte[] bytes = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);

        return bytes;
    }

    public static boolean pressKey(String key) throws InterruptedException {

        Actions action = new Actions(driver);
        switch(key) {
            case "ENTER":
                action.sendKeys(Keys.ENTER).build().perform();
                break;
            case "ARROW_DOWN":
                action.sendKeys(Keys.ARROW_DOWN).build().perform();
                break;
            case "ARROW_UP":
                action.sendKeys(Keys.ARROW_UP).build().perform();
                break;
            case "ARROW_LEFT":
                action.sendKeys(Keys.ARROW_LEFT).build().perform();
                break;
            case "ARROW_RIGHT":
                action.sendKeys(Keys.ARROW_RIGHT).build().perform();
                break;
            case "BACK_SPACE":
                action.sendKeys(Keys.BACK_SPACE).build().perform();
                break;
            case "DELETE":
                action.sendKeys(Keys.DELETE).build().perform();
                break;
            case "PAGE_DOWN":
                action.sendKeys(Keys.PAGE_DOWN).build().perform();
                break;
            case "PAGE_UP":
                action.sendKeys(Keys.PAGE_UP).build().perform();
                break;
            case "F5":
                action.sendKeys(Keys.F5).build().perform();
                break;
            case "ESCAPE":
                action.sendKeys(Keys.ESCAPE).build().perform();
                break;
            default:
                action.sendKeys(Keys.END).build().perform();
        }
        Thread.sleep(2000);
        return true;
    }
    private static int convertMoonToInt(String moon){
        moon = moon.toLowerCase();
        int intMoon = 0;
        switch(moon) {
            case "january":
                intMoon = 1;
                break;
            case "february":
                intMoon = 2;
                break;
            case "march":
                intMoon = 3;
                break;
            case "april":
                intMoon = 4;
                break;
            case "may":
                intMoon = 5;
                break;
            case "june":
                intMoon = 6;
                break;
            case "july":
                intMoon = 7;
                break;
            case "august":
                intMoon = 8;
                break;
            case "september":
                intMoon = 9;
                break;
            case "october":
                intMoon = 10;
                break;
            case "november":
                intMoon = 11;
                break;
            case "december":
                intMoon = 12;
                break;
            default:
                intMoon = 0;
        }
        return intMoon;
    }

}


