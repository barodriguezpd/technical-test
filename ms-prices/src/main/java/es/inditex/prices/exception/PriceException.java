package es.inditex.prices.exception;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;

/**
 * Object for Price Exception with error
 * @author Benjamin Rodriguez
 *
 */
@Data
@Builder
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@ApiModel(value = "error", description = "Response object that represent an error in the API")
final public class PriceException {

    @ApiModelProperty(value = "error")
    private ErrorContent error;
}

