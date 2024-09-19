package com.ecommerce;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    private int customerID;
    private String name;
    private List<Product> shoppingCart;

    public Customer(int customerID, String name) {
        this.customerID = customerID;
        this.name = name;
        this.shoppingCart = new ArrayList<>();
    }

    public int getCustomerID() {
        return customerID;
    }

    public String getName() {
        return name;
    }

    public void addProductToCart(Product product) {
        shoppingCart.add(product);
        System.out.println(product.getName() + " has been added to your cart.");
    }

    public void removeProductFromCart(Product product) {
        if (shoppingCart.contains(product)) {
            shoppingCart.remove(product);
            System.out.println(product.getName() + " has been removed from your cart.");
        } else {
            System.out.println(product.getName() + " is not in the cart.");
        }
    }

    public double calculateTotalCost() {
        double total = 0;
        for (Product product : shoppingCart) {
            total += product.getPrice();
        }
        return total;
    }

    public List<Product> getShoppingCart() {
        return shoppingCart;
    }

    public void displayCart() {
        System.out.println("Shopping Cart for " + name + ":");
        if (shoppingCart.isEmpty()) {
            System.out.println("Your cart is empty.");
        } else {
            for (Product product : shoppingCart) {
                product.displayProductDetails();
            }
        }
    }
}
