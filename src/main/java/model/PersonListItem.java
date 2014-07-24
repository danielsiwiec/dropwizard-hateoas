package model;


import com.sun.jersey.server.linking.Ref;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import resources.PersonResource;

import java.net.URI;

@Getter
@EqualsAndHashCode
@RequiredArgsConstructor
public class PersonListItem {

    private final Long id;
    private final String firstName;
    @Ref(resource = PersonResource.class, style = Ref.Style.ABSOLUTE, method = "getPerson")
    private URI self;

}
