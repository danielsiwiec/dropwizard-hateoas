package model;

import com.sun.jersey.server.linking.Link;
import com.sun.jersey.server.linking.Ref;
import lombok.Value;
import resources.PersonResource;

import java.net.URI;
import java.net.URISyntaxException;

@Value
@Link(value = @Ref(resource = PersonResource.class, style = Ref.Style.ABSOLUTE, value = "{id}"), rel="self")
public class Person {

    @Ref(resource = PersonResource.class, style = Ref.Style.ABSOLUTE, value = "{id}")
    private final URI self;
    private final Long id;
    private final String firstName;
    private final String lastName;

    public Person() throws URISyntaxException {
        id=0l;
        firstName="";
        lastName="";
        self = null;
    }
}
