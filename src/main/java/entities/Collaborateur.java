package entities;

import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@XmlRootElement
public class Collaborateur extends Utilisateur {
	private static final long serialVersionUID = 950417161308108107L;
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
	private Set<Bilan> bilans;

	public Set<Bilan> getBilans() {
		return bilans;
	}

	public void setBilans(Set<Bilan> bilans) {
		this.bilans = bilans;
	}
}
