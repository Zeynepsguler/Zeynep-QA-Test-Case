package api.negative;

import api.Base;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ReadPetNegativeTests extends Base {

    @BeforeClass
    public void setupRelaxedHTTPS() {

        RestAssured.useRelaxedHTTPSValidation();
    }

    @Test(priority = 1, description = "Negative test for reading a pet with an invalid ID")
    public void testReadPetWithInvalidId() {

        String invalidPetId = "1000";

        Response response = requestSpec
                .get("/pet/" + invalidPetId);


        Assert.assertEquals(response.getStatusCode(), 400, "Expected status code is 400 for non-existing pet ID");
        Assert.assertTrue(response.getBody().asString().contains("Invalid ID supplied"), "Error message should be 'Pet not found'");
    }
}
