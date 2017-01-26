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
import java.util.List;

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
  	public void index(){

		request.setAttribute("waffle", wm.getAll());
		redirect("/waffle/index.jsp");
	}

	@GET
	@Path("/details/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public void details(@PathParam("id") long id){

		request.setAttribute("waffle", wm.getWaffle(id));
		redirect("/waffle/details.jsp");

	}

	@PUT
	@Path("/details")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addToOrderSession(Waffle waffle)
	{

		HttpSession session = request.getSession(true);
		Orders order = (Orders)session.getAttribute("order");
		order.getWaffles().add(waffle);
		session.setAttribute("order", order);

		return Response.status(Response.Status.OK).build();

	}

	@GET
	@Path("/create")
//	@Produces({"application/x-www-form-urlencoded"})
	@Produces(MediaType.APPLICATION_JSON)
	public void Create()
	{
		request.setAttribute("waffle", new Waffle());
		redirect("/waffle/create.jsp");
	}

	@POST
	@Path("/create")
	@Consumes("application/x-www-form-urlencoded")
	public void Create(
			@FormParam("price") long price,
			@FormParam("sugar") String sugar,
			@FormParam("topping") String topping,
			@FormParam("fruit") String fruit,
			@FormParam("cream") String cream)
	{
		Waffle waffle = new Waffle();

		waffle.setPrice(price);
		waffle.setSugar(sugar);
		waffle.setTopping(topping);
		waffle.setFruit(fruit);
		waffle.setCream(cream);

		wm.addWaffle(waffle);
		redirect("/waffle/create.jsp");
	}
	//	@POST
//	@Path("/create")
//	@Consumes(MediaType.APPLICATION_JSON)
//	public Response Create(Waffle waffle) {
//
//		wm.addWaffle(waffle);
//
//		return Response.status(Response.Status.CREATED).build();
//	}

	@GET
	@Path("/edit/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public void Edit(@PathParam("id") long id) {

		request.setAttribute("waffle", wm.getWaffle(id));
		redirect("/waffle/edit.jsp");
	}

	@PUT
	@Path("/edit")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response Edit(Waffle waffle)	{

		wm.modifyWaffle(waffle);

		return Response.status(Response.Status.OK).build();
//		request.setAttribute("waffle", wm.getAll());
//		redirect("/waffle/index.jsp");

	}

	@GET
	@Path("/delete/{id}")
	public void Delete(@PathParam("id") long id)
	{
		request.setAttribute("waffle", wm.getWaffle(id));
		redirect("/waffle/delete.jsp");
	}

	@DELETE
	@Path("/delete/{id}")
	public void DeleteConfirmed(@PathParam("id") long id)
	{
		Waffle waffle = wm.getWaffle(id);
		wm.deleteWaffle(waffle);

		request.setAttribute("waffle", wm.getWaffle(id));
		redirect("/waffle/index.jsp");
	}
	//	@DELETE
//	@Path("/delete/{id}")
//	public Response Delete(@PathParam("id") long id)
//	{
//		Waffle waffle = wm.getWaffle(id);
//		wm.deleteWaffle(waffle);
//
//		return Response.status(Response.Status.OK).build();
//	}

	@GET
	@Path("/{id}/orders")
	public void showOrders(@PathParam("id") long id)
	{
		request.setAttribute("order", wm.getOrdersOfWaffle(id));
		redirect("/waffle/showOrders.jsp");
	}
	//	@GET
//	@Path("/{id}/orders")
//	public List<Orders> showOrders(@PathParam("id") long id)
//	{
//		List<Orders> orders = wm.getOrdersOfWaffle(id);
//
//		return orders;
//	}

	private void redirect(String url){

		try {
			request.getRequestDispatcher(url).forward(request, response);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
	}

}
