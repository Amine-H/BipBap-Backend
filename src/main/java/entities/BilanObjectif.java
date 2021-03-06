package entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jackson.annotate.JsonIgnore;

@Entity
@XmlRootElement
@NamedQueries({ @NamedQuery(name = "BilanObjectif.findAll", query = "SELECT bo FROM BilanObjectif bo"),
		@NamedQuery(name = "BilanObjectif.findById", query = "SELECT bo FROM BilanObjectif bo WHERE bo.id = :id"),
		@NamedQuery(name = "BilanObjectif.getFeedbacks", query = "SELECT f FROM BilanObjectif bo JOIN bo.feedbacks f WHERE bo.id = :id"),
		@NamedQuery(name = "BilanObjectif.getCollaborator", query = "SELECT bo.bilan.collaborateur FROM BilanObjectif bo WHERE bo.id=:id")})
public class BilanObjectif implements Serializable,Identifiable {
	private static final long serialVersionUID = 3583828327071081247L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
	@JoinColumn(name = "objectif_id")
	private Objectif objectif;
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
	@JoinColumn(name = "bilan_id")
	@JsonIgnore
	private Bilan bilan;
	private float resultat;
	private float poids;
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST,mappedBy="objectif")
	@JsonIgnore
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
