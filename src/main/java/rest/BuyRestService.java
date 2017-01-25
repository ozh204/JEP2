package rest;

import domain.Orders;
import service.OrderManager;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import java.io.IOException;

@SuppressWarnings("all")
@Path("buy")
@Stateless
public class BuyRestService {

    @EJB
    OrderManager om;
	@Context
    HttpServletRequest request;
    @Context
    HttpServletResponse response;

    @GET
    @Path("/")
    public void index() {

        HttpSession session = request.getSession(true);

        request.setAttribute("order", session);
        redirect("/buy/buy.jsp");

    }

    @GET
    @Path("/confirm")
    public void confirm() {

        HttpSession session = request.getSession(true);
        Orders order = (Orders)session.getAttribute("order");
        om.addOrder(order);

        session.setAttribute("order", null);

        request.setAttribute("order", session);
        redirect("/buy/buy.jsp");

    }

    private void redirect(String url){

        try {
            request.getRequestDispatcher(url).forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }
}
