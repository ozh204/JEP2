package rest;

import domain.Orders;
import domain.Waffle;
import service.WaffleManager;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
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

	@GET
	@Path("/edit/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public void Edit(@PathParam("id") long id) {

		request.setAttribute("waffle", wm.getWaffle(id));
		redirect("/waffle/edit.jsp");
	}

	@PUT
	@Path("/edit")
//	@Consumes("application/x-www-form-urlencoded")
//	@Consumes(MediaType.APPLICATION_XML)
	@Consumes(MediaType.APPLICATION_JSON)
	public void Edit(
			@QueryParam("id") long id,
			@QueryParam("price") long price,
			@QueryParam("sugar") String sugar,
			@QueryParam("topping") String topping,
			@QueryParam("fruit") String fruit,
			@QueryParam("cream") String cream)
	{

		Waffle waffle = new Waffle();

		waffle.setId(id);
		waffle.setPrice(price);
		waffle.setSugar(sugar);
		waffle.setTopping(topping);
		waffle.setFruit(fruit);
		waffle.setCream(cream);

		wm.modifyWaffle(waffle);
		request.setAttribute("waffle", wm.getAll());
		redirect("/waffle/index.jsp");
	}

	@GET
	@Path("/delete/{id}")
	public void Delete(@PathParam("id") long id)
	{
		request.setAttribute("waffle", wm.getWaffle(id));
		redirect("/waffle/delete.jsp");
	}

	@DELETE
	@Path("/deletee/{id}")
	public void DeleteConfirmed(@PathParam("id") long id)
	{
		Waffle waffle = wm.getWaffle(id);
		wm.deleteWaffle(waffle);

		request.setAttribute("waffle", wm.getWaffle(id));
		redirect("/waffle/index.jsp");
	}

	@GET
	@Path("/{id}/orders")
	public void showOrders(@PathParam("id") long id)
	{
		request.setAttribute("order", wm.getOrdersOfWaffle(id));
		redirect("/waffle/showOrders.jsp");
	}

	private void redirect(String url){

		try {
			request.getRequestDispatcher(url).forward(request, response);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
	}

}
