package resources;

import model.Person;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.HashMap;
import java.util.Map;

@Path("/person")
@Produces(MediaType.APPLICATION_JSON)
public class PersonResource {

    Map<Long,Person> people = new HashMap<Long, Person>();

    @GET
    @Path("/{id}")
    public Person getPatient(@PathParam("id") Long id) {
        return people.get(id);
    }

    @PUT
    @Path("/{id}")
    public void createPerson(@PathParam("id") Long id, Person person) {
        people.put(id,person);
    }
}