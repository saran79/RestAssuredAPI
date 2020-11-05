package restAssure;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class Tc003GETRequest {

    @Test
    void getEmployeeDetails(){

        given().
        when().
                get("http://dummy.restapiexample.com/api/v1/employee/1").
        then().
                assertThat().
                statusCode(200);


    }
}
