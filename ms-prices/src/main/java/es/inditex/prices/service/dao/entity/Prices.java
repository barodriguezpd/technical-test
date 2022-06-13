package es.inditex.prices.service.dao.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "PRICES")
public class Prices {
    
    @Id
    @Column(name = "PRICE_ID")
    private int id;
    
    @Column(name = "BRAND_ID")
    private int brandId;
    
    @Column(name = "START_DATE")
    private long startDate;

    @Column(name = "END_DATE")
    private long endDate;

    @Column(name = "PRICE_LIST")
    private int priceList;

    @Column(name = "PRODUCT_ID")
    private long productId;

    @Column(name = "PRIORITY")
    private int priority;

    @Column(name = "PRICE")
    private double price;

    @Column(name = "CURR", length = 3) 
    private String currency;
    
}
