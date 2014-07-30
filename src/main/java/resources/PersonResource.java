package resources;

import com.google.common.base.Function;
import com.google.common.collect.Lists;
import model.Person;
import model.PersonListItem;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.google.common.collect.Iterables.transform;


@Path("/person")
@Produces(MediaType.APPLICATION_JSON)
public class PersonResource {

    Map<Long,Person> people = new HashMap<>();
    Long currentId = 0l;

    @GET
    @Path("{id}")
    public Person getPerson(@PathParam("id") Long id) {
        return people.get(id);
    }

    @GET
    public List<PersonListItem> get() {
        return Lists.newArrayList(transform(people.values(), new Function<Person, PersonListItem>() {
            public PersonListItem apply(Person input) {
                return new PersonListItem(input.getId(), input.getFirstName());
            }
        }));
    }

    @POST
    public void add(Person person) {
        people.put(currentId,new Person(currentId, person.getFirstName(), person.getLastName(), person.getContactInfo()));
        currentId++;
    }
}