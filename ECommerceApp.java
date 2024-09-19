import com.ecommerce.Product;
import com.ecommerce.Customer;
import com.ecommerce.orders.Order;

import java.util.Scanner;

public class ECommerceApp {
    public static void main(String[] args) {
        Product product1 = new Product(101, "Laptop", 800.00);
        Product product2 = new Product(102, "Smartphone", 500.00);
        Product product3 = new Product(103, "Headphones", 100.00);

        Customer customer = new Customer(1, "John Doe");

        Scanner scanner = new Scanner(System.in);
        boolean shopping = true;

        while (shopping) {
            System.out.println("Available products:");
            product1.displayProductDetails();
            product2.displayProductDetails();
            product3.displayProductDetails();

            System.out.println("\nEnter the product ID to add to your cart (0 to finish):");
            int productId = scanner.nextInt();

            if (productId == 0) {
                shopping = false;
                break;
            }

            switch (productId) {
                case 101:
                    customer.addProductToCart(product1);
                    break;
                case 102:
                    customer.addProductToCart(product2);
                    break;
                case 103:
                    customer.addProductToCart(product3);
                    break;
                default:
                    System.out.println("Invalid product ID.");
            }
        }

        customer.displayCart();

        if (!customer.getShoppingCart().isEmpty()) {
            Order order = new Order(1001, customer, customer.getShoppingCart());
            order.displayOrderSummary();
        } else {
            System.out.println("No products in the cart. No order placed.");
        }

        scanner.close();
    }
}
