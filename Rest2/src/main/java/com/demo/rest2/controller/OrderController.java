package com.demo.rest2.controller;
import java.net.URI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.demo.rest2.model.Order;
import com.demo.rest2.service.OrderService;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;
    
    @PostMapping
    public ResponseEntity<Order> addProduct(@RequestBody Order order) {
        Order createdOrder = orderService.addOrder(order);
        String location = "/products/" + createdOrder.getId();
        return ResponseEntity.created(URI.create(location)).body(createdOrder);
    }
    @GetMapping("/{orderId}")
    public ResponseEntity<String> getOrderDetails(@PathVariable Long orderId) {
        return orderService.getOrderById(orderId)
                .map(order -> {
                    String productDetails = orderService.getProductDetails(order.getProductId());
                    return ResponseEntity.ok("Order details for ID " + orderId + "\nProduct details: " + productDetails);
                })
                .orElse(ResponseEntity.notFound().build());
    }

}
