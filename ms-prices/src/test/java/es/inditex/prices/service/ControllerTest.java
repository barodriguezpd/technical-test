package es.inditex.prices.service;

import es.inditex.prices.controller.PriceController;
import es.inditex.prices.controller.impl.PriceControllerImp;
import es.inditex.prices.controller.rdto.response.ProductPriceRDTO;
import es.inditex.prices.controller.transformer.PriceControllerTransformer;
import es.inditex.prices.exception.MainException;
import es.inditex.prices.service.dto.input.ProductPriceSearch;
import es.inditex.prices.service.dto.output.ProductPrice;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ControllerTest {

    
    private PriceService service = mock(PriceService.class);
    
    private PriceControllerTransformer transformer = mock(PriceControllerTransformer.class);

    private PriceController controller = new PriceControllerImp(transformer, service);
    
    @Test
    void searchPrice() {
        try {
            when(service.searchPrice(any())).thenReturn(mock(ProductPrice.class));
            when(transformer.getProductPriceSearch(any(), any(), any())).thenReturn(mock(ProductPriceSearch.class));
            when(transformer.getProductPriceRDTO(any())).thenReturn(mock(ProductPriceRDTO.class));
            when(service.searchPrice(any())).thenReturn(mock(ProductPrice.class));
            ProductPriceRDTO price = controller.getPrice(any(), any(), any());
            assertNotNull(price);
        } catch(MainException e) {
            fail(e.getMessage());
        }
    }
}
