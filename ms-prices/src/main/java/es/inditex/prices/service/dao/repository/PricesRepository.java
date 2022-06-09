package es.inditex.prices.service.dao.repository;

import es.inditex.prices.service.dao.entity.Prices;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository for Prices Table 
 * @author Benjamin Rodriguez
 *
 */
@Repository
public interface PricesRepository extends JpaRepository<Prices, Long> {
}
