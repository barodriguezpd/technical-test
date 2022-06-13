package es.inditex.prices.service;

import es.inditex.prices.exception.MainException;
import es.inditex.prices.service.dto.input.ProductPriceSearch;
import es.inditex.prices.service.dto.output.ProductPrice;

/**
 * Price Service interface for management prices
 * @author Benjamin Rodriguez
 *
 */
public interface PriceService {
    
    /**
     * Search unique price from search params
     * @param searchParms
     * @return
     * @throws MainException
     */
    ProductPrice searchPrice(ProductPriceSearch searchParms) throws MainException;
     
}
