package entities;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jackson.annotate.JsonIgnore;

@Entity
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ManagerRH.findAll", query = "SELECT u FROM ManagerRH u"),
    @NamedQuery(name = "ManagerRH.findById", query = "SELECT u FROM ManagerRH u WHERE u.id = :id")})
public class ManagerRH extends Utilisateur {
	private static final long serialVersionUID = 3259601862182253323L;
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST,mappedBy="manager")
	private Set<Bilan> bilans;

	public Set<Bilan> getBilans() {
		return bilans;
	}

	public void setBilans(Set<Bilan> bilans) {
		this.bilans = bilans;
	}
}
