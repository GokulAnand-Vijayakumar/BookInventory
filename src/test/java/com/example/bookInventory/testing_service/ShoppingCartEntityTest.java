package com.example.bookInventory.testing_service;

import com.example.bookInventory.entity.ShoppingCart;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ShoppingCartEntityTest {

    @Test
    void testConstructorAndGetters() {
        ShoppingCart cart = new ShoppingCart(1L, 101, "9781234567890");

        assertEquals(1L, cart.getCartId());
        assertEquals(101, cart.getUserId());
        assertEquals("9781234567890", cart.getIsbn());
    }

    @Test
    void testSetters() {
        ShoppingCart cart = new ShoppingCart();
        cart.setCartId(2L);
        cart.setUserId(202);
        cart.setIsbn("9780987654321");

        assertEquals(2L, cart.getCartId());
        assertEquals(202, cart.getUserId());
        assertEquals("9780987654321", cart.getIsbn());
    }

    @Test
    void testToString() {
        ShoppingCart cart = new ShoppingCart(3L, 303, "9781111111111");
        String expected = "ShoppingCart [cartId=3, userId=303, isbn=9781111111111]";
        assertEquals(expected, cart.toString());
    }
}