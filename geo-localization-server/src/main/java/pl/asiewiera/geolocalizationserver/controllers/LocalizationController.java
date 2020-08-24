package pl.asiewiera.geolocalizationserver.controllers;

import dtos.LocalizationDto;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.asiewiera.geolocalizationserver.services.LocalizationService;

import java.util.List;

@RestController
@RequestMapping(value = "/api/locals")
public class LocalizationController {

    private LocalizationService localizationService;

    @Autowired
    public LocalizationController(LocalizationService localizationService) {
        this.localizationService = localizationService;
    }
    @ApiOperation(value = "Find all localizations", notes = "Provide information about all localizations", hidden = false)
    @GetMapping
    public List<LocalizationDto> getAllLocals(){
        return localizationService.findAllLocalizations();
    }

    @GetMapping(value = "/limit")
    public List<LocalizationDto> getFirstLocals(){
        return localizationService.findFirst5Localizations();
    }

    @GetMapping(value = "/{id}")
    public LocalizationDto getLocalById(@PathVariable Long id){
        return localizationService.findLocalizationById(id);
    }

    @PostMapping()
    public LocalizationDto createLocal(@RequestBody LocalizationDto localizationDto){
        return localizationService.saveLocalization(localizationDto);
    }

}
