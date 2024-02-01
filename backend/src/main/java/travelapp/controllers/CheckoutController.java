package travelapp.controllers;

import org.springframework.web.bind.annotation.*;
import travelapp.services.CheckoutService;
import travelapp.services.Purchase;
import travelapp.services.PurchaseResponse;

import java.util.UUID;

/*  This controller listens for POST requests at the /api/checkout/purchase endpoint,
    processes the incoming data as a Purchase object,
    uses a service to handle the business logic related to the purchase,
    and then returns a PurchaseResponse back to the client.
 */

// @Cross Origin allows the controller to accept requests from the specified origin
@CrossOrigin
@RestController
@RequestMapping("/api/checkout")
public class CheckoutController {

    private final CheckoutService checkoutService;

    // constructor-based dependency injection of CheckoutService into the
    // CheckoutController when an instance of the latter is created
    public CheckoutController(CheckoutService checkoutService) {
        // establish the dependency link
        this.checkoutService = checkoutService;
    }

    // @PostMapping defines a method to handle HTTP POST requests
    // made to /api/checkout/purchase
    // @RequestBody 'Purchase purchase' tells Spring to convert the incoming HTTP request's
    // body into a Purchase object, which is then stored in the purchaseResponse variable
    @PostMapping("/purchase")
    public PurchaseResponse placeOrder(@RequestBody Purchase purchase) {
        return checkoutService.placeOrder(purchase);
    }
}
