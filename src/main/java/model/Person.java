package model;

import com.sun.jersey.server.linking.Link;
import com.sun.jersey.server.linking.Ref;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import resources.PersonResource;

import java.net.URI;

@Getter
@EqualsAndHashCode
@RequiredArgsConstructor
@Link(value = @Ref(resource = PersonResource.class, style = Ref.Style.ABSOLUTE, method = "getPerson"), rel = "self")
public class Person {

    @Ref(resource = PersonResource.class, style = Ref.Style.ABSOLUTE, method = "getPerson")
    private URI self;
    @Ref(resource = PersonResource.class, style = Ref.Style.ABSOLUTE, method = "get")
    private URI all;
    private final Long id;
    private final String firstName;
    private final String lastName;
    private final ContactInfo contactInfo;

    private Person() {
        id = null;
        firstName = null;
        lastName = null;
        contactInfo = null;
    }
}

@Getter
@EqualsAndHashCode
@RequiredArgsConstructor
class ContactInfo {

    private final String address;
    private final String email;

    public ContactInfo() {
        address = null;
        email = null;
    }
}