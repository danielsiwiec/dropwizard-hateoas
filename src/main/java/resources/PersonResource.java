package resources;

import model.Person;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.HashMap;
import java.util.Map;

@Path("/person/{id}")
@Produces(MediaType.APPLICATION_JSON)
public class PersonResource {

    Map<Long,Person> people = new HashMap<Long, Person>();

    @GET
    public Person getPerson(@PathParam("id") Long id) {
        return people.get(id);
    }

    @PUT
    public void createPerson(@PathParam("id") Long id, Person person) {
        people.put(id,person);
    }
}