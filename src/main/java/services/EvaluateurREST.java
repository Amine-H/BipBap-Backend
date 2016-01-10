package services;

import javax.ejb.Stateless;
import javax.ws.rs.Path;
import entities.Evaluateur;

@Stateless
@Path("/Evaluateur")
public class EvaluateurREST extends AbstractREST<Evaluateur>{
	public EvaluateurREST() {
		super(Evaluateur.class);
	}

}
