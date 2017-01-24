package rest;

import java.io.IOException;

import javax.ejb.Stateless;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;

@Path("")
@Stateless
public class HomeRestService {
	
	@Context
    HttpServletRequest request;
    @Context
    HttpServletResponse response;
    
    @GET
    @Path("/jsp")
    public void getPage() {
        try {
            request.getRequestDispatcher("/home.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
