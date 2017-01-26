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



    private void redirect(String url){

        try {
            request.getRequestDispatcher(url).forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }
}
