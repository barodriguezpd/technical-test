package es.inditex.prices.controller;

import es.inditex.prices.controller.rdto.response.ProductPriceRDTO;
import es.inditex.prices.exception.MainException;
import es.inditex.prices.exception.PriceException;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Controller for api services
 * @author Benjamin Rodriguez
 *
 */
public interface PriceController {
    
    /**
     * Request completed successfully.
     */
    String API_RESPONSE_200 = "Request completed successfully.";
    /**
     * Request completed successfully. No content.
     */
    String API_RESPONSE_204 = "Request completed successfully. No content.";
    /**
     * Resource not found.
     */
    String API_RESPONSE_404 = "Resource not found.";
    /**
     * Precondition failed.
     */
    String API_RESPONSE_412 = "Precondition failed.";
    /**
     * Server error.
     */
    String API_RESPONSE_500 = "Server error.";
    /**
     * Price Path
     */
    String PRICE_PATH = "/price";

    /**
     * @param GPEROrderRQRDTO
     * @return
     * @throws MainException
     */
    @ApiOperation(value = "getPrice")
    @ApiResponses(value = {
        @ApiResponse(code = 404, message = API_RESPONSE_404, response = PriceException.class),
        @ApiResponse(code = 500, message = API_RESPONSE_500, response = PriceException.class)
    })
    @RequestMapping(value = PRICE_PATH, method = RequestMethod.GET, produces = {
        MediaType.APPLICATION_JSON_VALUE})
    ProductPriceRDTO getPrice(
        @ApiParam(value = "Brand Id") @RequestParam(value = "brand", required = true) Integer brand,
        @ApiParam(value = "Product") @RequestParam(value = "product", required = true) Integer product,
        @ApiParam(value = "Date") @RequestParam(value = "date", required = true) String date)
        throws es.inditex.prices.exception.MainException;}
