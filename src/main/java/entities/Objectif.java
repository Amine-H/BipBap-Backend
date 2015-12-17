package entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@XmlRootElement
@NamedQueries({ @NamedQuery(name = "Objectif.findAll", query = "SELECT o FROM Objectif o"),
	@NamedQuery(name = "Objectif.findById", query = "SELECT o FROM Objectif o WHERE o.id = :id") })
public class Objectif implements Serializable {
	private static final long serialVersionUID = 63484090573148674L;
	@Id
	private long id;
	private String libelle;
	private String description;
	private String categorie;

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
}
