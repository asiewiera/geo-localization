package pl.asiewiera.geolocalizationserver.converters;

import dtos.LocalizationDto;
import org.springframework.stereotype.Component;
import pl.asiewiera.geolocalizationserver.entities.Localization;

import java.util.function.Function;

@Component
public class LocalizationDtoConverter implements Function<Localization, LocalizationDto> {

    @Override
    public LocalizationDto apply(Localization localization) {

        return new LocalizationDto(localization.getId(), localization.getLatitude(), localization.getLongitude(), localization.getDateCreated());
    }
}
