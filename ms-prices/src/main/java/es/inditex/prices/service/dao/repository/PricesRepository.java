package es.inditex.prices.service.dao.repository;

import es.inditex.prices.service.dao.entity.Prices;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Repository for Prices Table 
 * @author Benjamin Rodriguez
 *
 */
@Repository
public interface PricesRepository extends JpaRepository<Prices, Long> {
    
    @Query("select p from Prices p where p.brandId = :brand and p.productId = :product and p.startDate <= :date and p.endDate >= :date")
    List<Prices> findPriceByBrandProduct(int brand, long product, long date);
    
}
