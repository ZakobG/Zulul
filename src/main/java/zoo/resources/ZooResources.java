package zoo.resources;

import zoo.entities.ZooEntities;
import zoo.managers.ZooManagers;
import zoo.entities.User;

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
    @Path("Healthy")
    public Response getAnimalsHealthy() {

        return Response.ok(managers.getHealthy()).build();
    }

    @GET
    @Path("Sick")
    public Response getAnimalsSick() {

        return Response.ok(managers.getSick()).build();
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
        return Response.ok("smazáno OMEGALUL").build();
    }

    @POST
    @Path("user")
    public Response addUser(User user){
        return Response.ok(managers.createUser(user)).build();
    }

    @GET
    @Path("user")
    public Response loginUser(User user){
        return Response.ok(managers.login(user.name,user.password)).build();
    }
    @PUT
    @Path("user")
    public Response logoutUser(){
        return Response.ok(managers.logout()).build();
    }

}
