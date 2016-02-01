package services;

import javax.ejb.Stateless;
import javax.ws.rs.Path;
import entities.Administrateur;

/*
 * Administrateur Restful Resource
 */
@Stateless
@Path("/Administrateur")
public class AdministrateurREST extends AbstractREST<Administrateur>{
	public AdministrateurREST() {
		super(Administrateur.class);
	}

}
