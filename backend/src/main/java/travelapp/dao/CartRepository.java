package travelapp.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import travelapp.entities.Cart;

@CrossOrigin(value = "http://localhost:4200")
public interface CartRepository extends JpaRepository<Cart, Long> {
}
