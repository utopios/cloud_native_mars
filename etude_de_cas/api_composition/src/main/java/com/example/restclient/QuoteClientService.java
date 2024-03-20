package com.example.restclient;


import com.example.dto.AuthorDTO;
import com.example.dto.QuoteDTO;
import io.smallrye.mutiny.Uni;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@RegisterRestClient
@Path("/api/v1/quote")
public interface QuoteClientService {

    @Path("/{id}")
    @GET
    Uni<QuoteDTO> get(@PathParam("id") Long id);
}
