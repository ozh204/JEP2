package rest;

import domain.Orders;
import domain.Waffle;
import service.OrderManager;
import service.WaffleManager;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.IOException;

@Path("order")
@Stateless
public class OrderRestService {

	@EJB
	OrderManager om;
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

		request.setAttribute("order", om.getAll());
		redirect("/order/index.jsp");

		return Response.status(Response.Status.OK).build();

	}

	@GET
	@Path("/details/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response details(@PathParam("id") long id){

		request.setAttribute("order", om.getOrder(id));
		redirect("/order/details.jsp");

		return Response.status(Response.Status.OK).build();

	}

	@GET
	@Path("/create")
	@Produces(MediaType.APPLICATION_JSON)
	public Response Create() {

		redirect("/order/create.jsp");

		return Response.status(Response.Status.OK).build();

	}

	@POST
	@Path("/create")
	@Consumes("application/x-www-form-urlencoded")
	public Response CreateOrder() {

		HttpSession session = request.getSession(true);
		Orders order = (Orders)session.getAttribute("order");

		if(order != null) {

			redirect("/order/cart.jsp");

			return Response.status(Response.Status.FOUND).build();

		}

		order = new Orders();
		session.setAttribute("order", order);

		request.setAttribute("order", om.getAll());
		redirect("/order/index.jsp");

		return Response.status(Response.Status.CREATED).build();
	}

	@GET
	@Path("/edit/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response Edit(@PathParam("id") long id) {

		request.setAttribute("order", om.getOrder(id));
		redirect("/order/edit.jsp");

		return Response.status(Response.Status.OK).build();

	}

	@PUT
	@Path("/edit")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response Edit(Orders order) {

		om.modifyOrder(order);

		return Response.status(Response.Status.OK).build();

	}

	@GET
	@Path("/{id}/waffle")
	public Response addWaffle(@PathParam("id") long id){

		request.setAttribute("orderId", id);
		request.setAttribute("waffle", wm.getAll());
		redirect("/order/addWaffle.jsp");

		return Response.status(Response.Status.OK).build();

	}

	@GET
	@Path("/{orderId}/waffle/{waffleId}")
	public Response addWaffle(@PathParam("orderId") long orderId, @PathParam("waffleId") long waffleId){

		request.setAttribute("order", om.getOrder(orderId));
		request.setAttribute("waffle", wm.getWaffle(waffleId));
		redirect("/order/addWaffleConfirm.jsp");

		return Response.status(Response.Status.OK).build();

	}

	@PUT
	@Path("/{orderId}/waffle/{waffleId}")
	public Response addWaffleConfirm(@PathParam("orderId") long orderId, @PathParam("waffleId") long waffleId){

		om.addWaffleToOrder(orderId, waffleId);

		return Response.status(Response.Status.OK).build();

	}

	@GET
	@Path("/delete/{id}")
	public Response Delete(@PathParam("id") long id) {

		request.setAttribute("order", om.getOrder(id));
		redirect("/order/delete.jsp");

		return Response.status(Response.Status.OK).build();

	}

	@DELETE
	@Path("/delete/{id}")
	public Response DeleteConfirmed(@PathParam("id") long id) {

		om.deleteOrder(om.getOrder(id));

		return Response.status(Response.Status.OK).build();

	}

	@GET
	@Path("/{id}/waffle/{waffleId}/delete")
	public Response DeleteWaffle(@PathParam("id") long id, @PathParam("waffleId") long waffleId) {

		request.setAttribute("waffle", wm.getWaffle(waffleId));
		request.setAttribute("order", om.getOrder(id));
		redirect("/order/deleteWaffle.jsp");

		return Response.status(Response.Status.OK).build();

	}

	@DELETE
	@Path("/{id}/waffle/{waffleId}/delete")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response DeleteWaffleConfirmed(@PathParam("id") long id, @PathParam("waffleId") long waffleId) {

		om.deleteWaffleFromOrder(waffleId, id);

		return Response.status(Response.Status.OK).build();

	}

	@GET
	@Path("/{id}/waffles")
	public Response showWaffles(@PathParam("id") long id) {

		request.setAttribute("waffle", om.getWafflesOfOrder(id));
		redirect("/order/showWaffles.jsp");

		return Response.status(Response.Status.OK).build();

	}

	@GET
	@Path("/cart")
	public Response cart() {

		HttpSession session = request.getSession(true);

		request.setAttribute("order", session.getAttribute("order"));
		redirect("/order/cart.jsp");

		return Response.status(Response.Status.OK).build();

	}

	@GET
	@Path("/confirm")
	public Response confirm() {

		HttpSession session = request.getSession(true);
		Orders order = (Orders)session.getAttribute("order");
		if(order == null) {

			redirect("/order/cart.jsp");
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();

		}

		om.addOrder(order);

		session.setAttribute("order", null);

		request.setAttribute("order", om.getAll());
		redirect("/order/index.jsp");

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