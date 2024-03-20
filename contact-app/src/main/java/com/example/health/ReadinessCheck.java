package com.example.health;

import com.example.service.ContactService;
import jakarta.enterprise.context.ApplicationScoped;
import org.eclipse.microprofile.health.HealthCheck;
import org.eclipse.microprofile.health.HealthCheckResponse;
import org.eclipse.microprofile.health.Readiness;

@Readiness
@ApplicationScoped
public class ReadinessCheck implements HealthCheck {

    private final ContactService contactService;

    public ReadinessCheck(ContactService contactService) {
        this.contactService = contactService;
    }

    @Override
    public HealthCheckResponse call() {
        return (contactService.isReady())? HealthCheckResponse.up("OK") : HealthCheckResponse.down("Not ready");
    }
}
