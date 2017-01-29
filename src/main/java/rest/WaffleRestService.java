package rest;

import domain.Orders;
import domain.Waffle;
import service.WaffleManager;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.IOException;

@Path("waffle")
public class WaffleRestService {
	
	@EJB
	WaffleManager wm;
	@Context
	HttpServletRequest request;
	@Context
	HttpServletResponse response;

	@GET
	@Path("/")
	@Produces(MediaType.APPLICATION_JSON)
  	public Response index(){

		request.setAttribute("waffle", wm.getAll());
		redirect("/waffle/index.jsp");
		return Response.status(Response.Status.OK).build();
	}

	@GET
	@Path("/details/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response details(@PathParam("id") long id){

		request.setAttribute("waffle", wm.getWaffle(id));
		redirect("/waffle/details.jsp");
		return Response.status(Response.Status.OK).build();

	}

	@PUT
	@Path("/details")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addToOrderSession(Waffle waffle)
	{

		HttpSession session = request.getSession(true);
		Orders order = (Orders)session.getAttribute("order");

		if(order == null) {
			order = new Orders();
		}


		wm.addWaffleToOrder(waffle, order);

		session.setAttribute("order", order);

		return Response.status(Response.Status.OK).build();

	}

	@GET
	@Path("/create")
	public Response Create()
	{
		request.setAttribute("waffle", new Waffle());
		redirect("/waffle/create.jsp");

		return Response.status(Response.Status.OK).build();
	}

	@POST
	@Path("/create")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response Create(Waffle waffle) {

		wm.addWaffle(waffle);
		return Response.status(Response.Status.CREATED).build();
	}

	@GET
	@Path("/edit/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response Edit(@PathParam("id") long id) {

		request.setAttribute("waffle", wm.getWaffle(id));
		redirect("/waffle/edit.jsp");
		return Response.status(Response.Status.OK).build();
	}

	@PUT
	@Path("/edit")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response Edit(Waffle waffle)	{

		wm.modifyWaffle(waffle);

		return Response.status(Response.Status.OK).build();
	}

	@GET
	@Path("/delete/{id}")
	public Response Delete(@PathParam("id") long id) {

		request.setAttribute("waffle", wm.getWaffle(id));
		redirect("/waffle/delete.jsp");

		return Response.status(Response.Status.OK).build();

	}

	@DELETE
	@Path("/delete/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response DeleteConfirmed(@PathParam("id") long id) {

		wm.deleteWaffle(wm.getWaffle(id));

		return Response.status(Response.Status.OK).build();
	}

	@GET
	@Path("/{id}/orders")
	public Response showOrders(@PathParam("id") long id)
	{
		request.setAttribute("order", wm.getOrdersOfWaffle(id));
		redirect("/waffle/showOrders.jsp");

		return Response.status(Response.Status.OK).build();

	}

	private void redirect(String url){

		try {
			request.getRequestDispatcher(url).forward(request, response);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
	}

}
