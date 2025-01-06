package api.positive;

import api.Base;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ReadPetTests extends Base {

    @Test(priority = 2, description = "get pet")

    public void testGetById(){

        Response response = requestSpec
                .get("/pet/123");

        Assert.assertEquals(response.getStatusCode(), 200,  "Status code should be 200");
        Assert.assertTrue(response.getBody().asString().contains("Doggie"), "The response should contain 'Doggie'");
    }
}
