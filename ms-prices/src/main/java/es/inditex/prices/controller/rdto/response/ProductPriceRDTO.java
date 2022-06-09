package es.inditex.prices.controller.rdto.response;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * Request DTO response with product price information
 * @author Benjamin Rodriguez
 *
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class ProductPriceRDTO {
    @ApiModelProperty(value = "Brand Id", example = "1")
    private Integer brand;
    
    @ApiModelProperty(value = "Product Id", example = "3455")
    private Integer product;
    
    @ApiModelProperty(value = "Start Date Price", example = "2021-01-30T08:30:00Z")
    private String startDate;
    
    @ApiModelProperty(value = "End Date Price", example = "2021-03-30T08:30:00Z")
    private String end_date;

    @ApiModelProperty(value = "Price", example = "25.50")
    private BigDecimal price;
    
}
