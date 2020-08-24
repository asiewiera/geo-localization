package pl.asiewiera.geolocalizationclient;

import dtos.LocalizationDto;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
public class LocalizationClient {

    private RestTemplate restTemplate;

    public LocalizationClient() {
        this.restTemplate = new RestTemplate();
    }


    @EventListener(ApplicationReadyEvent.class)
    public void getLocalization(){

        ResponseEntity<List<LocalizationDto>> localizationResponseEntity;
        localizationResponseEntity = restTemplate.exchange("http://localhost:8090/api/locals",
                HttpMethod.GET,
                HttpEntity.EMPTY,
                new ParameterizedTypeReference<List<LocalizationDto>>() {
                });
        List<LocalizationDto> localizationDtoList = localizationResponseEntity.getBody();
        localizationDtoList.stream().forEach(System.out::println);
    }
}
