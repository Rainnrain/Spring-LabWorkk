package com.cydeo;
import com.cydeo.enums.CartState;
import com.cydeo.repository.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class QueryDemo implements CommandLineRunner {

    private final AddressRepository addressRepository;
    private final BalanceRepository balanceRepository;
    private final CartItemRepository cartItemRepository;
    private final CartRepository cartRepository;
    private final CustomerRepository customerRepository;
    private final DiscountRepository discountRepository;
    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;

    public QueryDemo(AddressRepository addressRepository, BalanceRepository balanceRepository, CartItemRepository cartItemRepository, CartRepository cartRepository, CustomerRepository customerRepository, DiscountRepository discountRepository, OrderRepository orderRepository, ProductRepository productRepository) {
        this.addressRepository = addressRepository;
        this.balanceRepository = balanceRepository;
        this.cartItemRepository = cartItemRepository;
        this.cartRepository = cartRepository;
        this.customerRepository = customerRepository;
        this.discountRepository = discountRepository;
        this.orderRepository = orderRepository;
        this.productRepository = productRepository;
    }


    @Override
    public void run(String... args) throws Exception {

//        System.out.println(addressRepository.findByStreet("Fordem"));
 //      System.out.println(addressRepository.getAddressByCustomer_Email("tsicklinga@4shared.com"));
  //      System.out.println(addressRepository.findAddressByCustomer_Email("cpagitt4@slate.com"));
 //     System.out.println(addressRepository.findByCustomer_FirstName("Danny"));
//        System.out.println(addressRepository.findByStreetContainsIgnoreCase("wood"));
//        System.out.println(addressRepository.addressesWithASpecificCustomerIDJPQL(2L));

      //  System.out.println(cartItemRepository.findByCartCartState(CartState.SOLD));
     //  System.out.println(cartItemRepository.cartItemsByState( "SOLD","Capon" ));
      //  System.out.println(cartItemRepository.retrieveCartsByCartStateAndProduct("Capon", "SOLD"));
   //     System.out.println(cartItemRepository.retrieveCartItemWithSpecificStateAndProductName("SOLD", "Muffin"));

      //  System.out.println(orderRepository.findByProduct("Soup"));
        //System.out.println(balanceRepository.existsBalanceByAmountGreaterThan(0.0));
        //System.out.println(balanceRepository.listMax5Balance());
        //System.out.println(balanceRepository.findBalanceByAmountGreaterThanEqual(200.00));
      //  System.out.println(balanceRepository.listOfBalancesBelow(200.00));
        System.out.println(addressRepository.findTop3ByCustomerEmail("asturton0@list-manage.com"));
    }
}
