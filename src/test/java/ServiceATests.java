import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import com.testing.fakes.service.CustomClientService;
import com.testing.validation.ServiceAAsserts;

public class ServiceATests extends BaseTest {

    @Autowired
    private CustomClientService customClientService;

    @Test(groups = {"integration"})
    public void getInfoWithInvalidUrl() {
        response = httpRestClient.callHttpGet("/client");
        ServiceAAsserts.assertFailedNotAllowed(response);
    }


    @Test
    public void savePreconditionInDatabase(){

        customClientService.create();
    }

}
