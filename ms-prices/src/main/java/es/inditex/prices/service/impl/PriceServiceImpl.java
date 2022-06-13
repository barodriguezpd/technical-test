package es.inditex.prices.service.impl;

import es.inditex.prices.exception.MainException;
import es.inditex.prices.exception.ResourceNotFoundException;
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
    public ProductPrice searchPrice(ProductPriceSearch searchParms) throws MainException {
        List<Prices> prices = pricesDao.getPrices(searchParms.getBrand(), searchParms.getProduct(), searchParms.getDate());
        if (prices.isEmpty())
            throw new ResourceNotFoundException("No encontro registros con los datos indicados");
        prices.sort((Prices p1, Prices p2) -> Integer.compare(p2.getPriority(), p1.getPriority()));
        return transformer.getPrice(prices.get(0));
    }
    
}
