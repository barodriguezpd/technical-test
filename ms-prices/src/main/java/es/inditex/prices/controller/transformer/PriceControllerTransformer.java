package es.inditex.prices.controller.transformer;

import es.inditex.prices.controller.rdto.response.ProductPriceRDTO;
import es.inditex.prices.exception.MainException;
import es.inditex.prices.service.dto.input.ProductPriceSearch;
import es.inditex.prices.service.dto.output.ProductPrice;

/**
 * Interface for transformer operations in controller
 * @author Benjamin Rodriguez
 *
 */
public interface PriceControllerTransformer {
    
    /**
     * Transform data input in ProductPriceSearch
     * @param brand
     * @param product
     * @param date
     * @return
     */
    ProductPriceSearch getProductPriceSearch(Integer brand, Integer product, String date) throws MainException;
    
    /**
     * Transform productPrice in ProductPriceRDTO
     * @param productPrice
     * @return
     */
    ProductPriceRDTO getProductPriceRDTO(ProductPrice productPrice);
    
    /**
     * Transform productPrice in API.ProductPrice
     * @param productPrice
     * @return
     */
    es.inditex.prices.api.model.ProductPrice getProductPrice(ProductPrice productPrice);
    
    
}
