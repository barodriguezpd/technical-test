package es.inditex.prices.controller.transformer.impl;

import es.inditex.prices.controller.rdto.response.ProductPriceRDTO;
import es.inditex.prices.controller.transformer.PriceControllerTransformer;
import es.inditex.prices.service.dto.output.ProductPrice;
import org.springframework.stereotype.Component;

@Component
public class PriceControllerTransformerImpl implements PriceControllerTransformer {
    
    @Override
    public es.inditex.prices.service.dto.input.ProductPriceSearch getProductPriceSearch(String brand, String product, String date) {
        // TODO Auto-generated method stub
        return null;
    }
    
    @Override
    public ProductPriceRDTO getProductPriceRDTO(ProductPrice productPrice) {
        // TODO Auto-generated method stub
        return null;
    }
    
}
