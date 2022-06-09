package es.inditex.prices.service.dto.input;

import lombok.Builder;
import lombok.Data;

/**
 * DTO for input search services
 * @author Benjamin Rodriguez
 *
 */
@Data
@Builder
public class ProductPriceSearch {
    
    private Integer product;
    
    private Integer brand;
    
    private String date;

}
