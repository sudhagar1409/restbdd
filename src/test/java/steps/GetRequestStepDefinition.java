package steps;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.cucumber.datatable.DataTable;
import io.restassured.RestAssured;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GetRequestStepDefinition {

	RequestSpecification request = null;
	Response response = null;

	@Given("I am creating a request with end points")
	public void resourceswithendpoint() {

		RestAssured.baseURI = "https://dev211370.service-now.com/api/now/table/incident";

	}

	@And("I am using basic aunthetication")
	public void authetication() {

		RestAssured.authentication = RestAssured.basic("admin", "s0IRa*EaGh3$");

	}

	@And("I am constructing a request with query paramter as {string} and {string}")
	public void requestCreation(String sysparm_fields, String category) {

		request = RestAssured.given().log().all().queryParam(sysparm_fields, category);

	}

	@When("I am sending the get request")
	public void sendRequest() {

		response = request.get();

	}

	@Then("I validate the response of get request")
	public void validateRequest() {

		response.then().log().all().assertThat().statusCode(200);

	}

	@When("I am constructing a request with query paramter")
	public void requestCreation(DataTable dt) {

		// Map<String,String> asMap= dt.asMap();

		Map<String, String> asMap = new HashMap<String, String>();

		asMap.put("sysparm_fields", "category");
		asMap.put("category", "inquiry");
		request = RestAssured.given().queryParams(asMap);
		response = request.get();
	}

}
