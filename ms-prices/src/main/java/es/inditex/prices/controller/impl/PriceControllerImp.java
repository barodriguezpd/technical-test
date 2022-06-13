package es.inditex.prices.controller.impl;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import es.inditex.prices.controller.PriceController;
import es.inditex.prices.controller.rdto.response.ProductPriceRDTO;
import es.inditex.prices.controller.transformer.PriceControllerTransformer;
import es.inditex.prices.exception.MainException;
import es.inditex.prices.service.PriceService;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller implementation for api price service
 * @author Benjamin Rodriguez
 *
 */
@Slf4j
@RestController
@Api(value = "Inditex Price", tags = {"price"})
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@Component
@RequiredArgsConstructor
public class PriceControllerImp implements PriceController {

    private final PriceControllerTransformer transformer;
    
    private final PriceService service;
    
    @Override
    public ProductPriceRDTO getPrice(Integer brand, Integer product, String date) throws MainException {
        log.info("Query with Brand {} Product {} Date {}", brand, product, date);
        return transformer.getProductPriceRDTO(service.searchPrice(transformer.getProductPriceSearch(brand, product, date)));
        
    }
    
}
