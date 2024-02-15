package com.example.product_app.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Voucher {

    private int voucherId;
    private String code;
    private BigDecimal discount;
    private String expireDate;


}
