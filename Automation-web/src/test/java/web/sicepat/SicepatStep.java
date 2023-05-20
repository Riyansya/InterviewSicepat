package web.sicepat;

import automation.config.ChromeLib;
import base.BaseStepDefinitions;
import base.sicepat.BaseStepDef;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.When;
import org.junit.Assert;

import static automation.config.ChromeLib.*;
import static java.lang.Integer.parseInt;


public class SicepatStep extends BaseStepDefinitions {

    BaseStepDef baseStepDef = new BaseStepDef();
    @When("^Open Web Sicepat test url (.*)$")
    public void openWebSicepat(String url) {
        openChrome(url);
    }


    @When("Login Sicepat test")
    public void loginSicepat() {

        String text = getTextByIdWeb("login_credentials");
        String[] arrText = text.split(":", 0);
        String[] arrTextUser = arrText[1].split("\n", 0);

        String dataLogin = getTextByClassName("login_password");
        String[] arrLogin = dataLogin.split(":", 0);
        String[] arrLonginUser = arrLogin[1].split("\n", 0);

        inputByIdWeb("user-name", arrTextUser[1]);
        inputByIdWeb("password", arrLonginUser[1]);
        clickByIdWeb("login-button");
    }

    @When("Transaksi Sicepat test")
    public void transaksiSicepats() throws InterruptedException {

        baseStepDef.addToCarts("pricebar");
        int priceTotal = baseStepDef.getValueProducts("inventory_item_price");
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

        int totalCart = priceTotal+(parseInt(tax));
        String totalData = getTextByXpathWeb("//*[@id=\"checkout_summary_container\"]/div/div[2]/div[8]");
        String[] totalDatas = totalData.split(":", 0);
        String total = totalDatas[1].replaceAll("[$. ]", "");

        int totals = parseInt(total);
        Assert.assertEquals(totalCart, totals);
        clickByIdWeb("finish");
    }

    @AfterStep
    public void screenshot(Scenario scenario) throws InterruptedException {
        byte[] file = ChromeLib.screenshot();
        scenario.attach(file, "image/png", scenario.getName());
    }

}
