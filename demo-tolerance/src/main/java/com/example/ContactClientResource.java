package com.example;

import com.example.clientapi.ContactApiService;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.faulttolerance.CircuitBreaker;
import org.eclipse.microprofile.faulttolerance.Fallback;
import org.eclipse.microprofile.faulttolerance.Retry;
import org.eclipse.microprofile.rest.client.inject.RestClient;

@Path("client/contacts")
public class ContactClientResource {

    @RestClient
    @Inject
    private ContactApiService contactApiService;

    @Retry(maxRetries = 3)
    @Fallback(fallbackMethod = "defaultAction")
    @CircuitBreaker(requestVolumeThreshold = 1, failureRatio = 1, delay = 10000)
    @GET
    public Response getContacts() {
        return Response.ok(contactApiService.getContacts()).build();
    }

    public Response defaultAction() {
        return Response.ok("default action contact api not working").build();
    }
}
