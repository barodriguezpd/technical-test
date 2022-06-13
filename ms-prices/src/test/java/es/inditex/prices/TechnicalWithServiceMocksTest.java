package es.inditex.prices;

import es.inditex.prices.service.PriceService;
import es.inditex.prices.service.dto.output.ProductPrice;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.math.BigDecimal;
import java.util.Date;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class TechnicalWithMocksTest {

    Integer brand = new Integer(1);
    Integer product = new Integer(35455);

    @Autowired
    private MockMvc mockMvc;
    
    @MockBean
    private PriceService service;
    
    @Test
    void searchPrice1() {
        String date = "2020-06-14 10:00";
        String response = "35.50";
        when(service.searchPrice(any())).thenReturn(getProductPrice(response));
        
        try {
            RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/price?product=" + product + "&brand=" + brand + "&date=" + date).accept(MediaType.APPLICATION_JSON);
            mockMvc.perform(requestBuilder).andDo(print()).andExpect(status().isOk()).andExpect(content().string(containsString(response)));
        } catch (Exception e) {
            e.printStackTrace();
            fail(e.getMessage());
        }
    }

    @Test
    void searchPrice2() {
        String date = "2020-06-14 16:00";
        String response = "25.45";
        when(service.searchPrice(any())).thenReturn(getProductPrice(response));
        
        try {
            RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/price?product=" + product + "&brand=" + brand + "&date=" + date).accept(MediaType.APPLICATION_JSON);
            mockMvc.perform(requestBuilder).andDo(print()).andExpect(status().isOk()).andExpect(content().string(containsString(response)));
        } catch (Exception e) {
            e.printStackTrace();
            fail(e.getMessage());
        }
    }

    @Test
    void searchPrice3() {
        String date = "2020-06-14 21:00";
        String response = "35.50";
        when(service.searchPrice(any())).thenReturn(getProductPrice(response));
        
        try {
            RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/price?product=" + product + "&brand=" + brand + "&date=" + date).accept(MediaType.APPLICATION_JSON);
            mockMvc.perform(requestBuilder).andDo(print()).andExpect(status().isOk()).andExpect(content().string(containsString(response)));
        } catch (Exception e) {
            e.printStackTrace();
            fail(e.getMessage());
        }
    }

    @Test
    void searchPrice4() {
        String date = "2020-06-15 10:00";
        String response = "30.50";
        when(service.searchPrice(any())).thenReturn(getProductPrice(response));
        
        try {
            RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/price?product=" + product + "&brand=" + brand + "&date=" + date).accept(MediaType.APPLICATION_JSON);
            mockMvc.perform(requestBuilder).andDo(print()).andExpect(status().isOk()).andExpect(content().string(containsString(response)));
        } catch (Exception e) {
            e.printStackTrace();
            fail(e.getMessage());
        }
    }

    @Test
    void searchPrice5() {
        String date = "2020-06-16 21:00";
        String response = "38.95";
        when(service.searchPrice(any())).thenReturn(getProductPrice(response));
        
        try {
            RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/price?product=" + product + "&brand=" + brand + "&date=" + date).accept(MediaType.APPLICATION_JSON);
            mockMvc.perform(requestBuilder).andDo(print()).andExpect(status().isOk()).andExpect(content().string(containsString(response)));
        } catch (Exception e) {
            e.printStackTrace();
            fail(e.getMessage());
        }
    }
    
    private ProductPrice getProductPrice(String price) {
        Date dateTest = new Date();
        ProductPrice productPrice = ProductPrice.builder().brand(brand).product(product).price(new BigDecimal(price)).priceList(1).startDate(dateTest).endDate(dateTest).build();
        return productPrice;
    }
}
