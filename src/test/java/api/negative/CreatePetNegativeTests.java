package api.negative;

import api.Base;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CreatePetNegativeTests extends Base{


    @Test(description = "Attempt to create a pet with an invalid JSON format")
    public void testCreatePetWithInvalidJsonFormat() {


        String invalidJson = "{"
                + "\"id\": 0,"
                + "\"category\": {"
                + "\"id\": 0,"
                + "\"name\": \"string\""
                + "},"
                + "\"name\": \"doggie\","
                + "\"photoUrls\": [\"string\"],"
                + "\"tags\": [{\"id\": 0, \"name\": \"string\"}],"
                + "\"status\": \"available\"";


        Response response = requestSpec
                .body(invalidJson)
                .post("/pet");


        System.out.println("Response Body: " + response.getBody().asString());

        Assert.assertEquals(response.getStatusCode(), 400, "Status code should be 400 for invalid JSON format");
        Assert.assertTrue(response.getBody().asString().contains("bad input"), //Burada aslında invalid input yazması lazım
                "Response body should contain 'bad input' message");
    }


    @Test
    public void postWithEmptyBody() {
        String endpoint = "/pet";

        Response response = requestSpec
                .body("")
                .post(endpoint);

        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode, 405, "Expected 405 Bad Request for empty body");
    }


}