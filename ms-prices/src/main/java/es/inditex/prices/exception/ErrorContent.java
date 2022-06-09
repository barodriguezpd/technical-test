package es.inditex.prices.exception;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;

/**
 * Object information detail from response error
 * @author Benjamin Rodriguez
 *
 */
@Data
@Builder
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@ApiModel(value = "error_content", description = "Response object that represent an error in the API")
final public class ErrorContent {

    @ApiModelProperty(value = "Request Id", example = "123e4567-e89b-12d3-a456-556642440000")
    private String requestId;
    @ApiModelProperty(value = "Error message", example = "Resource not found")
    private String message;
    @ApiModelProperty(value = "Error details", example = "")
    private Object details;
}

