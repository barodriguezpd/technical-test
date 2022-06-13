package es.inditex.prices.controller.transformer.impl;

import es.inditex.prices.controller.rdto.response.ProductPriceRDTO;
import es.inditex.prices.controller.transformer.PriceControllerTransformer;
import es.inditex.prices.exception.MainException;
import es.inditex.prices.exception.NotValidException;
import es.inditex.prices.service.dto.input.ProductPriceSearch;
import es.inditex.prices.service.dto.output.ProductPrice;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class PriceControllerTransformerImpl implements PriceControllerTransformer {
    
    @Override
    public es.inditex.prices.service.dto.input.ProductPriceSearch getProductPriceSearch(Integer brand, Integer product, String date) throws MainException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        Date dateSearch = null;
        try {
            dateSearch = sdf.parse(date);
        } catch (ParseException e) {
            throw new NotValidException("Error in date field");
        }
        return ProductPriceSearch.builder().brand(brand).product(new Long(product)).date(dateSearch).build();
    }
    
    @Override
    public ProductPriceRDTO getProductPriceRDTO(ProductPrice productPrice) {
        SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        return ProductPriceRDTO.builder().brand(productPrice.getBrand()).endDate(sdfDate.format(productPrice.getEndDate()))
            .price(productPrice.getPrice()).product(productPrice.getProduct()).startDate(sdfDate.format(productPrice.getStartDate()))
            .priceList(productPrice.getPriceList()).build();
    }
    
}
