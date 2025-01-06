package api.positive;

import api.Base;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DeletePetTest extends Base {
    @Test(priority = 4, description = "delete pet")
    public void testDeletePet() {

        Response response = requestSpec
                .delete("/pet/123");


        Assert.assertEquals(response.getStatusCode(), 200, "Status code should be 200");
        Assert.assertTrue(response.getBody().asString().contains("123"), "The response should contain the ID.");
    }


}
