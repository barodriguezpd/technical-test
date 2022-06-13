package es.inditex.prices.service.dao.impl;

import es.inditex.prices.service.dao.PricesDao;
import es.inditex.prices.service.dao.entity.Prices;
import es.inditex.prices.service.dao.repository.PricesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Component
@RequiredArgsConstructor
public class PricesDaoImpl implements PricesDao {
    
    private final PricesRepository pricesRepository;
    
    @Override
    public List<Prices> getPrices(Integer brand, Long product, Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmm");
        return pricesRepository.findPriceByBrandProduct(brand, product, Long.parseLong(sdf.format(date)));
    }
    
}
