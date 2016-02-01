package services;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import entities.BilanObjectif;
import entities.Collaborateur;
import entities.Feedback;
import listeners.LocalEntityManagerFactory;

/*
 * BilanObjectif Restful Resource
 */
@Stateless
@Path("/BilanObjectif")
public class BilanObjectifREST extends AbstractREST<BilanObjectif> {

	public BilanObjectifREST() {
		super(BilanObjectif.class);
	}
	
	@SuppressWarnings("unchecked")
	@GET
	@Produces("application/json")
	@Path("/{id}/feedback")
	public List<Feedback> getFeedbacks(@PathParam("id") long id){
		EntityManager em = LocalEntityManagerFactory.createEntityManager();
		Query q = em.createNamedQuery("BilanObjectif.getFeedbacks", Feedback.class);
		q.setParameter("id", id);
		return q.getResultList();
	}
	
	@GET
	@Produces("application/json")
	@Path("{id}/collaborateur")
	public Collaborateur getCollaborateur(@PathParam("id") long id){
		EntityManager em = LocalEntityManagerFactory.createEntityManager();
		Query q = em.createNamedQuery("BilanObjectif.getCollaborator", Collaborateur.class);
		q.setParameter("id", id);
		return (Collaborateur)q.getSingleResult();
	}
	
	@POST
	@Consumes("application/json")
	@Path("/{id}/feedback")
	public void addFeedback(@PathParam("id") long id,Feedback feedback){
		EntityManager em = LocalEntityManagerFactory.createEntityManager();
		try{
			BilanObjectif objectif = em.find(BilanObjectif.class, id);
			List<Feedback> feedbacks = objectif.getFeedbacks();
			em.getTransaction().begin();
			if(feedbacks == null){
				feedbacks = new ArrayList<>();
				objectif.setFeedbacks(feedbacks);
			}
			feedbacks.add(feedback);
			feedback.setObjectif(objectif);
			em.getTransaction().commit();
		}catch(Exception e){e.printStackTrace();}
	}
}
