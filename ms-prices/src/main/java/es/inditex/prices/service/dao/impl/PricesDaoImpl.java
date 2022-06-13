package es.inditex.prices.service.dao.impl;

import es.inditex.prices.service.dao.PricesDao;
import es.inditex.prices.service.dao.entity.Prices;
import es.inditex.prices.service.dao.repository.PricesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Component
@RequiredArgsConstructor
public class PricesDaoImpl implements PricesDao {
    
    private final PricesRepository pricesRepository;
    
    @Override
    public List<Prices> getPrices(Integer brand, Long product, Date date) {
        return pricesRepository.findPriceByBrandProduct(brand, product, new Timestamp(date.getTime()));
    }
    
}
