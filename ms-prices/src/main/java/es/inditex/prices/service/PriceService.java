package es.inditex.prices.service;

import es.inditex.prices.service.dto.input.ProductPriceSearch;
import es.inditex.prices.service.dto.output.ProductPrice;

/**
 * Price Service interface for management prices
 * @author Paradigma Digital
 *
 */
public interface PriceService {
    
     ProductPrice searchPrice(ProductPriceSearch searchParms);
     
}
