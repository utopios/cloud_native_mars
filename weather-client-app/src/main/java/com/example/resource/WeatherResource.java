package com.example.resource;


import com.example.dto.WeatherInfo;
import com.example.service.WeatherServiceClient;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import org.eclipse.microprofile.faulttolerance.CircuitBreaker;
import org.eclipse.microprofile.faulttolerance.Fallback;
import org.eclipse.microprofile.rest.client.inject.RestClient;

@Path("/api/weather")
public class WeatherResource {

    @Inject
    @RestClient
    private WeatherServiceClient weatherServiceClient;

    @GET
    @Path("/{city}")
    @Fallback(fallbackMethod = "genericWeatherInfo")
    @CircuitBreaker(requestVolumeThreshold = 3, failureRatio = 1, delay = 120000)
    public WeatherInfo get(@PathParam("city") String cityname) {
        return weatherServiceClient.getWeatherInfo(cityname);
    }

    private WeatherInfo genericWeatherInfo(String cityname) {
        return WeatherInfo.builder().cityName(cityname
        ).message("Informations météorologiques non disponibles").build();
    }
}
