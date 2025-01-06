package api;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeClass;

public class Base {

    protected RequestSpecification requestSpec;

    @BeforeClass
    public void setup() {

        RestAssured.baseURI = "https://petstore.swagger.io/v2";
        RestAssured.useRelaxedHTTPSValidation();


        requestSpec = RestAssured.given()
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer <token>");



    }

    public RequestSpecification getRequestSpec() {
        return requestSpec;
    }
}