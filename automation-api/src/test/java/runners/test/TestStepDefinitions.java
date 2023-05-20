package runners.test;

import automation.model.test.request.GetApiTest;
import base.BaseStepDefinitions;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import constant.APIs;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;



public class TestStepDefinitions extends BaseStepDefinitions {
    @When("API get Test")
    public void getApi() {
        GetApiTest request = new GetApiTest();
        response = publicGetRequest(request.params, APIs.Test.GET_API);
       // System.out.println("response : "+response.asPrettyString());
    }

    @Then("Verify response should be ok")
    public void verifyResponse() {
        response.then().statusCode(200);

        String json = response.asString();
        JsonParser parser = new JsonParser();
        JsonElement tradeElement = parser.parse(json);
        JsonArray trade = tradeElement.getAsJsonArray();
        int s = trade.size();
        for (int i=0; i<s; i++){
            JsonObject jo = (JsonObject)parser.parse(trade.get(i).toString());
            Assert.assertNotNull(jo.get("userId"));
            Assert.assertNotNull(jo.get("body"));
            Assert.assertNotNull(jo.get("title"));
            Assert.assertNotNull(jo.get("id"));
            ExtentCucumberAdapter.getCurrentStep().log(Status.INFO, "{<br>&nbsp'userId': "+ jo.get("userId")+",<br>&nbsp'id': "+jo.get("id")+",<br>&nbsp'title': "+jo.get("title")+",<br>&nbsp'body': "+jo.get("body")+",<br>},");
        }
    }



}
