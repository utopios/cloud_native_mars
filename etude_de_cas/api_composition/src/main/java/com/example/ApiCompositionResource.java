package com.example;

import com.example.dto.AllDTO;
import com.example.dto.AuthorDTO;
import com.example.dto.QuoteDTO;
import com.example.restclient.AuthorClientService;
import com.example.restclient.QuoteClientService;
import io.smallrye.mutiny.Uni;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.rest.client.inject.RestClient;

@Path("/all")
@Produces(MediaType.APPLICATION_JSON)
public class ApiCompositionResource {


    @RestClient
    @Inject
    private AuthorClientService authorClientService;
    @RestClient
    @Inject
    private  QuoteClientService quoteClientService;

    /*public ApiCompositionResource(AuthorClientService authorClientService, QuoteClientService quoteClientService) {
        this.authorClientService = authorClientService;
        this.quoteClientService = quoteClientService;
    }*/

    @GET
    @Path("/{id}")
    public Uni<AllDTO> get(@PathParam("id") Long id) {
        /*return quoteClientService.get(id)
                .onItem().transformToUni(quoteDTO ->
                        authorClientService.get(quoteDTO.getAuthorDTO().getId())
                )
                .onItem().transform(authorDTO ->
                        AllDTO.builder().authorDTO(authorDTO).quoteDTO(qu).build()
                );*/

        return quoteClientService.get(id).flatMap(quoteDTO ->
            authorClientService.get(quoteDTO.getAuthorDTO().getId()).map(authorDTO ->
                AllDTO.builder().quoteDTO(quoteDTO).authorDTO(authorDTO).build()
            ));
    }
}
