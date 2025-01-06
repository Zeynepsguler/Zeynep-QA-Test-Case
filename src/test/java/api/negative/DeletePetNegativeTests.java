package api.negative;

import api.Base;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import org.testng.Assert;
//import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class DeletePetNegativeTests extends Base {

    @Test
    public void testDeleteWithInvalidId() {
       // String invalidId = "999";
       // String endpoint = "/pet/" + invalidId;

        requestSpec.pathParams("first", "pet", "second", 9999);
        Response response = given(requestSpec).when().delete("{first}/{second}");



        int statusCode = response.getStatusCode();
        System.out.println(statusCode);

        Assert.assertEquals(response.getStatusCode(), 404, "Status code should be 404 for invalid ID");




    }





}