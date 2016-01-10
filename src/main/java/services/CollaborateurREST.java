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
import entities.Collaborateur;
import listeners.LocalEntityManagerFactory;

@Stateless
@Path("/Collaborateur")
public class CollaborateurREST extends AbstractREST<Collaborateur> {
	public CollaborateurREST() {
		super(Collaborateur.class);
	}

	@SuppressWarnings("unchecked")
	@GET
	@Path("/{id}/bilans")
	@Produces("application/json")
	public List<Bilan> getBilans(@PathParam("id") long id) {
		List<Bilan> list = null;
		EntityManager em = LocalEntityManagerFactory.createEntityManager();
		try {
			Query query = em.createNamedQuery("Collaborateur.getBilans", Bilan.class);
			query.setParameter("id", id);
			list = query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}
}
