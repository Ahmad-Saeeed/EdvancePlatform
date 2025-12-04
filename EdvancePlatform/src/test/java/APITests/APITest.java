package APITests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.URL;

public class APITest {
    @Test
    public void coursesAPI() {
        String apiDocumentation = "https://documenter.getpostman.com/view/37731054/2sB3dLVCTz";
        String coursesAPI = "https://isitmondaytoday2.com/api/courses";

        Response response = RestAssured.get(apiDocumentation);
//        Response response = RestAssured.get(coursesAPI);

        System.out.println("Status Code: " + response.getStatusCode());
        //System.out.println("Response: " + response.asString());
        System.out.println("Body: " + response.getBody());
        System.out.println("Time Taken: " + response.getTime());
        System.out.println("Header: " + response.getHeader("content-type"));
        System.out.println("Class:" + response.getClass());

        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode,200);
    }
}
