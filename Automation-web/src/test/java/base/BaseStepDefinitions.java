package base;

import automation.config.GlobalVariable;
import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.util.ArrayList;
import java.util.List;

public abstract class BaseStepDefinitions {

    public GlobalVariable globalVariable = GlobalVariable.getInstance();
    public Response response;

    public RequestSpecification createHeaderHttpRequest(String token) {
        RequestSpecification requestSpecification = RestAssured.given();
        requestSpecification.header("Authorization", token);
        return requestSpecification;
    }

    public RequestSpecification createPublicHeaderHttpRequest() {
        Header h1= new Header("Accept", "*/*");
        Header h2 = new Header("Content-Type", "application/json");
        List<Header> list = new ArrayList<Header>();
        list.add(h1);
        list.add(h2);

        Headers header = new Headers(list);

        return RestAssured.given().headers(header);
    }
    public RequestSpecification deletePublicHeaderHttpRequest(){

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

    public Response publicDeleteRequest(String path, String endpoint){
        String url = globalVariable.environment + endpoint;
        System.out.println("==================================================");
        System.out.println("Environment: " + globalVariable.environment);
        System.out.println("Get Request: " + url);
        System.out.println("Path: " + path);
        return deletePublicHeaderHttpRequest().delete(url + path);
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

}