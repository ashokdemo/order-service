package com.demo.aws.cicd.example;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class OrderDaoTest {

    @Autowired
    private OrderDao orderDao;

    @Test
    public void testGetOrders() {
        List<Order> orders = orderDao.getOrders();
        assertNotNull(orders, "Orders list should not be null");
        assertEquals(4, orders.size(), "Orders list size should be 4");

        Order firstOrder = orders.get(0);
        assertEquals(101, firstOrder.getId(), "First order ID should be 101");
        assertEquals("Mobile", firstOrder.getName(), "First order name should be Mobile");
        assertEquals(1, firstOrder.getQuantity(), "First order quantity should be 1");
        assertEquals(30000, firstOrder.getPrice(), "First order price should be 30000");
    }
}
