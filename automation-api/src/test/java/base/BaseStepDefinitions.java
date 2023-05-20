package base;

import automation.config.GlobalVariable;
import automation.config.StatusCode;
import automation.model.base.BasicResponse;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public abstract class BaseStepDefinitions {

    public GlobalVariable globalVariable = GlobalVariable.getInstance();
    public Response response;

    public RequestSpecification createHeaderHttpRequest(String token) {
        RequestSpecification requestSpecification = RestAssured.given();
        requestSpecification.header("Authorization", token);
        return requestSpecification;
    }

    public RequestSpecification createPublicHeaderHttpRequest() {
        return RestAssured.given();
    }

    public Response publicPostRequest(String json, String endpoint) {
        String url = globalVariable.environment + endpoint;
        System.out.println("==================================================");
        System.out.println("Environment: " + globalVariable.environment);
        System.out.println("POST Request: " + url);
        System.out.println("Body: " + json);
        return createPublicHeaderHttpRequest().body(json).post(url);
    }

    public Response publicPutRequest(String json, String endpoint) {
        String url = globalVariable.environment + endpoint;
        System.out.println("==================================================");
        System.out.println("Environment: " + globalVariable.environment);
        System.out.println("PUT Request: " + url);
        System.out.println("Body: " + json);
        return createPublicHeaderHttpRequest().body(json).put(url);
    }

    public Response publicGetRequest(String path, String endpoint){
        String url = globalVariable.environment + endpoint;
        System.out.println("==================================================");
        System.out.println("Environment: " + globalVariable.environment);
        System.out.println("Get Request: " + url);
        System.out.println("Path: " + path);
        return createPublicHeaderHttpRequest().get(url + path);
    }

    public Response postRequest(String token, String json, String endpoint) {
        System.out.println("==================================================");
        System.out.println("Environment: " + globalVariable.environment);
        System.out.println("Authorization: " + token);
        System.out.println("POST Request: " + globalVariable.environment + endpoint);
        System.out.println("Body: " + json);
        return createHeaderHttpRequest(token).body(json).post(globalVariable.environment + endpoint);
    }

    public Response getRequest(String token, String path) {
        System.out.println("==================================================");
        System.out.println("Environment: " + globalVariable.environment);
        System.out.println("GET Request: " + globalVariable.environment + path);
        return createHeaderHttpRequest(token).get(globalVariable.environment + path);
    }

    public void verifyOkResponse() {
        BasicResponse model = BasicResponse.toModel(response.asString());
        StatusCode code = StatusCode.getCode(model.status);
        if (code == StatusCode.OK) {
            int status = model.status;
            // globalVariable.setUserToken(model.token.token);
            System.out.println("Status: " + status + "\nMessage: " + model.message);
        } else {
            System.out.println("Message: " + model.message);
        }
        System.out.println("==================================================");
        System.out.println("Response: \n" + response.prettyPrint());
    }

    public void verifyBadRequestResponse() {
        BasicResponse model = BasicResponse.toModel(response.asString());
        StatusCode code = StatusCode.getCode(model.status);
        if (code == StatusCode.BAD_REQUEST) {
            System.out.println("Message: " + model.message);
        } else {
            System.out.println("Message: Unexpected Error");
        }
        System.out.println("==================================================");
        System.out.println("Response: \n" + response.prettyPrint());
    }

    public void logError(BasicResponse baseResponse, String endpoint) {
        System.out.println("================= Response Error =================");
        System.out.println("Request Error: " + baseResponse.message);
        System.out.println("Endpoint: " + endpoint);
        System.out.println("Message: " + baseResponse.message);
    }

    public void logFailed(BasicResponse baseResponse, String endpoint) {
        System.out.println("================= Response Failed =================");
        System.out.println("Request Failed: " + baseResponse.message);
        System.out.println("Endpoint: " + endpoint);
        System.out.println("Message: " + baseResponse.message);
    }
}