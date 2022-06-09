package es.inditex.prices.service.dao.impl;

import es.inditex.prices.service.dao.PricesDao;
import es.inditex.prices.service.dao.entity.Prices;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@Component
@RequiredArgsConstructor
public class PricesDaoImpl implements PricesDao {
    
    @Override
    public List<Prices> getPrices(Integer brand, Integer product, Date date) {
        return null;
    }
    
}
