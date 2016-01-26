package services;

import javax.ejb.Stateless;
import javax.ws.rs.Path;
import entities.Qualification;

@Stateless
@Path("/Qualification")
public class QualificationREST extends AbstractREST<Qualification> {

	public QualificationREST() {
		super(Qualification.class);
	}

}
