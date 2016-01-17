package entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@XmlRootElement
@NamedQueries({ @NamedQuery(name = "Objectif.findAll", query = "SELECT o FROM Objectif o"),
	@NamedQuery(name = "Objectif.findById", query = "SELECT o FROM Objectif o WHERE o.id = :id") })
public class Objectif implements Serializable,Identifiable {
	private static final long serialVersionUID = 63484090573148674L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	private String libelle;
	private String description;
	private String categorie;
	private String mesure;
	private String responsable_mesure;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCategorie() {
		return categorie;
	}

	public void setCategorie(String categorie) {
		this.categorie = categorie;
	}

	public String getMesure() {
		return mesure;
	}

	public void setMesure(String mesure) {
		this.mesure = mesure;
	}

	public String getResponsable_mesure() {
		return responsable_mesure;
	}

	public void setResponsable_mesure(String responsable_mesure) {
		this.responsable_mesure = responsable_mesure;
	}
}
