package steps;

import java.io.File;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PostRequestStepDefinition {

	RequestSpecification request = null;
	Response response = null;

	@Given("I am create the resources with endpoint")
	public void resourceswithendpoint() {

		RestAssured.baseURI = "https://dev211370.service-now.com/api/now/table/incident";

	}

	@And("I am allowing the authetication")
	public void authetication() {

		RestAssured.authentication = RestAssured.basic("admin", "s0IRa*EaGh3$");

	}

	@And("I am adding the headers and body of the request")
	public void requestCreation() {

		File requestBody = new File("src/test/resources/file.json");

		request = RestAssured.given().contentType(ContentType.JSON).body(requestBody);

	}

	@When("I am sending the request")
	public void sendRequest() {

		response = request.post();

	}

	@Then("I validate the response")
	public void validateRequest() {

		response.then().assertThat().statusCode(201);

	}

	@Then("I print the sys_id")
	public void printSysID() {

		String sysid = response.jsonPath().get("result.sys_id");
		System.out.println(sysid);

	}

	@And("I am adding the headers and body of the request as {string} and {string}")

	public void postrequestwithmultiple(String description, String category) {

		request.given().contentType(ContentType.JSON)
				.body("{\"description\":\"" + description + ",\r\n" + "\"category\" : \"" + category + "}");

	}

}
