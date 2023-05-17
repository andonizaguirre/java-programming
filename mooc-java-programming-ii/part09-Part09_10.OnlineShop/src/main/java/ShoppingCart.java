
import java.util.HashMap;
import java.util.Map;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author andoni
 */
public class ShoppingCart {

    private Map<String, Item> cart;

    public ShoppingCart() {
        this.cart = new HashMap<>();
    }

    public void add(String product, int price) {
        if (cart.containsKey(product)) {
            cart.get(product).increaseQuantity();
        } else {
            Item cartItem = new Item(product, 1, price);
            this.cart.put(product, cartItem);
        }
//        this.cart.putIfAbsent(product, new Item(product, 0, price));
//        this.cart.get(product).increaseQuantity();
    }

    public int price() {
        int totalPrice = 0;
        for (Item cartItem : cart.values()) {
            totalPrice = totalPrice + cartItem.price();
        }
        return totalPrice;
    }

    public void print() {
        for (Item cartItem : cart.values()) {
            System.out.println(cartItem);
        }
    }
}
