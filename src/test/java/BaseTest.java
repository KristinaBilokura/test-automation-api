import com.jayway.restassured.response.Response;
import com.testing.context.CoreContext;
import com.testing.context.DatabaseContext;
import com.testing.jsonfactory.ServiceAResponse;
import com.testing.model.InfoRequestModel;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import com.testing.utils.HttpRestClient;
import com.testing.utils.Listener;

import java.util.Map;


@EnableAutoConfiguration
@ContextConfiguration(classes = {CoreContext.class, DatabaseContext.class})
@DataJpaTest
@EnableJpaRepositories(basePackages = { "com.testing.fakes.*"})
@EntityScan("com.testing.fakes.*")
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Listeners(Listener.class)

public class BaseTest extends AbstractTestNGSpringContextTests {
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