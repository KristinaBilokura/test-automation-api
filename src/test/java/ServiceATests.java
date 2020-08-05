import com.testing.jsonfactory.ServiceAResponse;
import com.testing.jsonfactory.jsonconverters.JsonConverter;
import com.testing.model.InfoRequestModelBuilder;
import com.testing.model.RandomModelGenerator;
import org.junit.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Test;
import com.testing.fakes.service.CustomClientService;
import com.testing.validation.ServiceAAsserts;

public class ServiceATests extends BaseTest {

    @Autowired
    private CustomClientService customClientService;

    @Before()
    public void createInfo() {
        infoRequestModel = RandomModelGenerator.generateRandomInfo();
        response = httpRestClient.callHttpPost("/client",
                JsonConverter.convertObjectToJson(infoRequestModel), headers);
        serviceAResponse = JsonConverter.convertJsonToObject(response, ServiceAResponse.class);
    }

    @Test(groups = {"regression"})
    public void getInfoWithInvalidUrlTest() {
        response = httpRestClient.callHttpGet("/client");
        ServiceAAsserts.assertFailedNotAllowed(response);
    }

    @Test(groups = {"regression"})
    public void getInfoByIdTest() {
        response = httpRestClient.callHttpGet("/client/" + serviceAResponse.getId());
        ServiceAAsserts.assertSuccess200(response);
    }


    @Test(groups = {"regression"})
    public void getInfoWithNonExistedIdTest() {
        response = httpRestClient.callHttpGet("/client/" + Long.MAX_VALUE);
        ServiceAAsserts.assertFailedNotFound(response);
    }

    @Test(groups = {"regression"})
    public void getInfoWithInvalidIdTest() {
        response = httpRestClient.callHttpGet("/client/" + -1);
        ServiceAAsserts.assertFailedNotFound(response);
    }

    @Test(groups = {"regression"})
    public void createValidInfoTest() {
        infoRequestModel = RandomModelGenerator.generateRandomInfo();
        response = httpRestClient.callHttpPost("/client",
                JsonConverter.convertObjectToJson(infoRequestModel), headers);
        serviceAResponse = JsonConverter.convertJsonToObject(response, ServiceAResponse.class);
        ServiceAAsserts.assureTestInfoSuccess(response, infoRequestModel);
    }

    @Test(groups = {"regression"})
    public void createInfoWithInvalidCityTest() {
        infoRequestModel = new InfoRequestModelBuilder().
                firstName(RandomModelGenerator.getRandomString()).
                lastName(RandomModelGenerator.getRandomString()).
                city(RandomModelGenerator.getRandomString()).
                country("Ukraine").
                build();
        response = httpRestClient.callHttpPost("/client",
                JsonConverter.convertObjectToJson(infoRequestModel), headers);
        ServiceAAsserts.assertFailedNotFound(response);
    }

    @Test(groups = {"regression"})
    public void createInfoWithoutCityTest() {
        infoRequestModel = new InfoRequestModelBuilder().
                firstName(RandomModelGenerator.getRandomString()).
                lastName(RandomModelGenerator.getRandomString()).
                country("Ukraine").
                build();
        response = httpRestClient.callHttpPost("/client",
                JsonConverter.convertObjectToJson(infoRequestModel), headers);
        ServiceAAsserts.assertFailedNotFound(response);
    }

    @Test(groups = {"regression"})
    public void createInfoWithEmptyCityTest() {
        infoRequestModel = new InfoRequestModelBuilder().
                firstName(RandomModelGenerator.getRandomString()).
                lastName(RandomModelGenerator.getRandomString()).
                city("").
                country("Ukraine").
                build();
        response = httpRestClient.callHttpPost("/client",
                JsonConverter.convertObjectToJson(infoRequestModel), headers);
        ServiceAAsserts.assertFailedNotFound(response);
    }


//    @Test
//    public void savePreconditionInDatabase(){
//        customClientService.create();
//    }

}
