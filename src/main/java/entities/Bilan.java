package entities;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import org.codehaus.jackson.annotate.JsonIgnore;

@Entity
@XmlRootElement
@NamedQueries({ @NamedQuery(name = "Bilan.findAll", query = "SELECT b FROM Bilan b"),
		@NamedQuery(name = "Bilan.findById", query = "SELECT b FROM Bilan b WHERE b.id = :id"),
		@NamedQuery(name = "Bilan.getForCollab", query = "SELECT b FROM Bilan b WHERE b.collaborateur.id = :collab"),
		@NamedQuery(name = "Bilan.getObjectifs", query = "SELECT bo FROM BilanObjectif bo WHERE bo.bilan.id = :bilan")})
public class Bilan implements Serializable, Identifiable {
	private static final long serialVersionUID = -1027553204415003158L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@Temporal(TemporalType.DATE)
	private Date dateCreation;
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
	@JoinColumn(name = "collaborateur_id")
	private Collaborateur collaborateur;
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
	@JoinColumn(name = "manager_id")
	private ManagerRH manager;
	@OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.PERSIST,mappedBy="bilan")
	@JsonIgnore
	private List<BilanObjectif> objectifs;
	private String dtype;
	protected float progression;

	public List<BilanObjectif> getObjectifs() {
		return objectifs;
	}

	public void setObjectifs(List<BilanObjectif> objectifs) {
		this.objectifs = objectifs;
	}

	public float getProgression() {
		return progression;
	}

	public void setProgression(float progression) {
		this.progression = progression;
	}

	public long getId() {
		return id;
	}

	public String getdtype() {
		return dtype;
	}

	public void setdtype(String dtype) {
		this.dtype = dtype;
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
