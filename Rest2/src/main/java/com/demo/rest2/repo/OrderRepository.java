package com.demo.rest2.repo;
import org.springframework.data.jpa.repository.JpaRepository;
import com.demo.rest2.model.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
