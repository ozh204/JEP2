package service;

import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import domain.Waffle;

@Path("waffle")
public class WaffleManager {

    private Map<Long, Waffle> storage = new HashMap<Long, Waffle>();

    public WaffleManager() {
        Waffle waffle = new Waffle();

        storage.put(1L, waffle);

    }

    @GET
    @Path("/{waffleId}")
    @Produces("application/json")
    public Waffle getWaffle(@PathParam("waffleId") Long id){
        Waffle w = storage.get(id);
        if (w == null) return new Waffle();
        return w;
    }

    @GET
    @Path("/test")
    @Produces("text/html")
    public String test(){
        return "REST Service is running";
    }

}