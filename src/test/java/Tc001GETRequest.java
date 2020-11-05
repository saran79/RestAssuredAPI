import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;
import org.testng.annotations.Test;

public class Tc001GETRequest {

  //  @Test
   static void getWeatherDetails(){
        // specify Base URI

        RestAssured.baseURI="http://dummy.restapiexample.com/api/v1";

        //request object created
        RequestSpecification httpRequest = RestAssured.given();

        // response object
        Response response = httpRequest.request(Method.GET,"/employee/1");

        //print response in console window JSOn to string
         String responseBody = response.getBody().asString();
        System.out.println("Response Body is :" + responseBody);
        // assert status code
         int statusCode = response.getStatusCode();
       System.out.println(" Status code is :"+statusCode);
       Assert.assertEquals(statusCode,200);
    }

    public static void main(String[] args) {

       getWeatherDetails();
    }
}
