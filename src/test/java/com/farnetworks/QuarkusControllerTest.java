package com.farnetworks;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class QuarkusControllerTest {

    @Test
    public void testHelloEndpoint() {
        given()
          .when().get("/quarkus/hello")
          .then()
             .statusCode(200)
             .body(is("Hello Quarkus"));
    }

}