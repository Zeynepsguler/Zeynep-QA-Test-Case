package api.positive;

import api.Base;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;


@Test(priority = 3, description = "update pet")

public class UpdatePetTest extends Base {

    public void UpdatePet() {

        String updatedRequestBody = "{ \"id\": 123, \"name\": \"Doggie\", \"status\": \"sold\" }";


        Response response = requestSpec
                .body(updatedRequestBody)
                .put("/pet");

        Assert.assertEquals(response.getStatusCode(),200, "Status code should be 200");
        Assert.assertTrue(response.getBody().asString().contains("sold"), "The response should contain 'sold'");

    }
}
