package rest;

import java.io.IOException;

import javax.ejb.Stateless;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;

@SuppressWarnings("all")
@Path("")
@Stateless
public class HomeRestService {
	
	@Context
    HttpServletRequest request;
    @Context
    HttpServletResponse response;

    @GET
    @Path("/")
    public void index() {

        try {
            request.getRequestDispatcher("/home/index.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
