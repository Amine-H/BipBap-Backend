package entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@XmlRootElement
@NamedQueries({ @NamedQuery(name = "BilanObjectif.findAll", query = "SELECT bo FROM BilanObjectif bo"),
		@NamedQuery(name = "BilanObjectif.findById", query = "SELECT bo FROM BilanObjectif bo WHERE bo.id = :id") })
public class BilanObjectif implements Serializable {
	private static final long serialVersionUID = 3583828327071081247L;
	@Id
	private long id;
	private Objectif objectif;
	private Bilan bilan;
	private float resultat;
	private float poids;
	@OneToMany
	private List<Feedback> feedbacks;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public List<Feedback> getFeedbacks() {
		return feedbacks;
	}

	public void setFeedbacks(List<Feedback> feedbacks) {
		this.feedbacks = feedbacks;
	}

	public Objectif getObjectif() {
		return objectif;
	}

	public void setObjectif(Objectif objectif) {
		this.objectif = objectif;
	}

	public Bilan getBilan() {
		return bilan;
	}

	public void setBilan(Bilan bilan) {
		this.bilan = bilan;
	}

	public float getResultat() {
		return resultat;
	}

	public void setResultat(float resultat) {
		this.resultat = resultat;
	}

	public float getPoids() {
		return poids;
	}

	public void setPoids(float poids) {
		this.poids = poids;
	}
}
