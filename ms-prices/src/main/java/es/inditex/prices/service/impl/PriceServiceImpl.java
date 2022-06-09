package es.inditex.prices.service.impl;

import es.inditex.prices.service.PriceService;
import es.inditex.prices.service.dto.input.ProductPriceSearch;
import es.inditex.prices.service.dto.output.ProductPrice;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PriceServiceImpl implements PriceService {
    
    @Override
    public ProductPrice searchPrice(ProductPriceSearch searchParms) {
        return null;
    }
    
}
