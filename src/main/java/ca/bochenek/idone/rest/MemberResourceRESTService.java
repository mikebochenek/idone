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

import ca.bochenek.idone.data.DoneListProducer;
import ca.bochenek.idone.entity.DoneItem;

@Path("/items")
@RequestScoped
public class MemberResourceRESTService {
    
    @Inject
    private Logger log;

    @Inject
    private Validator validator;

    @Inject
    private DoneListProducer repository;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<DoneItem> listAll() {
        return repository.loadAll();
    }

    @GET
    @Path("/{id:[0-9][0-9]*}")
    @Produces(MediaType.APPLICATION_JSON)
    public DoneItem lookupMemberById(@PathParam("id") long id) {
        DoneItem member = repository.findById(id);
        if (member == null) {
            throw new WebApplicationException(Response.Status.NOT_FOUND);
        }
        return member;
    }

}
