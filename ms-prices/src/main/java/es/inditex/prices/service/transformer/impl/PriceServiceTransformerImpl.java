package es.inditex.prices.service.transformer.impl;

import es.inditex.prices.service.dao.entity.Prices;
import es.inditex.prices.service.dto.output.ProductPrice;
import es.inditex.prices.service.transformer.PriceServiceTransformer;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;

@Component
public class PriceServiceTransformerImpl implements PriceServiceTransformer {
    
    @Override
    public ProductPrice getPrice(Prices price) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmm");
        try {
            return ProductPrice.builder().brand(price.getBrandId()).endDate(sdf.parse(Long.toString(price.getEndDate())))
                .startDate(sdf.parse(Long.toString(price.getStartDate()))).priceList(price.getPriceList())
                .price(price.getPrice()).product(new Long(price.getProductId()).intValue())
                .build();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }
    
}
