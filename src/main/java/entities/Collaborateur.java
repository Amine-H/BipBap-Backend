package entities;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlRootElement;
import org.codehaus.jackson.annotate.JsonManagedReference;

@Entity
@XmlRootElement
@NamedQueries({
	@NamedQuery(name = "Collaborateur.getBilans", query = "SELECT b FROM Collaborateur c JOIN c.bilans b WHERE c.id=:id"),
	@NamedQuery(name = "Collaborateur.findAll", query = "SELECT b FROM Collaborateur b")})
public class Collaborateur extends Utilisateur {
	private static final long serialVersionUID = 950417161308108107L;
	@JsonManagedReference
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST,mappedBy="collaborateur")
	private Set<Bilan> bilans;

	public Set<Bilan> getBilans() {
		return bilans;
	}

	public void setBilans(Set<Bilan> bilans) {
		this.bilans = bilans;
	}
}
