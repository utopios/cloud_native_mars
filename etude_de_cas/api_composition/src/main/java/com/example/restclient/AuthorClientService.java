package com.example.restclient;

import com.example.dto.AuthorDTO;
import io.smallrye.mutiny.Uni;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@RegisterRestClient
@Path("/api/v1/author")
public interface AuthorClientService {

    @Path("/{id}")
    @GET
    Uni<AuthorDTO> get(@PathParam("id") Long id);
}
