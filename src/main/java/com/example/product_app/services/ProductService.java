package com.example.product_app.services;

import com.example.product_app.dto.Voucher;
import com.example.product_app.model.Product;
import com.example.product_app.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private RestTemplate restTemplate;

    @Value("${voucherService.url}")
    private String voucherServiceUrl;

    public Product createNewProduct(Product product) {
        Voucher voucher = restTemplate.getForObject(voucherServiceUrl + product.getVoucherCode(), Voucher.class);
        BigDecimal multiplier = new BigDecimal("100");
        product.setPrice(product.getPrice().subtract(product.getPrice().multiply(voucher.getDiscount()).divide(multiplier)));
        return productRepository.save(product);
    }

}
