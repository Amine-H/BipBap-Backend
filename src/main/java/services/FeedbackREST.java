package services;

import javax.ejb.Stateless;
import javax.ws.rs.Path;

import entities.Feedback;

@Stateless
@Path("/Feedback")
public class FeedbackREST extends AbstractREST<Feedback>{

	public FeedbackREST() {
		super(Feedback.class);
	}

}
