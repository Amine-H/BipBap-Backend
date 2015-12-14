package services;

import javax.ejb.Stateless;
import javax.ws.rs.Path;
import entities.BAP;

@Stateless
@Path("/BAP")
public class BAPREST extends AbstractREST<BAP>{

	public BAPREST() {
		super(BAP.class);
	}
}
