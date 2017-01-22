package rest;

import domain.Orders;
import service.OrderManager;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("order")
@Stateless
public class OrderRestService {

	@EJB
	OrderManager om;

	@GET
	@Path("/")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Orders> getOrders(){
		return om.getAll();
	}

	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Orders getOrder(@PathParam("id") Long id){
		return om.getOrder(id);
	}

}
