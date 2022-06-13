package es.inditex.prices.service;

import es.inditex.prices.service.dto.input.ProductPriceSearch;
import es.inditex.prices.service.dto.output.ProductPrice;

/**
 * Price Service interface for management prices
 * @author Benjamin Rodriguez
 *
 */
public interface PriceService {
    
     ProductPrice searchPrice(ProductPriceSearch searchParms);
     
}
