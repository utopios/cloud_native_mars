package com.example.resource;


import com.example.dto.ContactDTO;
import com.example.service.ContactService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.stream.Collectors;

//Configuration du path (routes), enregistrement de la ressource dans CDI
@Path("api/v1/contact")
//Indiquer que la ressource produit du json
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ContactResource {


    private final ContactService contactService;

    public ContactResource(ContactService contactService) {
        this.contactService = contactService;
    }

    @GET
    public Response get() {
        return Response.ok(contactService.getContacts().stream().map(c -> c.toDto()).toList()).build();
    }

    @GET
    @Path("{id}")
    public Response get(@PathParam("id") int id) {
        return Response.ok().build();
    }

    @POST
    public Response post(ContactDTO contactDTO) {
        try {
            return Response.ok(contactService.addContact(contactDTO).toDto()).build();
        }catch (Exception ex) {
            return Response.status(500).build();
        }
    }

    @PUT
    @Path("{id}")
    public Response put(@PathParam("id") int id) {
        return Response.ok().build();
    }

    @DELETE
    @Path("{id}")
    public Response delete(@PathParam("id") int id) {
        return Response.ok().build();
    }
}
