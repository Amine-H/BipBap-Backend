package entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@NamedQueries({
    @NamedQuery(name = "BAP.findAll", query = "SELECT b FROM BAP b"),
    @NamedQuery(name = "BAP.findById", query = "SELECT b FROM BAP b WHERE b.id = :id")})
public class BAP extends Bilan implements Serializable {
	private static final long serialVersionUID = -7766572062544677149L;
	private String decision;
	private String etat;

	public String getDecision() {
		return decision;
	}

	public void setDecision(String decision) {
		this.decision = decision;
	}

	public String getEtat() {
		return etat;
	}

	public void setEtat(String etat) {
		this.etat = etat;
	}
}
