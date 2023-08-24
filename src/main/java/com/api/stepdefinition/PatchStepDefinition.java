package com.api.stepdefinition;

import io.cucumber.java.en.*;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.json.JSONObject;
import org.junit.Assert;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class PatchStepDefinition {

    private static final Logger LOG = LogManager.getLogger(Hooks.class);
    private static Response response;
    private static final String baseUrl = "https://jsonplaceholder.typicode.com/";
    private static String source;
    private static Integer status;

    @When("the user updates that {string} id {int} with just the name to {string}")
    public void theUserUpdatesThatIdWithJustTheNameTo(String string, Integer int1, String string2) {
        Map<String, Object> patchContent = new HashMap<>();
        patchContent.put("title", string2);
        response = given().contentType(ContentType.JSON).
                body(patchContent).
                when().patch(baseUrl + string + '/' + int1).then().extract().response();
        status = response.statusCode();
    }

    @Then("the status received should be {int}")
    public void theStatusReceivedShouldBe(Integer int1) {
        Assert.assertEquals(status, int1);
    }

    @Then("the {int} should be the same")
    public void theShouldBeTheSame(Integer int1) {
        JSONObject json = new JSONObject(response.getBody().asString());
        Assert.assertEquals(int1, json.get("id"));
    }

    @But("the title must be the updated {string}")
    public void theTitleMustBeTheUpdated(String newTitle) {
        JSONObject json = new JSONObject(response.getBody().asString());
        Assert.assertEquals(newTitle, json.get("title"));
    }

}
