package restAssure;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.junit.Assert;
import org.testng.annotations.Test;

public class Tc002POSTRequest {

    @Test
    void postEmployeeDetails(){
        //specify the URI
        RestAssured.baseURI = "http://dummy.restapiexample.com/api/v1";
        // Request Object
        RequestSpecification httpRequest = RestAssured.given();

    // Request Payload sending along with Post Request
        JSONObject requestParams = new JSONObject();

        requestParams.put("name","test");
        requestParams.put("salary","123");
        requestParams.put("age","23");

        httpRequest.header("Content-Type","application/JSON");
        httpRequest.body(requestParams.toJSONString()); // attach data to the request

//      Response Object

        Response response = httpRequest.request(Method.POST,"/create");

        String responseBody = response.asString();
        System.out.println("Response Body is: "+responseBody);

        int statusCode = response.getStatusCode();
        System.out.println("Status code is :"+statusCode);
        Assert.assertEquals(statusCode,201);

        String successCode = response.jsonPath().get("status");
        Assert.assertEquals("success",successCode);

    }
}
