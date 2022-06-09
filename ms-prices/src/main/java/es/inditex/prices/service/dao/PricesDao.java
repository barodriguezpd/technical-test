package es.inditex.prices.service.dao;

import es.inditex.prices.service.dao.entity.Prices;

import java.util.Date;
import java.util.List;

/**
 * Dao Interface for management prices
 * @author Benjamin Rodriguez
 *
 */
public interface PricesDao {
    
    public List<Prices> getPrices(Integer brand, Integer product, Date date);
    
}
