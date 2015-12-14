package entities;

import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Administrateur.findAll", query = "SELECT a FROM Administrateur a"),
    @NamedQuery(name = "Administrateur.findById", query = "SELECT a FROM Administrateur a WHERE a.id = :id")})
public class Administrateur extends Utilisateur{
	private static final long serialVersionUID = 4171017535863816556L;

}
