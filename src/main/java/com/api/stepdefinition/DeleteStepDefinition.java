package com.api.stepdefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;
import org.junit.Assert;

import static io.restassured.RestAssured.when;

public class DeleteStepDefinition {
    private static Response response;
    private static final String baseUrl = "https://jsonplaceholder.typicode.com/";
    private static Integer status;

    @Given("the user deletes {string} with {int}")
    public void theUserDeletesWith(String source, Integer id) {
        response = when().get(baseUrl + source + '/' + id).then().extract().response();
        status = response.statusCode();
    }

    @When("it returns response status {int}")
    public void itReturnsResponseStatus(Integer int1) {
        Assert.assertEquals(status, int1);
    }

    @Then("the response should be empty {string}")
    public void theResponseShouldBeEmpty(String string) {
        Assert.assertEquals("", string);
    }

}
