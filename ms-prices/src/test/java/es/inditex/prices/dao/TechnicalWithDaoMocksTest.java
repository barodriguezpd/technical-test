package es.inditex.prices.dao;

import es.inditex.prices.service.dao.PricesDao;
import es.inditex.prices.service.dao.entity.Prices;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class TechnicalWithDaoMocksTest {

    Integer brand = new Integer(1);
    Integer product = new Integer(35455);

    @Autowired
    private MockMvc mockMvc;
    
    @MockBean
    private PricesDao priceDao;
    
    @Test
    void searchPrice1() {
        String date = "2020-06-14 10:00";
        String response = "35.5";
        when(priceDao.getPrices(any(), any(), any())).thenReturn(getPrices(response, 1));
        
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
        when(priceDao.getPrices(any(), any(), any())).thenReturn(getPrices(response, 2));
        
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
        String response = "35.5";
        when(priceDao.getPrices(any(), any(), any())).thenReturn(getPrices(response, 1));
        
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
        String response = "30.5";
        when(priceDao.getPrices(any(), any(), any())).thenReturn(getPrices(response, 3));
        
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
        when(priceDao.getPrices(any(), any(), any())).thenReturn(getPrices(response, 4));
        
        try {
            RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/price?product=" + product + "&brand=" + brand + "&date=" + date).accept(MediaType.APPLICATION_JSON);
            mockMvc.perform(requestBuilder).andDo(print()).andExpect(status().isOk()).andExpect(content().string(containsString(response)));
        } catch (Exception e) {
            e.printStackTrace();
            fail(e.getMessage());
        }
    }
    
    private List<Prices> getPrices(String price, int priceList) {
        List<Prices> prices = new ArrayList<Prices>();
        Prices pricesEntity = new Prices();
        pricesEntity.setPrice(Double.parseDouble(price));
        pricesEntity.setStartDate(202206131030l);
        pricesEntity.setEndDate(202206131030l);
        pricesEntity.setProductId(product);
        pricesEntity.setBrandId(brand);
        pricesEntity.setPriceList(priceList);
        prices.add(pricesEntity);
        return prices;
    }
}
