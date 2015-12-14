package services;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import listeners.LocalEntityManagerFactory;

public abstract class AbstractREST<T> {
	private Class<T> entityClass;
	private String entityName;
	public AbstractREST(Class<T> entityClass){
		this.entityClass = entityClass;
		this.entityName = entityClass.getSimpleName();
	}
	@GET
	@Path("/{id}")
	@Produces("application/json")
	public T find(@PathParam("id") long id) {
		EntityManager em = LocalEntityManagerFactory.createEntityManager();

		try {
			return em.find(entityClass, id);
		} finally {
			em.close();
		}
	}

	@SuppressWarnings("unchecked")
	@GET
	@Produces("application/json")
	public List<T> findAll() {
		EntityManager em = LocalEntityManagerFactory.createEntityManager();

		try {
			Query query = em.createNamedQuery(entityName+".findAll", entityClass);

			return query.getResultList();
		} finally {
			em.close();
		}
	}

	@POST
	@Consumes("application/json")
	public void create(T entity) {
		EntityManager em = LocalEntityManagerFactory.createEntityManager();
		try {
			em.getTransaction().begin();
			em.persist(entity);
			em.getTransaction().commit();
		} finally {
			em.close();
		}
	}

	@PUT
	@Path("/{id}")
	@Consumes("application/json")
	public void update(@PathParam("id") long id, T entity) {
		EntityManager em = LocalEntityManagerFactory.createEntityManager();
		try {
			em.getTransaction().begin();
			em.merge(entity);
			em.getTransaction().commit();
		} finally {
			em.close();
		}
	}

	@DELETE
	@Path("/{id}")
	public void remove(@PathParam("id") long id) {
		EntityManager em = LocalEntityManagerFactory.createEntityManager();
		try {
			em.getTransaction().begin();
			em.remove(em.find(entityClass, id));
			em.getTransaction().commit();
		} finally {
			em.close();
		}
	}
}
