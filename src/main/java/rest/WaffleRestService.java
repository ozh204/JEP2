package rest;

import domain.Waffle;
import service.WaffleManager;

import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("waffle")
public class WaffleRestService {
	
	@EJB
	WaffleManager wm;

	@GET
	@Path("/")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Waffle> getWaffles(){
		return  wm.getAll();
	}

	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Waffle getWaffle(@PathParam("id") Long id){
		return wm.getWaffle(id);
	}

}
