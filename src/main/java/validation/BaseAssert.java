package validation;

import org.testng.asserts.SoftAssert;
import com.jayway.restassured.response.Response;

public class BaseAssert {

    //status code 200
    public static void assertSuccess200(Response response){
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(response.statusCode(), 200, "Status code is not expected");
        softAssert.assertAll();
    }

    //status code 404
    public static void assertFailedNotFound(Response response) {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(response.statusCode(), 404, "Status code is not expected");
        softAssert.assertAll();
    }

    //status code 401
    public static void assertFailedUnauthorized(Response response) {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(response.statusCode(), 401, "Status code is not expected");
        softAssert.assertAll();
    }

    //status code 403
    public static void assertFailedForbidden(Response response) {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(response.statusCode(), 403, "Status code is not expected");
        softAssert.assertAll();
    }

    //status code 500
    public static void assertFailedInternalServerError(Response response) {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(response.statusCode(), 500, "Status code is not expected");
        softAssert.assertAll();
    }

    //status code 400
    public static void assertFailedBadRequest(Response response) {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(response.statusCode(), 400, "Status code is not expected");
        softAssert.assertAll();
    }

    //status code 409
    public static void assertFailedConflict(Response response) {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(response.statusCode(), 409, "Status code is not expected");
        softAssert.assertAll();
    }

    //status code 405
    public static void assertMethodNotAllowed(Response response) {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(response.statusCode(), 405, "Status code is not expected");
        softAssert.assertAll();
    }
}
