package se.nackademin;

import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import static org.junit.Assert.assertSame;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;


public class CoffeeTest {
      Coffee coffee = new Coffee("coffeeType, 999");
 
    @Test
    public void shouldSplit(){
      assertEquals(coffee.getPrice(), 999);
    }
    
    @Test
    public void testDecaf() {
        coffee.setDecaf(false);
        assertFalse(coffee.getDecaf());

        coffee.setDecaf(true);
        assertTrue(coffee.getDecaf());
    }

    @Test
    public void testLactose() {
        coffee.setLactose(false);
        assertFalse(coffee.getDecaf());

        coffee.setLactose(true);
        assertTrue(coffee.getLactose());
    }

    @Test
    public void testSugar() {
        coffee.setSugar(false);
        assertFalse(coffee.getSugar());
        
        coffee.setSugar(true);
        assertTrue(coffee.getSugar());
    }

    @Test
    public void testGetName() {
        assertEquals(coffee.getName(), "coffeeType");
    }

    @Test
    public void testTopping(){
    coffee.setTopping(1);
    assertSame(coffee.getTopping(), "Extra milk");
    coffee.setTopping(2);
    assertSame(coffee.getTopping(), "Extra sugar");
    coffee.setTopping(3);
    assertSame(coffee.getTopping(), "Extra sugar and milk");
    coffee.setTopping(4);
    assertSame(coffee.getTopping(), "No topping");
}
}
