package contract;

import au.com.dius.pact.consumer.MockServer;
import au.com.dius.pact.consumer.dsl.PactDslWithProvider;
import au.com.dius.pact.consumer.junit5.PactConsumerTestExt;
import au.com.dius.pact.consumer.junit5.PactTestFor;
import au.com.dius.pact.core.model.RequestResponsePact;
import au.com.dius.pact.core.model.annotations.Pact;
import com.jayway.jsonpath.JsonPath;
import io.pactfoundation.consumer.dsl.LambdaDsl;
import org.apache.http.HttpResponse;
import org.apache.http.client.fluent.Request;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import java.io.IOException;
import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(PactConsumerTestExt.class)
@PactTestFor(providerName = "weatherProvider", port = "8080")
public class ContractServiceATest {


    @Pact(consumer = "test-framework")
    public RequestResponsePact validateWeatherFromProvider(PactDslWithProvider builder) {
        return builder.given("weather for city exists")
                .uponReceiving("A request to /client/1")
                .path("/client/1")
                .method("GET")
                .willRespondWith()
                .status(200)
                .body(LambdaDsl.newJsonBody((o) -> o
                        .numberType("id", 1)
                        .stringType("city", "Lviv")
                        .numberType("temperature", 29)
       ).build())
      .toPact();
    }

    @Test
    @PactTestFor(pactMethod = "validateWeatherFromProvider")
    public void testValidDateFromProvider(MockServer mockServer) throws IOException {
        HttpResponse httpResponse = Request.Get(mockServer.getUrl() + "/client/1")
                .execute().returnResponse();

        assertThat(httpResponse.getStatusLine().getStatusCode()).isEqualTo(200);
        assertThat((Integer) JsonPath.read(httpResponse.getEntity().getContent(), "$.temperature")).isEqualTo(29);
    }
}
