package services;

import javax.ejb.Stateless;
import javax.ws.rs.Path;
import entities.ManagerRH;

/*
 *  ManagerRH Restful Resource
 */
@Stateless
@Path("/ManagerRH")
public class ManagerRHREST extends AbstractREST<ManagerRH>{
	public ManagerRHREST() {
		super(ManagerRH.class);
	}

}
