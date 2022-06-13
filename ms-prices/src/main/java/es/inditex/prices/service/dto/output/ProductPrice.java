package es.inditex.prices.service.dto.output;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * DTp for output price information
 * @author Benjamin Rodriguez
 *
 */
@Data
@Builder
public class ProductPrice {
    
    private Integer product;
    
    private Integer brand;
    
    private Integer priceList;
    
    private Date startDate;
    
    private Date endDate;
    
    private Double price;
    
}
