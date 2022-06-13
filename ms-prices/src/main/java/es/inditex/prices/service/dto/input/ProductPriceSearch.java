package es.inditex.prices.service.dto.input;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

/**
 * DTO for input search services
 * @author Benjamin Rodriguez
 *
 */
@Data
@Builder
public class ProductPriceSearch {
    
    private Long product;
    
    private Integer brand;
    
    private Date date;

}
