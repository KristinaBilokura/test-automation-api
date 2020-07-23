import org.testng.annotations.Test;
import validation.ServiceAAsserts;

public class ServiceATests extends BaseTest {

    @Test(groups = {"integration"})
    public void getInfoWithInvalidUrl() {
        response = httpRestClient.callHttpGet("/client");
        ServiceAAsserts.assertFailedNotAllowed(response);
    }
}
