package com.api.stepdefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Assert;

import static io.restassured.RestAssured.when;

public class GetStepDefinition {
    private static Response response;
    private static final String baseUrl = "https://jsonplaceholder.typicode.com/";
    private static String source;
    private static Integer status;

    @Given("the user retrieves {string}")
    public void theUserRetrieves(String string) {
        when().get(baseUrl + string).then();
        source = string;
    }

    @When("it uses the identification {string}")
    public void itUsesTheIdentification(String id) {
        response = when().get(baseUrl + source + '/' + id).then().extract().response();
        status = response.statusCode();
        JSONObject json = new JSONObject(response.getBody().asString());
        Assert.assertEquals(id, json.get("id").toString());
    }

    @Then("it should returns {string}")
    public void itShouldReturns(String string) {
        JSONObject json = new JSONObject(response.getBody().asString());
        Assert.assertEquals(string, json.get("title"));
    }

    @And("status {int}")
    public void status(Integer int1) {
        Assert.assertEquals(status, int1);
    }

}