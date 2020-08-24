package pl.asiewiera.geolocalizationserver.repositories;


import org.springframework.data.repository.CrudRepository;
import pl.asiewiera.geolocalizationserver.entities.Localization;

public interface LocalizationRepository extends CrudRepository<Localization, Long> {




}
