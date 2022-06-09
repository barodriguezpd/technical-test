package es.inditex.prices.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.ArrayList;

/**
 * Swagger Configurator
 * @author Benjamin Rodriguez
 */
@Configuration
public class Swagger2Config {

    /**
     * @return
     */
    @Bean
    public static Docket api() {

        ApiInfo apiInfo = new ApiInfo(
            "prices",
            "This API has been developed for technical test",
            "1.0.0",
            "",
            new Contact("Inditex", "", ""),
            null,
            null,
            new ArrayList<>());

        return new Docket(DocumentationType.SWAGGER_2)
            .useDefaultResponseMessages(false)
            .apiInfo(apiInfo)
            .select()
            .apis(RequestHandlerSelectors.basePackage("es.inditex.prices.controller"))
            .paths(PathSelectors.regex("/.*"))
            .build();
    }

}