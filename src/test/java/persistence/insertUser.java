package persistence;

import javax.persistence.EntityManager;

import org.junit.Test;

import entities.Administrateur;
import listeners.LocalEntityManagerFactory;

public class insertUser {

	@Test
	public void test() {
		Administrateur admin = new Administrateur();
		admin.setNom("Nom");
		admin.setPrenom("Prenom");
		admin.setEmail("Email");
		admin.setPassword("Password");
		admin.setMatricule("Matricule");
		admin.setPoste("Poste");
		
		EntityManager em = LocalEntityManagerFactory.createEntityManager();
		
		em.persist(admin);
		
		admin = null;
		
		//admin = em.find(Administrateur.class, 1);
	}

}
