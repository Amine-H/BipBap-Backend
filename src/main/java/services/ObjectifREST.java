package services;

import javax.ejb.Stateless;
import javax.ws.rs.Path;

import entities.Objectif;

/*
 *  Objectif Restful Resource
 */
@Stateless
@Path("/Objectif")
public class ObjectifREST extends AbstractREST<Objectif> {

	public ObjectifREST() {
		super(Objectif.class);
	}

}
