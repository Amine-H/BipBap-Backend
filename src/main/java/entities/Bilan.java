package entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@XmlRootElement
@NamedQueries({ @NamedQuery(name = "Bilan.findAll", query = "SELECT b FROM Bilan b"),
		@NamedQuery(name = "Bilan.findById", query = "SELECT b FROM Bilan b WHERE b.id = :id"),
		@NamedQuery(name = "Bilan.getForCollab", query = "SELECT b FROM Bilan b WHERE b.collaborateur.id = :collab") })
public class Bilan implements Serializable {
	private static final long serialVersionUID = -1027553204415003158L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@Temporal(TemporalType.DATE)
	private Date dateCreation;
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
	private Collaborateur collaborateur;
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
	private ManagerRH manager;
	private String DTYPE;
	protected float progression;

	public float getProgression() {
		return progression;
	}

	public void setProgression(float progression) {
		this.progression = progression;
	}

	public long getId() {
		return id;
	}

	public String getDTYPE() {
		return DTYPE;
	}

	public void setDTYPE(String dTYPE) {
		DTYPE = dTYPE;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Date getDateCreation() {
		return dateCreation;
	}

	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}

	public Collaborateur getCollaborateur() {
		return collaborateur;
	}

	public void setCollaborateur(Collaborateur collaborateur) {
		this.collaborateur = collaborateur;
	}

	public ManagerRH getManager() {
		return manager;
	}

	public void setManager(ManagerRH manager) {
		this.manager = manager;
	}
}
