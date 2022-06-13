package es.inditex.prices.service.transformer.impl;

import es.inditex.prices.service.dao.entity.Prices;
import es.inditex.prices.service.dto.output.ProductPrice;
import es.inditex.prices.service.transformer.PriceServiceTransformer;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class PriceServiceTransformerImpl implements PriceServiceTransformer {
    
    @Override
    public ProductPrice getPrice(Prices price) {
        return ProductPrice.builder().brand(price.getBrandId()).endDate(price.getEndDate())
            .startDate(price.getStartDate()).priceList(price.getPriceList())
            .price(price.getPrice()).product(new Long(price.getProductId()).intValue())
            .build();
    }
    
}
