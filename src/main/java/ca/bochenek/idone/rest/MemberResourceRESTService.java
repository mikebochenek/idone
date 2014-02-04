package ca.bochenek.idone.rest;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.validation.Validator;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import ca.bochenek.idone.entity.Done;

@Path("/members")
@RequestScoped
public class MemberResourceRESTService {
    
    @Inject
    private Logger log;

    @Inject
    private Validator validator;

    @Inject
//    private MemberRepository repository;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Done> listAll() {
        return new ArrayList<Done>();  //repository.findAllOrderedByName();
    }

    @GET
    @Path("/{id:[0-9][0-9]*}")
    @Produces(MediaType.APPLICATION_JSON)
    public Done lookupMemberById(@PathParam("id") long id) {
        Done member = new Done(); //repository.findById(id);
        if (member == null) {
            throw new WebApplicationException(Response.Status.NOT_FOUND);
        }
        return member;
    }

}
