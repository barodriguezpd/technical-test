package es.inditex.prices.service;

import es.inditex.prices.service.dto.input.ProductPriceSearch;
import es.inditex.prices.service.dto.output.ProductPrice;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ServiceTest {

    private PriceService service = mock(PriceService.class);
    
    @Test
    void searchPrice() {
        when(service.searchPrice(any())).thenReturn(mock(ProductPrice.class));
        ProductPriceSearch searchParms = null;
        ProductPrice productPrice = service.searchPrice(searchParms);
        assertNotNull(productPrice);
    }
}
