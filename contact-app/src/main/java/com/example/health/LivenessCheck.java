package com.example.health;

import com.example.service.ContactService;
import jakarta.enterprise.context.ApplicationScoped;
import org.eclipse.microprofile.health.HealthCheck;
import org.eclipse.microprofile.health.HealthCheckResponse;
import org.eclipse.microprofile.health.Liveness;


@Liveness
@ApplicationScoped
public class LivenessCheck implements HealthCheck {

    private final ContactService contactService;

    public LivenessCheck(ContactService contactService) {
        this.contactService = contactService;
    }

    @Override
    public HealthCheckResponse call() {
        if(contactService.isLive())
            return HealthCheckResponse.up("OK");
        else
            return HealthCheckResponse.down("Error service");
    }
}
