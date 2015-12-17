package services;

import javax.ejb.Stateless;
import javax.ws.rs.Path;
import entities.BIP;

@Stateless
@Path("/BIP")
public class BIPREST extends AbstractREST<BIP> {

	public BIPREST() {
		super(BIP.class);
	}
}
