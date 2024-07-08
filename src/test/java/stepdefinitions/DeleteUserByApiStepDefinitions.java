package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import static org.junit.Assert.assertEquals;
import static base_urls.ContactListBaseUrl.spec;
import static io.restassured.RestAssured.given;

public class DeleteUserByApiStepDefinitions {
    Response response;  // when de olusturulan Response Then de de kullanmak icin burada tanimladik
    @Given("set the url for delete request")
    public void setTheUrlForDeleteRequest() {

        spec.pathParams("first","users","second","me");

    }

    @When("send the delete request and get the response")
    public void sendTheDeleteRequestAndGetTheResponse() {
        response = given(spec).delete("{first}/{second}");
        response.prettyPrint();

    }

    @Then("do assertion for delete request")
    public void doAssertionForDeleteRequest() {
       // response.then().statusCode(200); veya
        assertEquals(response.statusCode(), 200);  // status code should be 200
        assert response.asString().isEmpty();  // body should be empty

    }
}
