package validation;

import com.jayway.restassured.response.Response;
import org.testng.asserts.SoftAssert;

public class ServiceAAsserts extends BaseAssert{
    //status code 201
    public static void assertSuccess201(Response response) {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(response.statusCode(), 201, "Status code is not expected");
        softAssert.assertAll();
    }

    //status code 404
    public static void assertFailedNotAllowed(Response response) {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(response.statusCode(), 405, "Status code is not expected");
        softAssert.assertAll();
    }
}
