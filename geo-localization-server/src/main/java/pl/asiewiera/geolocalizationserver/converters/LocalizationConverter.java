package pl.asiewiera.geolocalizationserver.converters;

import dtos.LocalizationDto;
import org.springframework.stereotype.Component;
import pl.asiewiera.geolocalizationserver.entities.Localization;

import java.util.function.Function;

@Component
public class LocalizationConverter implements Function<LocalizationDto, Localization> {

    @Override
    public Localization apply(LocalizationDto localizationDto) {
        Localization localization = new Localization();
        localization.setId(localizationDto.getId());
        localization.setDeviceId(localizationDto.getDeviceId());
        localization.setLatitude(localizationDto.getLatitude());
        localization.setLongitude(localizationDto.getLongitude());
        localization.setDateCreated(localizationDto.getDateCreated());

        return localization;
    }
}
