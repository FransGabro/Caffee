package se.nackademin;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import org.junit.jupiter.api.Test;


public class CustomerTest {
    Coffee kaffe = new Coffee("Oboy, 123");
    Customer c = new Customer("test");
    
    @Test
    public void testOrderID() {

        c.orderID();
        assertEquals(c.orderID(), "test");
    }

    @Test
    public void testTotPrice() {

        c.addToOrder(kaffe);
        assertSame(c.totPrice(), 123);
    }
    
}
