package pl.asiewiera.geolocalizationserver.services;


import dtos.LocalizationDto;

import java.util.List;

public interface LocalizationService {

    List<LocalizationDto> findAllLocalizations();

    List<LocalizationDto> findFirst5Localizations();

    LocalizationDto findLocalizationById(Long id);

    LocalizationDto saveLocalization(LocalizationDto localizationDto);


}
