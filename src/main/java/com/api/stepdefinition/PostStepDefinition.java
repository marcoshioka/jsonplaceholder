package com.api.stepdefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Assert;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class PostStepDefinition {

    private static Response response;
    private static final String baseUrl = "https://jsonplaceholder.typicode.com/";
    private static Integer status;

    @Given("the user creates {string}, with name {string}, message {string} and id {int}")
    public void theUserCreatesWithNameMessageAndId(String string, String string2, String string3, Integer int1) {
        Map<String, Object> content = new HashMap<>();
        content.put("title", string2);
        content.put("body", string3);
        content.put("userId", int1);
        response = given().contentType(ContentType.JSON).
                body(content).
                when().post(baseUrl + string).then().extract().response();
        status = response.statusCode();
    }

    @When("it gets status {int}")
    public void itGetsStatus(Integer int1) {
        Assert.assertEquals(status, int1);
    }

    @Then("it should contains the same name {string}, message {string} and id {int}")
    public void itShouldContainsTheSameNameMessageAndId(String string, String string2, Integer int1) {
        JSONObject json = new JSONObject(response.getBody().asString());
        Assert.assertEquals(string, json.get("title").toString());
        Assert.assertEquals(string2, json.get("body").toString());
        Assert.assertEquals(int1, json.get("userId"));
    }

}
