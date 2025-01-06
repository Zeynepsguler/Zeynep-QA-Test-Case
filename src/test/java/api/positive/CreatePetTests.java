package api.positive;


import api.Base;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CreatePetTests extends Base {

    @Test(priority = 1, description = "create pet")

    public void testCreatePet() {
        String requestBody = "{ \"id\": 123, \"name\": \"Doggie\", \"status\": \"available\" }";

        Response response = requestSpec
                .body(requestBody)
                .post("/pet");

        Assert.assertEquals(response.getStatusCode(), 200, "Status code should be 200");
        Assert.assertTrue(response.getBody().asString().contains("Doggie"), "The response should contain 'Doggie'");
    }
}
