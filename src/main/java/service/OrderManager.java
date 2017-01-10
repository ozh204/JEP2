package service;

import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import domain.Orders;

@Path("order")
public class OrderManager {

    private Map<Long, Orders> storage = new HashMap<Long, Orders>();

    public OrderManager() {
        Orders order = new Orders();

        storage.put(1L, order);
    }

    @GET
    @Path("/{orderId}")
    @Produces("application/json")
    public Orders getOrder(@PathParam("orderId") Long id){
        Orders o = storage.get(id);
        if (o == null) return new Orders();
        return o;
    }

    @GET
    @Path("/test")
    @Produces("text/html")
    public String test(){
        return "REST Service is running";
    }

}