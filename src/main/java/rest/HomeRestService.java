package rest;

import java.io.IOException;

import javax.ejb.Stateless;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;

@SuppressWarnings("all")
@Path("/")
@Stateless
public class HomeRestService {
	
	@Context
    HttpServletRequest request;
    @Context
    HttpServletResponse response;

    @GET
    @Path("/")
    public Response index() {

        try {
            request.getRequestDispatcher("/home/index.jsp").forward(request, response);
            return Response.status(Response.Status.OK).build();
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
    }

}
