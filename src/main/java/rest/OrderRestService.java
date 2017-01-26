package rest;

import domain.Orders;
import domain.Waffle;
import service.OrderManager;

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
import java.util.List;

@Path("order")
@Stateless
public class OrderRestService {

	@EJB
	OrderManager om;
	@Context
	HttpServletRequest request;
	@Context
	HttpServletResponse response;

	@GET
	@Path("/")
	@Produces(MediaType.APPLICATION_JSON)
	public void index(){

		request.setAttribute("order", om.getAll());
		redirect("/order/index.jsp");

	}

	@GET
	@Path("/details/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public void details(@PathParam("id") long id){

		request.setAttribute("order", om.getOrder(id));
		redirect("/order/details.jsp");

	}

	@GET
	@Path("/create")
	@Produces(MediaType.APPLICATION_JSON)
	public void Create()
	{
		request.setAttribute("order", new Orders());
		redirect("/order/create.jsp");
	}

	@POST
	@Path("/create")
	@Consumes("application/x-www-form-urlencoded")
	public void CreateOrder() {

		Orders order = new Orders();
		HttpSession session = request.getSession(true);
		session.setAttribute("order", order);

		request.setAttribute("order", om.getAll());
		redirect("/order/index.jsp");
	}

	@GET
	@Path("/edit/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public void Edit(@PathParam("id") long id) {

		request.setAttribute("order", om.getOrder(id));
		redirect("/order/edit.jsp");
	}

	@PUT
	@Path("/edit")
	@Consumes(MediaType.APPLICATION_JSON)
	public void EditOrder()
	{
		Orders order = new Orders();

		om.modifyOrder(order);
		request.setAttribute("order", om.getAll());
		redirect("/order/index.jsp");
	}

	@GET
	@Path("/delete/{id}")
	public void Delete(@PathParam("id") long id)
	{
		request.setAttribute("order", om.getOrder(id));
		redirect("/order/delete.jsp");
	}

	@DELETE
	@Path("/deletee/{id}")
	public void DeleteConfirmed(@PathParam("id") long id)
	{
		Orders order = om.getOrder(id);
		om.deleteOrder(order);

		request.setAttribute("order", om.getOrder(id));
		redirect("/order/index.jsp");
	}

	@GET
	@Path("/{id}/waffles")
	public void showWaffles(@PathParam("id") long id)
	{
		request.setAttribute("waffle", om.getWafflesOfOrder(id));
		redirect("/order/showWaffles.jsp");
	}

	private void redirect(String url){

		try {
			request.getRequestDispatcher(url).forward(request, response);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
	}

	@GET
	@Path("/cart")
	public void cart() {

		HttpSession session = request.getSession(true);

		request.setAttribute("order", session.getAttribute("order"));
		redirect("/order/cart.jsp");

	}

	@GET
	@Path("/confirm")
	public void confirm() {

		HttpSession session = request.getSession(true);
		Orders order = (Orders)session.getAttribute("order");
		om.addOrder(order);

		session.setAttribute("order", null);

		request.setAttribute("order", om.getAll());
		redirect("/order/index.jsp");

	}

//	@GET
//	@Path("/")
//	@Produces(MediaType.APPLICATION_JSON)
//	public List<Orders> index(){
//
//		return om.getAll();
//	}
//
//	@GET
//	@Path("/details/{id}")
//	@Produces(MediaType.APPLICATION_JSON)
//	public Orders details(@PathParam("id") long id){
//
//		return om.getOrder(id);
//
//	}
//
//	@POST
//	@Path("/create")
//	@Consumes(MediaType.APPLICATION_JSON)
//	public Response Create(Orders order) {
//
//		om.addOrder(order);
//
//		return Response.status(Response.Status.CREATED).build();
//	}
//
//	@PUT
//	@Path("/edit")
//	@Consumes(MediaType.APPLICATION_JSON)
//	public Response Edit(Orders order)	{
//
//		om.modifyOrder(order);
//
//		return Response.status(Response.Status.OK).build();
//
//	}
//
//	@DELETE
//	@Path("/delete/{id}")
//	public Response Delete(@PathParam("id") long id)
//	{
//		Orders order = om.getOrder(id);
//		om.deleteOrder(order);
//
//		return Response.status(Response.Status.OK).build();
//	}
//
//	@GET
//	@Path("/{id}/waffles")
//	public List<Waffle> showWaffles(@PathParam("id") long id)
//	{
//		List<Waffle> waffles = om.getWafflesOfOrder(id);
//
//		return waffles;
//	}

}
