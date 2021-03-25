package zoo.resources;

import zoo.entities.ZooEntities;
import zoo.managers.ZooManagers;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("AnimalList")
@Produces(MediaType.APPLICATION_JSON)
public class ZooResources {


    @Inject
    private ZooManagers managers;

    @GET
    public Response getAnimals() {

        return Response.ok(managers.getAll()).build();
    }

    @GET
    public Response getDetail(@QueryParam("id") int id) {
        return Response.ok(managers.get(id)).build();
    }

    @POST
    public Response addAnimal(ZooEntities animal) {
        return Response.ok(managers.create(animal)).build();
    }

    @DELETE
    public Response delAnimal(@QueryParam("id") int id) {
        managers.delete(id);
        return Response.ok("xddd smazáno").build();
    }

}
