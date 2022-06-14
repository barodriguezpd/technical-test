package es.inditex.prices.controller.impl;

import es.inditex.prices.api.PriceApi;
import es.inditex.prices.api.model.ProductPrice;
import es.inditex.prices.controller.transformer.PriceControllerTransformer;
import es.inditex.prices.exception.MainException;
import es.inditex.prices.service.PriceService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RestController;

/**
 * Implement Open Api Price
 * @author Benjamin Rodriguez
 *
 */
@RequiredArgsConstructor
@Component
@Slf4j
@RestController
public class PriceControllerImpl implements PriceApi {

    private final PriceControllerTransformer transformer;
    
    private final PriceService service;

    @Override
    public ResponseEntity<ProductPrice> searchPrices(Integer brand, Integer product, String date) {
        log.info("Query with Brand {} Product {} Date {}", brand, product, date);
        try {
            return new ResponseEntity<ProductPrice>(transformer.getProductPrice(service.searchPrice(transformer.getProductPriceSearch(brand, product, date))), HttpStatus.OK);
        } catch (MainException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
    
}
