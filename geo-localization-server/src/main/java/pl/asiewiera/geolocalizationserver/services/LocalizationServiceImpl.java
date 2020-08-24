package pl.asiewiera.geolocalizationserver.services;

import dtos.LocalizationDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.asiewiera.geolocalizationserver.converters.LocalizationConverter;
import pl.asiewiera.geolocalizationserver.converters.LocalizationDtoConverter;
import pl.asiewiera.geolocalizationserver.entities.Localization;
import pl.asiewiera.geolocalizationserver.exceptions.EntityNotFoundException;
import pl.asiewiera.geolocalizationserver.repositories.LocalizationRepository;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class LocalizationServiceImpl implements LocalizationService {

    private LocalizationRepository localizationRepository;
    private LocalizationConverter localizationConverter;
    private LocalizationDtoConverter localizationDtoConverter;

    public LocalizationServiceImpl(LocalizationRepository localizationRepository, LocalizationConverter localizationConverter, LocalizationDtoConverter localizationDtoConverter) {
        this.localizationRepository = localizationRepository;
        this.localizationConverter = localizationConverter;
        this.localizationDtoConverter = localizationDtoConverter;
    }

    @Autowired


    @Override
    public List<LocalizationDto> findAllLocalizations() {

        Iterable<Localization> localizationIterable = localizationRepository.findAll();
        return StreamSupport.stream(localizationIterable.spliterator(), true)
                .map(e -> localizationDtoConverter.apply(e))
                .collect(Collectors.toList());

    }

    @Override
    public List<LocalizationDto> findFirst5Localizations() {
        Iterable<Localization> localizationIterable = localizationRepository.findAll();
        return StreamSupport.stream(localizationIterable.spliterator(), true)
                .limit(5)
                .map(e -> localizationDtoConverter.apply(e))
                .collect(Collectors.toList());
    }

    @Override
    public LocalizationDto findLocalizationById(Long id) {
        Optional<Localization> localizationOptional = localizationRepository.findById(id);
        if (localizationOptional.isPresent()) {
            return localizationDtoConverter.apply(localizationOptional.get());
        } else {
            throw new EntityNotFoundException("No Localization with such id: " + id);
        }
    }

    @Override
    public LocalizationDto saveLocalization(LocalizationDto localizationDto) {
        localizationDto.setDateCreated(new Timestamp(System.currentTimeMillis()));
        localizationRepository.save(localizationConverter.apply(localizationDto));
        return localizationDto;
    }
}
