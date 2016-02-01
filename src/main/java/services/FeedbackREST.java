package services;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import entities.Collaborateur;
import entities.Feedback;
import entities.Qualification;
import listeners.LocalEntityManagerFactory;

/*
 *  Feedback Restful Resource
 */
@Stateless
@Path("/Feedback")
public class FeedbackREST extends AbstractREST<Feedback>{

	public FeedbackREST() {
		super(Feedback.class);
	}

	@SuppressWarnings("unchecked")
	@GET
	@Produces("application/json")
	@Path("/{id}/qualification")
	public List<Qualification> getQualifications(@PathParam("id") long id){
		List<Qualification> qualifications = null;
		EntityManager em = LocalEntityManagerFactory.createEntityManager();
		Query q = em.createNamedQuery("Feedback.getQualifications", Qualification.class);
		q.setParameter("id", id);
		qualifications = q.getResultList();		
		return qualifications;
	}
	
	@GET
	@Produces("application/json")
	@Path("{id}/collaborateur")
	public Collaborateur getCollaborateur(@PathParam("id") long id){
		EntityManager em = LocalEntityManagerFactory.createEntityManager();
		Query q = em.createNamedQuery("Feedback.getCollaborator", Collaborateur.class);
		q.setParameter("id", id);
		return (Collaborateur)q.getSingleResult();
	}
	
	@POST
	@Consumes("application/json")
	@Path("/{id}/qualification")
	public void addQualification(@PathParam("id") long id,Qualification entity){
		EntityManager em = LocalEntityManagerFactory.createEntityManager();
		
		Feedback feedback = em.find(Feedback.class, id);
		List<Qualification> qualifications = null;
		
		em.getTransaction().begin();
		qualifications = feedback.getQualifications();
		if(qualifications == null){
			qualifications = new ArrayList<>();
			feedback.setQualifications(qualifications);
		}
		entity.setFeedback(feedback);
		qualifications.add(entity);
		em.getTransaction().commit();
	}
	
	@POST
	@Consumes("application/json")
	@Path("/{id}/qualifications")
	public void setQualifications(@PathParam("id") long id,List<Qualification> qualifications){
		EntityManager em = LocalEntityManagerFactory.createEntityManager();
		
		Feedback feedback = em.find(Feedback.class, id);
		Iterator<Qualification> qIterator;
		
		em.getTransaction().begin();
		feedback.setQualifications(qualifications);
		for(qIterator = qualifications.iterator();qIterator.hasNext();){
			Qualification qualification = qIterator.next();
			qualification.setFeedback(feedback);
		}
		em.getTransaction().commit();
	}
	
	@PUT
	@Consumes("application/json")
	@Path("{id}/qualifications")
	public void updateQualifications(@PathParam("id") long id,List<Qualification> qualifications){
		EntityManager em = LocalEntityManagerFactory.createEntityManager();
		Feedback feedback = em.find(Feedback.class, id);
		Iterator<Qualification> qIterator = qualifications.iterator();
		em.getTransaction().begin();
		while(qIterator.hasNext()){
			Qualification qualification = qIterator.next();
			qualification.setFeedback(feedback);
			em.merge(qualification);
		}
		em.getTransaction().commit();
	}
}
