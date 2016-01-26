package entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
@NamedQueries({ @NamedQuery(name = "Feedback.findAll", query = "SELECT f FROM Feedback f"),
		@NamedQuery(name = "Feedback.findById", query = "SELECT f FROM Feedback f WHERE f.id = :id") })
public class Feedback implements Serializable,Identifiable{
	private static final long serialVersionUID = -6920749212303590449L;
	@Id
	private long id;
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
	@JoinColumn(name = "evaluateur_id")
	private Evaluateur evaluateur;
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
	@JoinColumn(name="bilanobjectif_id")
	private BilanObjectif objectif;
	private String poste;
	private String codeProjet;
	private String nomProjet;
	@Temporal(value = TemporalType.DATE)
	private Date dateDebut;
	@Temporal(value = TemporalType.DATE)
	private Date dateFin;
	private String role;
	private int nombreJours;
	private String commentaire;
	private boolean prive;
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST,mappedBy="feedback")
	@JsonIgnore
	private List<Qualification> qualifications;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Evaluateur getEvaluateur() {
		return evaluateur;
	}

	public void setEvaluateur(Evaluateur evaluateur) {
		this.evaluateur = evaluateur;
	}

	public String getPoste() {
		return poste;
	}

	public void setPoste(String poste) {
		this.poste = poste;
	}

	public String getCodeProjet() {
		return codeProjet;
	}

	public void setCodeProjet(String codeProjet) {
		this.codeProjet = codeProjet;
	}

	public String getNomProjet() {
		return nomProjet;
	}

	public void setNomProjet(String nomProjet) {
		this.nomProjet = nomProjet;
	}

	public Date getDateDebut() {
		return dateDebut;
	}

	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}

	public Date getDateFin() {
		return dateFin;
	}

	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public int getNombreJours() {
		return nombreJours;
	}

	public void setNombreJours(int nombreJours) {
		this.nombreJours = nombreJours;
	}

	public String getCommentaire() {
		return commentaire;
	}

	public void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
	}

	public boolean isPrive() {
		return prive;
	}

	public void setPrive(boolean prive) {
		this.prive = prive;
	}

	public List<Qualification> getQualifications() {
		return qualifications;
	}

	public void setQualifications(List<Qualification> qualifications) {
		this.qualifications = qualifications;
	}
}
