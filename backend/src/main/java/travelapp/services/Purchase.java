package travelapp.services;

import lombok.Data;
import travelapp.entities.Cart;
import travelapp.entities.CartItem;
import travelapp.entities.Customer;

import java.util.Set;

@Data
public class Purchase {

    private Customer customer;
    private Cart cart;
    private Set<CartItem> cartItems;
}
