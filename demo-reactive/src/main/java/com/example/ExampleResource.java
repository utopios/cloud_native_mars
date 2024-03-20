package com.example;

import io.smallrye.mutiny.Multi;
import io.smallrye.mutiny.Uni;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import java.time.Duration;

@Path("/hello")
public class ExampleResource {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public Uni<String> hello() {
        return Uni.createFrom().item("Hello from RESTEasy Reactive")
                .onItem()
                .delayIt().by(Duration.ofSeconds(1))
                .onItem().transform(item -> item + " delay ");
    }

    @GET
    @Path("/stream")
    @Produces(MediaType.APPLICATION_OCTET_STREAM)
    public Multi<String> stream() {
        return Multi.createFrom().items("Hello", "From", "Quarkus")
                .onItem().transformToUni(item -> Uni.createFrom().item(item).onItem().delayIt().by(Duration.ofSeconds(1)))
                .concatenate();
    }
}
