package entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@XmlRootElement
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@NamedQueries({
    @NamedQuery(name = "BIP.findAll", query = "SELECT b FROM BIP b"),
    @NamedQuery(name = "BIP.findById", query = "SELECT b FROM BIP b WHERE b.id = :id")})
public class BIP extends Bilan implements Serializable {
	private static final long serialVersionUID = 3207158439314434363L;
	private String planFormation;
	private String actions;

	public String getPlanFormation() {
		return planFormation;
	}

	public void setPlanFormation(String planFormation) {
		this.planFormation = planFormation;
	}

	public String getActions() {
		return actions;
	}

	public void setActions(String actions) {
		this.actions = actions;
	}
}
