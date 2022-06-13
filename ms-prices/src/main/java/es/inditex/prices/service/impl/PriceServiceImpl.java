package es.inditex.prices.service.impl;

import es.inditex.prices.service.PriceService;
import es.inditex.prices.service.dao.PricesDao;
import es.inditex.prices.service.dao.entity.Prices;
import es.inditex.prices.service.dto.input.ProductPriceSearch;
import es.inditex.prices.service.dto.output.ProductPrice;
import es.inditex.prices.service.transformer.PriceServiceTransformer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class PriceServiceImpl implements PriceService {
    
    private final PricesDao pricesDao;
    
    private final PriceServiceTransformer transformer;
    
    @Override
    public ProductPrice searchPrice(ProductPriceSearch searchParms) {
        List<Prices> prices = pricesDao.getPrices(searchParms.getBrand(), searchParms.getProduct(), searchParms.getDate());
        prices.sort((Prices p1, Prices p2) -> Integer.compare(p1.getPriority(), p2.getPriority()));
        return transformer.getPrice(prices.get(0));
    }
    
}
