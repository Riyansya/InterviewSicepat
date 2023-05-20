package base.sicepat;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static automation.config.ChromeLib.waitObject;
import static automation.config.ChromeLib.webDrivers;
import static java.lang.Integer.parseInt;

public class BaseStepDef {

    public static boolean addToCarts(String className){
        WebDriverWait wait = new WebDriverWait(webDrivers(), waitObject);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className(className)));
        List<WebElement> divCart = webDrivers().findElements(By.className(className));

        for(int i = 0; i< divCart.size(); i++){
            divCart.get(i).findElement(By.tagName("button")).click();
        }
        return true;
    }

    public static int getValueProducts(String className){
        WebDriverWait wait = new WebDriverWait(webDrivers(), waitObject);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className(className)));
        List<WebElement> div = webDrivers().findElements(By.className(className));
        int priceAll = 0;
        for(int i = 0; i< div.size(); i++){
            String val = div.get(i).getText();

            String prices = val.replaceAll("[$.]", "");
            int price = parseInt(prices);
            priceAll = priceAll+price;

        }
        return priceAll;
    }

    public static int getValueProduct(String className, int row){
        WebDriverWait wait = new WebDriverWait(webDrivers(), waitObject);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className(className)));
        List<WebElement> div = webDrivers().findElements(By.className(className));

        String val = div.get(row).getText();
        String prices = val.replaceAll("[$.]", "");
        return parseInt(prices);
    }

    public static int addToCart(String className, String inventory_name){

        WebDriverWait wait = new WebDriverWait(webDrivers(), waitObject);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className(className)));
        List<WebElement> divCart = webDrivers().findElements(By.className(className));
        int j = 0;
        for(int i = 0; i< divCart.size(); i++){
            if(divCart.get(i).getText().equalsIgnoreCase(inventory_name)){
                System.out.println(i);
                j = i;
                break;
            }

        }
        return j;

    }

    public static boolean addToCartByRow(String className, int row){
        WebDriverWait wait = new WebDriverWait(webDrivers(), waitObject);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className(className)));
        List<WebElement> divCart = webDrivers().findElements(By.className(className));

        divCart.get(row).findElement(By.tagName("button")).click();
        return true;
    }
}
