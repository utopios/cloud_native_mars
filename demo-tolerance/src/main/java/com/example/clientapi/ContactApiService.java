package com.example.clientapi;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;
import java.util.List;
@RegisterRestClient
@Path("/api/v1/contact")
public interface ContactApiService {
    @GET
    List<Object> getContacts();
}
