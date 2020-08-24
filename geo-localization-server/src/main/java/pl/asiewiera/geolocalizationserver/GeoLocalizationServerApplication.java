package pl.asiewiera.geolocalizationserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

@EnableSwagger2
@SpringBootApplication
public class GeoLocalizationServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(GeoLocalizationServerApplication.class, args);
    }

    @Bean
    public Docket getDocketDev() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .paths(PathSelectors.ant("/api/**"))
                .apis(RequestHandlerSelectors.basePackage("pl.asiewiera.geolocalizationserver"))
                .build().apiInfo(createApiInfo());
    }


    private ApiInfo createApiInfo() {
        return new ApiInfo("Localizations API",
                "Localizations database",
                "1.00",
                "https://github.com/asiewiera",
                new Contact("Agnieszka", "https://github.com/asiewiera", "Agnieszka.Siewiera@gmail.com"),
                "my own licence",
                "https://github.com/asiewieraa",
                Collections.emptyList()
        );
    }

}
