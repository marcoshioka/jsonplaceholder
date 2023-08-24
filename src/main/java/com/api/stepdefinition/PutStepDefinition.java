package com.api.stepdefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.json.JSONObject;
import org.junit.Assert;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class PutStepDefinition {
    private static Response response;
    private static final String baseUrl = "https://jsonplaceholder.typicode.com/";
    private static Integer status;

    @Given("the user updates an existing {string}, with name {string}, message {string}, user id {int} and id {int}")
    public void theUserUpdatesAnExistingWithNameMessageUserIdAndId(String string, String string2, String string3, Integer int1, Integer int2) {
        Map<String, Object> putContent = new HashMap<>();
        putContent.put("title", string2);
        putContent.put("body", string3);
        putContent.put("userId", int1);
        putContent.put("id", int2);
        response = given().contentType(ContentType.JSON).
                body(putContent).
                when().put(baseUrl + string + '/' + int1).then().extract().response();

        status = response.statusCode();
    }

    @When("it returns status {int}")
    public void itReturnsStatus(Integer int1) {
        Assert.assertEquals(status, int1);
    }

    @Then("it should contains name {string}, message {string}, user id {int} and id {int}")
    public void itShouldContainsNameMessageUserIdAndId(String string, String string2, Integer int1, Integer int2) {
        JSONObject json = new JSONObject(response.getBody().asString());
        Assert.assertEquals(string, json.get("title").toString());
        Assert.assertEquals(string2, json.get("body").toString());
        Assert.assertEquals(int1, json.get("userId"));
        Assert.assertEquals(int2, json.get("id"));
    }

}


