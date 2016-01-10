package services;

import javax.ejb.Stateless;
import javax.ws.rs.Path;
import entities.ManagerRH;

@Stateless
@Path("/ManagerRH")
public class ManagerRHREST extends AbstractREST<ManagerRH>{
	public ManagerRHREST() {
		super(ManagerRH.class);
	}

}
