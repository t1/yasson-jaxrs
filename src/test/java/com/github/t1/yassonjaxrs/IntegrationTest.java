package com.github.t1.yassonjaxrs;

import com.github.t1.testtools.WebArchiveBuilder;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.test.api.ArquillianResource;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.ws.rs.client.*;
import javax.ws.rs.core.Response;
import java.net.URI;

import static javax.ws.rs.core.MediaType.*;
import static javax.ws.rs.core.Response.Status.*;
import static org.assertj.core.api.Assertions.*;

@RunWith(Arquillian.class)
public class IntegrationTest {
    private static final Client CLIENT = ClientBuilder.newClient();

    @Deployment(testable = false)
    public static WebArchive createDeployment() {
        return new WebArchiveBuilder("yasson-test.war")
                .with(JaxRs.class, TestDto.class, TestBoundary.class)
                .with(JsonbProducer.class, JsonMessageBodyReader.class, JsonMessageBodyWriter.class)
                .library("javax.json.bind", "javax.json.bind-api")
                .library("org.eclipse", "yasson")
                .withBeansXml()
                .print()
                .build();
    }

    @ArquillianResource private URI baseUri;

    private WebTarget target() { return CLIENT.target(baseUri); }

    @Test
    public void shouldSerializeWithJsonbAnnotations() throws Exception {
        Response response = target().request(APPLICATION_JSON_TYPE).get();

        assertThat(response.getStatusInfo()).isEqualTo(OK);
        assertThat(response.readEntity(String.class)).isEqualTo("{\"eins\":\"uno\",\"zwei\":2}");
    }

    @Test
    public void shouldDeserializeWithJsonbAnnotations() throws Exception {
        Response response = target().request(APPLICATION_JSON_TYPE)
                                    .post(Entity.entity("{\"eins\":\"uno\",\"zwei\":2}", APPLICATION_JSON_TYPE));

        assertThat(response.getStatusInfo()).isEqualTo(OK);
        assertThat(response.readEntity(String.class)).isEqualTo("{\"eins\":\"uno+\",\"zwei\":3}");
    }
}
