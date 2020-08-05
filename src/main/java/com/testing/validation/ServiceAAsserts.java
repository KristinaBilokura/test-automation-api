package com.testing.validation;

import com.testing.jsonfactory.ServiceAResponse;
import com.testing.jsonfactory.jsonconverters.JsonConverter;
import com.testing.model.InfoRequestModel;
import io.restassured.response.Response;
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

    public static void assureTestInfoSuccess(Response response, InfoRequestModel infoRequestModel) {
        SoftAssert asert = new SoftAssert();
        ServiceAResponse ServiceAResponse = JsonConverter.convertJsonToObject(response, ServiceAResponse.class);
        asert.assertEquals(ServiceAResponse.getFirstName(), infoRequestModel.getFirstName().toString(), "First name is not expected");
        asert.assertEquals(ServiceAResponse.getLastName(), infoRequestModel.getLastName().toString(), "Last name is not expected");
        asert.assertEquals(ServiceAResponse.getCity(), infoRequestModel.getCity().toString(), "City is not expected");
        asert.assertEquals(ServiceAResponse.getCountry(), infoRequestModel.getCountry().toString(), "Country is not expected");
        asert.assertEquals(response.statusCode(), 200, "Status is not expected");
        asert.assertAll();
    }
}
