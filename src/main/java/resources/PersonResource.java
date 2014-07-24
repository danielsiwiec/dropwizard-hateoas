package resources;

import model.Person;
import model.PersonListItem;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.*;

@Path("/person")
@Produces(MediaType.APPLICATION_JSON)
public class PersonResource {

    Map<Long,Person> people = new HashMap<Long, Person>();

    @GET
    @Path("{id}")
    public Person getPerson(@PathParam("id") Long id) {
        return people.get(id);
    }

    @GET
    public List<PersonListItem> get() {
        List<PersonListItem> items = new ArrayList<>();
        for (Person person : people.values()){
            items.add(new PersonListItem(person.getId(),person.getFirstName()));
        }
        return items;
    }

    @PUT
    @Path("{id}")
    public void createPerson(@PathParam("id") Long id, Person person) {
        people.put(id,new Person(id, person.getFirstName(), person.getLastName()));
    }
}