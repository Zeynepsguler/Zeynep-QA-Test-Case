package api.negative;

import api.Base;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UpdatePetNegativeTests extends Base {

    @Test(description = "Attempt to update a pet with an invalid ID")
    public void testUpdatePetWithInvalidId() {
        JSONObject requestParams = new JSONObject();
        requestParams.put("id", "invalid-id"); // Invalid ID
        requestParams.put("name", "Doggie");

        Response response = requestSpec
                .body(requestParams.toString())
                .put("/pet");

        Assert.assertEquals(response.getStatusCode(), 404, "Status code should be 404 for pet not found");
        Assert.assertTrue(response.getBody().asString().contains("Pet not found"),
                "Response should indicate that the pet was not found");
    }
}
