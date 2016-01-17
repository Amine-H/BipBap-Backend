package services;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import entities.BAP;
import entities.BilanObjectif;
import listeners.LocalEntityManagerFactory;

@Stateless
@Path("/BAP")
public class BAPREST extends AbstractREST<BAP> {

	public BAPREST() {
		super(BAP.class);
	}

	@POST
	@Path("/{id}/objectif")
	@Consumes("application/json")
	public void addObjectif(@PathParam("id") long id, BilanObjectif entity) {
		EntityManager em = LocalEntityManagerFactory.createEntityManager();
		try {
			BAP bilan = em.find(BAP.class, id);
			if (bilan != null) {
				List<BilanObjectif> objectifs = bilan.getObjectifs();
				if (objectifs == null) {
					objectifs = new ArrayList<>();
					bilan.setObjectifs(objectifs);
				}
				objectifs.add(entity);
				em.getTransaction().begin();
				entity.setBilan(bilan);
				em.merge(bilan);
				em.getTransaction().commit();
			}
		} finally {
			em.close();
		}
	}
}
