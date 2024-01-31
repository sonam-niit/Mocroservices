package com.demo.rest2.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.client.RestTemplate;

import com.demo.rest2.model.Order;
import com.demo.rest2.repo.OrderRepository;

import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private RestTemplate restTemplate;

    public Optional<Order> getOrderById(Long orderId) {
        return orderRepository.findById(orderId);
    }

    public String getProductDetails(Long productId) {
        ResponseEntity<String> productResponse = restTemplate.getForEntity(
                "http://localhost:8081/api/products/" + productId, String.class);

        return productResponse.getBody();
    }
    public Order addOrder(@RequestBody Order order) {
    	return orderRepository.save(order);
    }
}
