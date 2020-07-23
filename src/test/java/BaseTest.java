import com.jayway.restassured.response.Response;
import jsonfactory.ServiceAResponse;
import model.InfoRequestModel;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import utils.HttpRestClient;
import utils.Listener;

import java.util.HashMap;
import java.util.Map;

@Listeners(Listener.class)
public class BaseTest {
    protected HttpRestClient httpRestClient;
    protected Map<String, String> cookies;
    protected Map<String, String> headers;
    protected Response response;
    protected InfoRequestModel infoRequestModel;
    protected ServiceAResponse serviceAResponse;


    @BeforeMethod(alwaysRun = true)
    public void init() {
        httpRestClient = new HttpRestClient("http://", "127.0.0.1", 8080);
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        httpRestClient.resetProp();
    }
}