package service;

import com.sun.jersey.api.core.ResourceConfig;
import com.sun.jersey.server.linking.LinkFilter;
import io.dropwizard.Application;
import io.dropwizard.Configuration;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import model.ContactInfo;
import model.Person;
import org.eclipse.jetty.servlets.CrossOriginFilter;
import resources.PersonResource;

import javax.servlet.DispatcherType;
import javax.servlet.FilterRegistration;
import java.util.EnumSet;

public class PersonApplication extends Application<Configuration> {

    public static void main(String[] args) throws Exception {
        new PersonApplication().run(new String[]{"server"});
    }

    @Override
    public void initialize(Bootstrap<Configuration> bootstrap) {

    }

    @Override
    public void run(Configuration configuration, Environment environment) throws Exception {
        PersonResource personResource = new PersonResource();
        environment.jersey().register(personResource);
        environment.jersey().property(ResourceConfig.PROPERTY_CONTAINER_RESPONSE_FILTERS, LinkFilter.class);
        addCorsHeaders(environment);
        populateWithTestData(personResource);
    }

    private void populateWithTestData(PersonResource personResource) {
        personResource.add(new Person(null, "Bill", "Clinton", new ContactInfo("123 Broadway St", "bill@clinton.gov")));
        personResource.add(new Person(null, "George", "Bush", new ContactInfo("2140 6th Ave", "george@bush.gov")));
    }

    private void addCorsHeaders(Environment environment) {
        FilterRegistration.Dynamic filter = environment.servlets().addFilter("CORS", CrossOriginFilter.class);
        filter.addMappingForUrlPatterns(EnumSet.allOf(DispatcherType.class), true, "/*");
        filter.setInitParameter("allowedOrigins", "*");    // allowed origins comma separated
        filter.setInitParameter("allowedHeaders", "Content-Type,Authorization,X-Requested-With,Content-Length,Accept,Origin");
        filter.setInitParameter("allowedMethods", "GET,PUT,POST,DELETE,OPTIONS,HEAD");
        filter.setInitParameter("allowCredentials", "true");
    }
}