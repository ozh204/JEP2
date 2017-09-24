package rest;

import domain.Orders;
import domain.Waffle;
import service.WaffleManager;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("waffle")
@Stateless
public class WaffleRestService {
	
	@EJB
	WaffleManager wm;
	@Context
	HttpServletRequest request;


//	List all waffles
	@GET
	@Path("/")
	@Produces(MediaType.APPLICATION_JSON)
  	public Response index(){

		return Response.ok(wm.getAll()).build();

	}

//	edit waffle
	@PUT
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response Edit(Waffle waffle)	{

		wm.modifyWaffle(waffle);

		return Response.ok().build();

	}

//	delete waffle
	@DELETE
	@Path("/{id}")
	public Response Delete(@PathParam("id") long id) {

		wm.deleteWaffle(id);

		return Response.ok().build();

	}

//  waffle details
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response details(@PathParam("id") Long id){

		return Response.ok(wm.getWaffle(id)).build();

	}

//	add to cart
	@PUT
	@Path("/addToCart")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addToOrderSession(Waffle waffle) {

		HttpSession session = request.getSession(true);
		Orders order = (Orders)session.getAttribute("order");

		if(order == null) {
			order = new Orders();
		}

		Waffle newWaffle = wm.getWaffle(waffle.getId());
		wm.addWaffleToOrder(newWaffle, order);

		session.setAttribute("order", order);

		return Response.status(Response.Status.OK).build();

	}

//	create waffle
	@POST
	@Path("/create")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response Create(Waffle waffle) {

		wm.addWaffle(waffle);
		return Response.ok().build();

	}

//	show orders of waffle
	@GET
	@Path("/ordersOfWafflee/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response showOrders(@PathParam("id") long id) {

		return Response.ok(wm.getOrdersOfWaffle(id)).build();

	}

}
