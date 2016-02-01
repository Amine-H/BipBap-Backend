package services;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import entities.BIP;
import entities.BilanObjectif;
import listeners.LocalEntityManagerFactory;

/*
 * BIP Restful Restful Resource
 */
@Stateless
@Path("/BIP")
public class BIPREST extends AbstractREST<BIP> {

	public BIPREST() {
		super(BIP.class);
	}
	
	@POST
	@Path("/{id}/objectif")
	@Consumes("application/json")
	public void addObjectif(@PathParam("id") long id, BilanObjectif entity) {
		EntityManager em = LocalEntityManagerFactory.createEntityManager();
		try {
			BIP bilan = em.find(BIP.class, id);
			if (bilan != null) {
				List<BilanObjectif> objectifs = bilan.getObjectifs();
				if (objectifs == null) {
					objectifs = new ArrayList<>();
					bilan.setObjectifs(objectifs);
				}
				objectifs.add(entity);
				em.getTransaction().begin();
				em.merge(bilan);
				em.getTransaction().commit();
			}
		} finally {
			em.close();
		}
	}
}
