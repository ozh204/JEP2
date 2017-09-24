package rest;

import domain.Waffle;
import service.WaffleManager;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Random;

@SuppressWarnings("all")
@Path("/")
@Stateless
public class HomeRestService {

    @EJB
    WaffleManager wm;

    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public Response index() {

        Random randomWaffle = new Random();
        int howManyWaffles = wm.getAll().size();
        int pickedNumber = randomWaffle.nextInt(howManyWaffles) + 1;
        Waffle waffle = wm.getWaffle(Long.valueOf(pickedNumber));

        return Response.ok(waffle).build();

    }

}
