package services;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import entities.Utilisateur;
import listeners.LocalEntityManagerFactory;

/*
 * Utilisateur Restful Resource
 */
@Stateless
@Path("/Utilisateur")
public class UtilisateurREST extends AbstractREST<Utilisateur>{
	public UtilisateurREST() {
		super(Utilisateur.class);
	}

	@GET
	@Path("/login/{email}/{password}")
	@Produces("application/json")
	public Utilisateur login(@PathParam("email") String email, @PathParam("password") String password) {
		EntityManager em = LocalEntityManagerFactory.createEntityManager();
		Utilisateur user = null;
		try {
			Query q = em.createNamedQuery("Utilisateur.login", Utilisateur.class);
			q.setParameter("email", email);
			q.setParameter("password", password);
			user = (Utilisateur) q.getSingleResult();
		} catch (Exception e) {
		} finally {
			em.close();
		}
		return user;
	}
}
