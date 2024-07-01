package cz.kot.order.repository;

import cz.kot.order.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository - communicates with the MySQL database
 */
public interface OrderRepository extends JpaRepository<Order, Long> {
}
