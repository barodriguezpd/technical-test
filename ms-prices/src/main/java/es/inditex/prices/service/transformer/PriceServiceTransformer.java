package es.inditex.prices.service.transformer;

import es.inditex.prices.service.dao.entity.Prices;
import es.inditex.prices.service.dto.output.ProductPrice;

/**
 * Interface for price service transformer
 * @author Benjamin Rodriguez
 *
 */
public interface PriceServiceTransformer {
    
    /**
     * Transform to ProductPrice from persistence price
     * @param price
     * @return
     */
    ProductPrice getPrice(Prices price);
    
}
