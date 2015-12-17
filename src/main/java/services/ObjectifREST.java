package services;

import javax.ejb.Stateless;
import javax.ws.rs.Path;

import entities.Objectif;

@Stateless
@Path("/Objectif")
public class ObjectifREST extends AbstractREST<Objectif> {

	public ObjectifREST() {
		super(Objectif.class);
	}

}
