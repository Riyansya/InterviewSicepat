package web.sicepat2;

import base.BaseStepDefinitions;
import base.sicepat.BaseStepDef;
import io.cucumber.java.en.When;
import org.junit.Assert;

import static automation.config.ChromeLib.*;
import static java.lang.Integer.parseInt;


public class SicepatStep2 extends BaseStepDefinitions {

    BaseStepDef baseStepDef = new BaseStepDef();
    @When("^Transaksi Sicepat2 test cart (.*)$")
    public void transaksiSicepat(String cart) throws InterruptedException {

        int rowCart = baseStepDef.addToCart("inventory_item_name", cart);//Sauce Labs Bike Light / Sauce Labs Backpack / Sauce Labs Bolt T-Shirt / Sauce Labs Fleece Jacket
        baseStepDef.addToCartByRow("pricebar", rowCart);
        int price = baseStepDef.getValueProduct("inventory_item_price", rowCart);
        System.out.println(price);

        clickByIdWeb("shopping_cart_container");
        jsScrollDown(2);

        clickByNameWeb("checkout");
        inputByIdWeb("first-name", "budi");
        inputByNameWeb("lastName", "test");
        inputByNameWeb("postalCode", "12345");
        clickByIdWeb("continue");

        jsScrollDown(3);
        String taxData = getTextByClassName("summary_tax_label");
        String[] taxS = taxData.split(":", 0);
        String tax = taxS[1].replaceAll("[$. ]", "");

        int totalCart = price+(parseInt(tax));
        String totalData = getTextByXpathWeb("//*[@id=\"checkout_summary_container\"]/div/div[2]/div[8]");
        String[] totalDatas = totalData.split(":", 0);
        String total = totalDatas[1].replaceAll("[$. ]", "");

        int totals = parseInt(total);
        Assert.assertEquals(totalCart, totals);
        clickByIdWeb("finish");
        //close();
    }

}
