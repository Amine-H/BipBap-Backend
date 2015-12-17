package services;

import javax.ejb.Stateless;
import javax.ws.rs.Path;

import entities.BilanObjectif;

@Stateless
@Path("/BilanObjectif")
public class BilanObjectifREST extends AbstractREST<BilanObjectif> {

	public BilanObjectifREST() {
		super(BilanObjectif.class);
	}
}
