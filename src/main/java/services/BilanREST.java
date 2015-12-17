package services;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import entities.Bilan;
import listeners.LocalEntityManagerFactory;

@Stateless
@Path("/Bilan")
public class BilanREST extends AbstractREST<Bilan> {
	public BilanREST() {
		super(Bilan.class);
	}

	@SuppressWarnings("unchecked")
	@Path("/collab/{id}")
	@GET
	@Produces("application/json")
	public List<Bilan> getBilansForUser(@PathParam("id") long id) {
		EntityManager em = LocalEntityManagerFactory.createEntityManager();
		List<Bilan> bilans = null;

		Query query = em.createNamedQuery("Bilan.getForCollab", Bilan.class);
		query.setParameter("collab", id);
		bilans = query.getResultList();

		return bilans;
	}
}
