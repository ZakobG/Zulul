package zoo.resources;

import zoo.managers.ZooManagers;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public class ZooResources {

    @Path("AnimalList")
    @Produces(MediaType.APPLICATION_JSON)
    public class AnimalList{
        @Inject
        private ZooManagers managers;

        @GET
        public Response getAnimals() {
            return Response.ok(managers.getAll()).build();
        }

        @GET
        @Path("{id}")
        public Response getDetail(@PathParam("id") int id) {
            return Response.ok().build();
        }

        @POST
        public Response addAnimal() {
            return Response.ok().build();
        }

        @DELETE
        @Path("{id}")
        public Response delAnimal(@PathParam("id") int id) {
            return Response.ok().build();
        }

    }
}
