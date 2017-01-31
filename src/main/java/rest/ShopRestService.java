package rest;

import domain.Shop;
import service.OrderManager;
import service.ShopManager;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.IOException;

@Path("shop")
public class ShopRestService {
	
	@EJB
	ShopManager sm;
	@EJB
	OrderManager om;
	@Context
	HttpServletRequest request;
	@Context
	HttpServletResponse response;

	@GET
	@Path("/")
	@Produces(MediaType.APPLICATION_JSON)
  	public Response index(){

		request.setAttribute("shop", sm.getAll());
		redirect("/shop/index.jsp");
		return Response.status(Response.Status.OK).build();
	}

	@GET
	@Path("/details/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response details(@PathParam("id") long id){

		request.setAttribute("shop", sm.getShop(id));
		redirect("/shop/details.jsp");
		return Response.status(Response.Status.OK).build();

	}

	@GET
	@Path("/create")
	public Response Create()
	{
		request.setAttribute("shop", new Shop());
		redirect("/shop/create.jsp");

		return Response.status(Response.Status.OK).build();
	}

	@POST
	@Path("/create")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response Create(Shop shop) {

		sm.addShop(shop);
		return Response.status(Response.Status.CREATED).build();
	}

	@GET
	@Path("/edit/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response Edit(@PathParam("id") long id) {

		request.setAttribute("shop", sm.getShop(id));
		redirect("/shop/edit.jsp");
		return Response.status(Response.Status.OK).build();
	}

	@PUT
	@Path("/edit")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response Edit(Shop shop)	{

		sm.modifyShop(shop);

		return Response.status(Response.Status.OK).build();
	}

	@GET
	@Path("/delete/{id}")
	public Response Delete(@PathParam("id") long id) {

		request.setAttribute("shop", sm.getShop(id));
		redirect("/shop/delete.jsp");

		return Response.status(Response.Status.OK).build();

	}

	@DELETE
	@Path("/delete/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response DeleteConfirmed(@PathParam("id") long id) {

		sm.deleteShop(id);

		return Response.status(Response.Status.OK).build();
	}

	@GET
	@Path("/{id}/order")
	public Response addOrder(@PathParam("id") long id){

		request.setAttribute("shopId", id);
		request.setAttribute("order", om.getAll());
		redirect("/shop/addOrder.jsp");

		return Response.status(Response.Status.OK).build();

	}

	@GET
	@Path("/{id}/orders")
	public Response showOrders(@PathParam("id") long id)
	{
		request.setAttribute("order", sm.getOrders(id));
		redirect("/shop/showOrders.jsp");

		return Response.status(Response.Status.OK).build();

	}

	@GET
	@Path("/{id}/order/{orderId}/delete")
	public Response DeleteOrder(@PathParam("id") long id, @PathParam("orderId") long orderId) {

		request.setAttribute("order", om.getOrder(orderId));
		request.setAttribute("shop", sm.getShop(id));
		redirect("/shop/deleteOrder.jsp");

		return Response.status(Response.Status.OK).build();

	}

	@DELETE
	@Path("/{id}/order/{orderId}/delete")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response DeleteOrderConfirmed(@PathParam("id") long id, @PathParam("orderId") long orderId) {

		sm.deleteOrderFromShop(orderId, id);

		return Response.status(Response.Status.OK).build();

	}

	@GET
	@Path("/{shopId}/order/{orderId}")
	public Response addOrder(@PathParam("shopId") long shopId, @PathParam("orderId") long orderId){

		request.setAttribute("shop", sm.getShop(shopId));
		request.setAttribute("order", om.getOrder(orderId));
		redirect("/shop/addOrderConfirm.jsp");

		return Response.status(Response.Status.OK).build();

	}

	@PUT
	@Path("/{shopId}/order/{orderId}")
	public Response addWaffleConfirm(@PathParam("shopId") long shopId, @PathParam("orderId") long orderId){

		sm.addOrderToShop(shopId, orderId);

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
