package com.example;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.faulttolerance.CircuitBreaker;
import org.eclipse.microprofile.faulttolerance.Fallback;
import org.eclipse.microprofile.faulttolerance.Retry;
import org.eclipse.microprofile.faulttolerance.Timeout;
import org.jboss.logging.Logger;

import java.util.Random;


@Path("/hello")
public class ExampleResource {

    private static final Logger logger = Logger.getLogger(ExampleResource.class);
    private Random random = new Random();

    private void randomFail() {
        if(true) {
            logger.error("Application failed");
            throw new RuntimeException("Application failed");
        }
    }

    @GET
    @Retry(maxRetries = 5)
    //@Timeout(value = 2000)
    @Fallback(fallbackMethod = "defaultAction")
    @Produces(MediaType.TEXT_PLAIN)
    @CircuitBreaker(requestVolumeThreshold = 4, failureRatio = 1, delay = 5000)
    public String hello() {
        randomFail();
        //longSleep();
        return "Hello from RESTEasy Reactive";
    }

    private void longSleep() {
        try {
            Thread.sleep(10000);
        }catch (InterruptedException ex) {
            throw new RuntimeException(ex.getMessage());
        }
    }

    private String defaultAction() {
        return "Default action";
    }
}
